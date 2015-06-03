
package dodgeballpeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import dodgeballpeli.peli.PeliLogiikka;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
  * Luokka joka rakentaa graafisen käyttöliittymän ja
  * käsittelee pelaajan ja pelin välistä yhteyttä
  * Luokka toteuttaa rajapinnan Runnable
  */
public class Kayttoliittyma implements Runnable {

/**
  * @param frame Pelin ruutu
  * @param dodgeballpeli Pelin päivittäjä
  * @param piirtoalusta Pelin piirtoalusta
  */    
    private JFrame frame;
    private PeliPaivittaja dodgeballpeli;
    private PiirtoAlusta piirtoalusta;

/**
  * Konstruktorissa asetetaan käyttöliittymälle päivittäjä
  * 
  * @param dodgeballpeli pelin päivittäjä
  */    
    public Kayttoliittyma(PeliPaivittaja dodgeballpeli) {
        this.dodgeballpeli = dodgeballpeli;
    }

/**
  * Metodi rakentaa graafisen käyttöliittymän ja asettaa
  * peliruudun tietyn kokoisena tietylle kohtaa koneen ruutua
  * Metodi antaa ruudulle perusominaisuudet ja luo
  * käyttöliittymän komponentit, jonka jälkeen metodi
  * varmistaa että pelaaja näkee ruudun oikean kokoisena
  */    
    @Override
    public void run() {
        frame = new JFrame("Dodgeball");
        int leveys = dodgeballpeli.haeLogiikka().getLeveys() * 2;
        int korkeus = dodgeballpeli.haeLogiikka().getKorkeus() + 22;

        frame.setPreferredSize(new Dimension(leveys, korkeus));
        
        
        frame.setLocation(400, 150);
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);        
    }

/**
  * Metodi luo käyttöliittymän komponentit ja asettaa
  * ne paikoillensa, peliruutu vasemmalle, valikko oikealle
  * 
  * @param container käyttöliittymän ruutu
  */    
    public void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(1, 2));
        
        piirtoalusta = new PiirtoAlusta(dodgeballpeli.haeLogiikka());
        frame.addKeyListener(new Nappaimistonkuuntelija(dodgeballpeli));
        
        container.add(piirtoalusta);
        luoValikko(container);
    }
    
/**
  * Metodi luo valikon johon kuuluu pistekentät ja
  * napit josta voi aloittaa uuden pelin ja lisätä
  * tuloksensa Highscore-listalle
  * 
  * @param container käyttöliittymän ruutu
  */    
    public void luoValikko(Container container) {
        JPanel valikko = new JPanel(new GridLayout(4, 1));
        
        asetaTuloskentat(valikko);
        
        JButton restart = new JButton("New Game");
        restart.setEnabled(false);
        JButton submit = new JButton("Submit Highscore");
        submit.setEnabled(false);
        
        
        valikko.add(restart);
        valikko.add(submit);
        
        container.add(valikko);
    }
    
/**
  * Metodi luo tekstikentät joista näkyy pisteet ja
  * asettaa nykyisen tuloskentän myös päivittäjälle
  * 
  * @param valikko valikko johon kentät asetetaan
  */    
    public void asetaTuloskentat(JPanel valikko) {
        JTextField tulos = new JTextField("Score: " + 0);
        tulos.setEnabled(false);
        dodgeballpeli.setTuloskentta(tulos);
        
        JTextField ennatys = new JTextField("Highscore: " + 0);
        ennatys.setEnabled(false);
        
        valikko.add(tulos);
        valikko.add(ennatys);
    }
    
/**
  * Metodi palauttaa käyttöliittymän ruudun
  * 
  * @return käyttöliittymän ruutu
  */ 
    public JFrame getFrame() {
        return frame;
    }
    
/**
  * Metodi joka palauttaa pelin piirtoalustan
  * 
  * @return pelin piirtoalusta
  */     
    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }
}
