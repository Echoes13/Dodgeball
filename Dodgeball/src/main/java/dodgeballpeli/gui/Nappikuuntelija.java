
package dodgeballpeli.gui;

import dodgeballpeli.peli.PeliLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
  * Luokka joka reagoi painettuihin nappeihin jotka
  * löytyvät graafisesta käyttöliittymästä
  * Luokka toteuttaa rajapinnan ActionListener
  */  
public class Nappikuuntelija implements ActionListener {
    
/**
  * @param restart Nappi uudelle pelille
  * @param submit Nappi Highscore-listalle
  * @param dodgeballpeli Pelin päivittäjä
  */      
    private JButton restart;
    private JButton submit;
    private PeliPaivittaja dodgeballpeli;
    
/**
  * Konstruktorissa asetetaan restart- ja highscore-napit,
  * sekä pelin päivittäjä
  * 
  * @param restart nappi uudelle pelille
  * @param submit nappi Highscore-listalle
  * @param peli pelin päivittäjä
  */      
    public Nappikuuntelija(JButton restart, JButton submit, PeliPaivittaja peli) {
        this.restart = restart;
        this.submit = submit;
        this.dodgeballpeli = peli;
    }

/**
  * Metodi joka suorittaa nappien toiminnot
  * KESKENERÄINEN
  */      
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restart) {
            
        }
        if (e.getSource() == submit) {
            
        }
    }
    
    
}
