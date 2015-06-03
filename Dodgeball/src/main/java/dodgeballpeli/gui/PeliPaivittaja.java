
package dodgeballpeli.gui;

import dodgeballpeli.domain.Pallo;
import dodgeballpeli.peli.PeliLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
  * Luokka joka pitää koko peliä käynnissä päivittämällä
  * tilannetta joka sadasosa-sekunti
  * Luokka laajentaa luokkaa Timer ja toteuttaa
  * rajapinnan ActionListener
  */
public class PeliPaivittaja extends Timer implements ActionListener{
    
/**
  * @param logiikka Pelin logiikka
  * @param paivitettava Piirtoalusta joka tulee päivittää
  * @param tuloskentta Kenttä jossa näkyy saavutetut pisteet
  * @param pause Merkintänä tuleeko peliä paussata
  */    
    PeliLogiikka logiikka;
    Paivitettava paivitettava;
    JTextField tuloskentta;
    boolean pause;

/**
  * Konstruktorissa asetetaan Timer-luokan vaaditut
  * parametrit, jonka jälkeen asetetaan pelin logiikka
  * ja asettaa pelin pauselle jotta peli ei heti käynnistyisi,
  * ja myös että peli ei ole päättynyt
  * Päivittäjä asettaa itsensä pelin pyörittäjäksi ja
  * varmistaa ettei mitään tapahdu ensimmäisen sekunnin aikana
  */    
    public PeliPaivittaja(int leveys, int korkeus) {  
        super(10, null);
        this.logiikka = new PeliLogiikka(leveys,korkeus);
        this.pause = true;
        addActionListener(this);
        setInitialDelay(1000);
    }
    
/**
  * Metodi asettaa piirtoalustan päivittäjälle
  * 
  * @param paivitettava päivitettävä piirtoalusta
  */    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
/**
  * Metodi asettaa pistenäkymän päivittäjälle
  * 
  * @param tulos tulosruutu josta näkyy nykyiset pisteet
  */    
    public void setTuloskentta(JTextField tulos) {
        this.tuloskentta = tulos;
    }
    
/**
  * Metodi joka palauttaa pelin logiikan
  * 
  * @return pelin logiikka
  */    
    public PeliLogiikka haeLogiikka() {
        return logiikka;
    }
    
/**
  * Metodi joka asettaa pelin pauselle tai
  * jatkaa peliä jos peli jo on pausella
  */    
    public void pauseTaiJatka() {
        if (pause) {
            pause = false;
        } else {
            pause = true;
        }
    }
    
/**
  * Metodi joka luo uuden pelin
  */    
    public void luoUusiPeli() {
        logiikka = new PeliLogiikka(logiikka.getLeveys(),logiikka.getKorkeus());
        
    }
    
/**
  * Metodi joka suorittaa pelin tapahtumat
  * Metodi tarkistaa jos joku palloista osuu pelaajaan,
  * joka johtaa pelin päättymiseen
  * Jos peli ei ole pausella peli päivittyy
  * 
  * @param e tapahtuma
  */    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Pallo pallo : logiikka.haeKori().getPallot()) {
            if (logiikka.haePelaaja().osuuPalloon(pallo)) {
                return;
            }
        }
        if (!pause) {
            logiikka.etene();
            paivitettava.paivita();
            tuloskentta.setText("Score: " + logiikka.haePisteet());
        }
    }

}
