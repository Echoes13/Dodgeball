
package dodgeballpeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
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
    private PeliValvoja dodgeballpeli;
    private PiirtoAlusta piirtoalusta;

/**
  * Konstruktorissa asetetaan käyttöliittymälle päivittäjä
  * 
  * @param dodgeballpeli pelin päivittäjä
  */    
    public Kayttoliittyma(PeliValvoja dodgeballpeli) {
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
        luoInfo(container);
    }
    
/**
  * Metodi luo valikon johon kuuluu tuloskentät ja ruutu
  * jossa lukee pelin käyttöohjeet
  * 
  * @param container käyttöliittymän ruutu
  */    
    public void luoInfo(Container container) {
        JPanel info = new JPanel(new GridLayout(2, 1));
        
        asetaTuloskentat(info);
        
        JLabel aputeksti = new JLabel("<html> Ohjaa opiskelijaa nuolinäppäimillä.<br>"
                + "Voit paussata pelin painamalla välilyöntiä. "
                + "Pelin loputtua voit aloittaa uuden pelin painamalla "
                + "enteriä.");
        aputeksti.setEnabled(false);
        info.add(aputeksti);
        
        container.add(info);
    }
    
/**
  * Metodi luo tekstikentät joista näkyy pisteet ja
  * asettaa nykyisen tuloskentän myös valvojalle
  * 
  * @param info ruutu johon kentät asetetaan
  */    
    public void asetaTuloskentat(JPanel info) {
        JPanel tuloskentat = new JPanel(new GridLayout(2,1));
        
        JTextField tulos = new JTextField("Score: " + 0);
        tulos.setEnabled(false);        
        JTextField ennatys = new JTextField("Highscore: " + 0);
        ennatys.setEnabled(false);
                
        dodgeballpeli.setTuloskentat(tulos,ennatys);

        tuloskentat.add(tulos);
        tuloskentat.add(ennatys);
        info.add(tuloskentat);
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
