
package dodgeballpeli.domain;

import java.awt.Rectangle;
import java.util.Random;

/**
  * Luokka joka määrittelee pelissä olevan pallon
  * Luokka toteuttaa rajapinnan Liikkuva
  */
public class Pallo implements Liikkuva {
    
/**
  * @param pallonHalkaisija Pallon halkaisija
  * @param alaseina Pelin alareuna
  * @param sivuraja Pelin oikeanpuoleinen reuna
  * @param satu Satunnaisuus jota käytetään pallon suuntaamiseen
  * @param x Pallon vasemman yläkulman x-koordinaatti
  * @param xa Pallon suunta x-linjalla
  * @param y Pallon vasemman yläkulman y-koordinaatti
  * @param ya Pallon suunta y-linjalla
  */    
    final private int pallonHalkaisija = 20;
    final private int alaseina;
    final private int sivuraja;
    private Random satu;
    private int x;
    private int xa;
    private int y;
    private int ya;
    
    
/**
  * Konstruktorissa asetetaan pallolle aloituskoordinaatti,
  * liikkumisrajat, satunnaisuus, sekä pallon alkusuunta
  * 
  * @param heittoPiste Pallon y-koordinaatti alussa
  * @param alaseina Pelin alareuna
  * @param sivu Pelin oikeanpuoleinen reuna
  */    
    public Pallo(int heittoPiste, int alaseina, int sivu) {
        this.x = -1*pallonHalkaisija;
        this.y = heittoPiste;
        this.alaseina = alaseina;
        this.sivuraja = sivu;
        this.satu = new Random();
        xa = 1;
        ya = 1 - satu.nextInt(3);
    }
    
/**
  * Metodi jolla haetaan pallon vasemman yläreunan x-koordinaatti
  * 
  * @return pallon x-koordinaatti
  */
    public int haeX() {
        return x;
    }

/**
  * Metodi jolla haetaan pallon vasemman yläreunan y-koordinaatti
  * 
  * @return pallon y-koordinaatti
  */
    public int haeY() {
        return y;
    }
    
/**
  * Metodi jolla haetaan pallon halkaisija
  * 
  * @return pallon halkaisijan pituus
  */
    public int haeHalkaisija() {
        return pallonHalkaisija;
    }
    
/**
  * Metodi jolla katsotaan onko pallo menossa ylä- tai alarajan ylitse
  * Jos on menossa rajan yli, pallon suunta muutetaan vastakkaiseen suuntaan
  */    
    private void osuuSeinaan() {
        if (y + ya < 0 || y + ya + pallonHalkaisija > alaseina) {
            ya *= -1;
        }
    }
    
/**
  * Metodi jolla annetaan pallon mennä halkaisijansa verran ulos vasemmalta
  * tai oikealta reunalta, jonka jälkeen pallon suunta x-linjassa muutetaan
  * vastakkaiseen suuntaan, ja suunta y-linjassa määritetään uudestaan 
  * satunnaisesti
  */
    public void heittoTakaisin() {
        if (x + pallonHalkaisija < 0 || x > sivuraja) {
            xa *= -1;
            ya = 1 - satu.nextInt(3);
        }
    }
    
/**
  * Metodi jolla asetetaan pallon suunta y-linjassa, käytetään lähinnä
  * testaamisen yhteydessä
  * 
  * @param suunta Uusi suunta joka asetetaan y-linjassa
  */
    public void setSuuntaY(int suunta) {
        ya = suunta;
    }
    
/**
  * Metodi joka vaaditaan rajapinnan toteuttamiseksi
  * Metodi tarkistaa pallon suunnan, ja liikuttaa tämän jälkeen
  * palloa askeleen verran määritellyssä suunnassa
  */    
    @Override
    public void liiku() {
        heittoTakaisin();
        osuuSeinaan();
        x += xa;
        y += ya;
    }
    
/**
  * Metodi jolla haetaan pallon rajat törmäystä hakiessa
  * Metodi palauttaa neliön joka on pallon kokoinen
  * 
  * @return pallon rajat
  * 
  * @see dodgeballpeli.domain.Vaistaja#osuuPalloon(Pallo) 
  */    
    public Rectangle haeRajat() {
        return new Rectangle(x,y,pallonHalkaisija,pallonHalkaisija);
    }
    
/**
  * Metodilla haetaan pallon sijaintia tekstinä
  * 
  * @return pallon vasemman yläkulman koordinaatti
  */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
