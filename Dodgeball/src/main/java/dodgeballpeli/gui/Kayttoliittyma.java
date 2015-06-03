
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

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private PeliPaivittaja dodgeballpeli;
    private PiirtoAlusta piirtoalusta;

    public Kayttoliittyma(PeliPaivittaja dodgeballpeli) {
        this.dodgeballpeli = dodgeballpeli;
    }

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

    public void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(1, 2));
        
        piirtoalusta = new PiirtoAlusta(dodgeballpeli.haeLogiikka());
        frame.addKeyListener(new Nappaimistonkuuntelija(dodgeballpeli));
        
        container.add(piirtoalusta);
        luoValikko(container);
    }
    
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
    
    public void asetaTuloskentat(JPanel valikko) {
        JTextField tulos = new JTextField("Score: " + 0);
        tulos.setEnabled(false);
        dodgeballpeli.setTuloskentta(tulos);
        
        JTextField ennatys = new JTextField("Highscore: " + 0);
        ennatys.setEnabled(false);
        
        valikko.add(tulos);
        valikko.add(ennatys);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }
}
