
package dodgeballpeli.domain;

import java.awt.Rectangle;

/**
  * Luokka joka määrittelee pelissä olevan pelaajan hahmon
  * Luokka toteuttaa rajapinnan Liikkuva
  */
public class Vaistaja implements Liikkuva {
    
/**
  * @param pelinLeveys Pelin oikeanpuoleinen reuna
  * @param pelinKorkeus Pelin alareuna
  * @param pelaajanLeveys Pelaajahahmon määritelty leveys (ja korkeus)
  * @param x Pelaajahahmon vasemman yläkulman x-koordinaatti
  * @param xa Pelaajahahmon suunta x-linjalla
  * @param y Pelaajahahmon vasemman yläkulman y-koordinaatti
  * @param ya Pelaajahahmon suunta y-linjalla
  */    
    final private int pelinLeveys;
    final private int pelinKorkeus;
    final private int pelaajanLeveys = 20;
    int x;
    int xa;
    int y;
    int ya;
    
    
/**
  * Konstruktorissa määritetään pelialueen rajat, sekä pelaajan
  * alkupiste ja -suunta
  * 
  * @param leveys pelin oikeanpuoleinen reuna
  * @param korkeus pelin alareuna
  */    
    public Vaistaja(int leveys, int korkeus) {
        this.pelinLeveys = leveys;
        this.pelinKorkeus = korkeus;
        this.x = leveys/2-pelaajanLeveys/2;
        this.y = korkeus/2-pelaajanLeveys/2;
        xa = 0;
        ya = 0;
    }

/**
  * Metodi jolla haetaan pelaajahahmon vasemman yläreunan x-koordinaatti
  * 
  * @return pelaajahahmon x-koordinaatti
  */
    public int haeX() {
        return x;
    }

/**
  * Metodi jolla haetaan pelaajahahmon vasemman yläreunan y-koordinaatti
  * 
  * @return pelaajahahmon y-koordinaatti
  */
    public int haeY() {
        return y;
    }
    
/**
  * Metodi jolla haetaan pelaajahahmon leveys/korkeus
  * 
  * @return pelaajahahmon leveys/korkeus
  */    
    public int haeLeveys() {
        return pelaajanLeveys;
    }
    
/**
  * Metodi jolla asetetaan pelaajahahmon suunta x-linjassa
  * 
  * @param suuntaX uusi suunta x-linjassa
  */    
    public void setSuuntaX(int suuntaX) {
        xa = suuntaX;
    }
    
/**
  * Metodi jolla asetetaan pelaajahahmon suunta y-linjassa
  * 
  * @param suuntaY uusi suunta y-linjassa
  */       
    public void setSuuntaY(int suuntaY) {
        ya = suuntaY;
    }
    
/**
  * Metodi jolla katsotaan osuuko kyseessä oleva pallo
  * pelaajahahmoon katsomalla jos molempien neliörajat
  * (hitboxes) leikkaavat toisensa
  * 
  * @param kohde tarkasteltava pallo
  * 
  * @return pallon osuminen
  */       
    public boolean osuuPalloon(Pallo kohde) {
        if (haeRajat().intersects(kohde.haeRajat())) {
            return true;
        }
        return false;
    }
    
/**
  * Metodi jolla haetaan pelaajahahmon rajat törmäystä hakiessa
  * Metodi palauttaa neliön joka on pelaajahahmon kokoinen
  * 
  * @return pelaajahahmon rajat
  * 
  * @see dodgeballpeli.domain.Vaistaja#osuuPalloon(Pallo) 
  */       
    public Rectangle haeRajat() {
        return new Rectangle(x,y,pelaajanLeveys,pelaajanLeveys);
    }
    
/**
  * Metodi joka vaaditaan rajapinnan toteuttamiseksi
  * Metodi tarkistaa ettei pelaajahahmo ole menemässä
  * omien liikkumisrajojen yli, jonka jälkeen pelaaja-
  * hahmoa liikutetaan askeleen verran
  */      
    @Override
    public void liiku() {
        if (x + xa > 11 && x + xa + pelaajanLeveys < pelinLeveys - 10) {
            x = x+xa;
        }
        if (y + ya > 0 && y + ya + pelaajanLeveys < pelinKorkeus) {
           y = y+ya;
        }
    }
    
/**
  * Metodilla haetaan pelaajahahmon sijaintia tekstinä
  * 
  * @return pelaajahahmon vasemman yläkulman koordinaatti
  */    
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
    
}
