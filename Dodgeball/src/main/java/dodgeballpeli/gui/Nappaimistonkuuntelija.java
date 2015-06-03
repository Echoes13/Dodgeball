
package dodgeballpeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import dodgeballpeli.domain.Vaistaja;

/**
  * Luokka joka toimii näppäinten kuuntelijana ja reagoi
  * pelaajan näppäimistöön
  * Luokka laajentaa luokkaa KeyListener
  */  
public class Nappaimistonkuuntelija implements KeyListener {
    
/**
  * @param dodgeball Pelin päivittäjä joka pitää pelin käynnissä
  * @param pelaaja Pelin pelaajahahmo
  */      
    private PeliPaivittaja dodgeball;
    private Vaistaja pelaaja;
    
/**
  * Konstruktorissa asetetaan kuuntelijalle päivittäjä, sekä
  * pelaajahahmo
  * 
  * @param dodgeball pelin päivittäjä
  */      
    public Nappaimistonkuuntelija(PeliPaivittaja dodgeball) {
        this.dodgeball = dodgeball;
        this.pelaaja = dodgeball.haeLogiikka().haePelaaja();
    }

/**
  * Metodi joka reagoi näppäimistöön, ei toimintoa tässä
  * 
  * @param e näppäin
  */      
    @Override
    public void keyTyped(KeyEvent e) {
    }

/**
  * Metodi joka reagoi painettuihin näppäimiin seuraavasti
  * Välilyönnistä paussaa pelin
  * Vasemmasta nuolinäppäimestä liikuttaa vasemmalle
  * Oikeasta nuolinäppäimestä liikuttaa oikealle jne
  * 
  * @param e painettu näppäin
  */      
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            dodgeball.pauseTaiJatka();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.setSuuntaX(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.setSuuntaX(1);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.setSuuntaY(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.setSuuntaY(1);
        }
    }

/**
  * Metodi joka reagoi näppäimiin jotka päästetään,
  * nollaa pelaajahahmon suunnan päästämällä irti
  * nuolinäppäimistä jotta pelaajahahmo ei liikkuisi
  * napin päästämisen jälkeen
  * 
  * @param e päästetty näppäin
  */      
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.setSuuntaX(0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.setSuuntaX(0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.setSuuntaY(0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.setSuuntaY(0);
        }
    }
    
    
}