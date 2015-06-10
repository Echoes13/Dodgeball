
package dodgeballpeli.gui;

import dodgeballpeli.domain.Pallo;
import dodgeballpeli.peli.PeliLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
  * Luokka joka edistää peliä liikuttamalla osia
  * ja päivittämällä piirtoalustaa
  */
public class PeliEdistaja extends Timer implements ActionListener{
    
/**
  * @param dodgeball Valvoja joka lisää pisteitä
  * @param logiikka Pelin logiikka
  * @param pause Merkintä siitä onko peli pausella
  * @param piirtoalusta Pelin piirtoalusta
  */    
    private PeliValvoja dodgeball;
    private PeliLogiikka logiikka;
    private boolean pause;
    private Paivitettava piirtoalusta;
    
/**
  * Konstruktorissa asetetaan Timer-luokan parametrit, sekä
  * parametrit pelin pyörittämistä varten
  * 
  * @param dodgeballpeli pelin valvoja pisteiden lisäämiseen
  */    
    public PeliEdistaja(PeliValvoja dodgeballpeli) {
        super(10,null);
        this.dodgeball = dodgeballpeli;
        this.logiikka = dodgeballpeli.haeLogiikka();
        this.piirtoalusta = dodgeballpeli.haePaivitettava();
        this.pause = false;
        addActionListener(this);
        setInitialDelay(1000);
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
        logiikka.setPause(pause);
    }
    
    /**
  * Metodi joka kertoo onko peli pausella
  * 
  * @return peli pausella tai ei
  */    
    public boolean pausella() {
        return pause;
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
        piirtoalusta.paivita();
        for (Pallo pallo : logiikka.haeKori().getPallot()) {
            if (logiikka.haePelaaja().osuuPalloon(pallo)) {
                pause = true;
                logiikka.setLose(true);
                piirtoalusta.paivita();
                return;
            }
        }
        if (!pause) {
            logiikka.etene();
            dodgeball.nykyinenTulos();
        }
    }
}
