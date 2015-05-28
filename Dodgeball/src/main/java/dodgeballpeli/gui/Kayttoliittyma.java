
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
    private PeliLogiikka dodgeballpeli;
    private PiirtoAlusta piirtoalusta;

    public Kayttoliittyma(PeliLogiikka dodgeballpeli) {
        this.dodgeballpeli = dodgeballpeli;
    }

    @Override
    public void run() {
        frame = new JFrame("Dodgeball");
        int leveys = dodgeballpeli.getLeveys();
        int korkeus = dodgeballpeli.getKorkeus() + 22;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
//        container.setLayout(new GridLayout(1, 2));
        
        piirtoalusta = new PiirtoAlusta(dodgeballpeli);
        frame.addKeyListener(new Nappaimistonkuuntelija(dodgeballpeli.haePelaaja()));
//        
//        JPanel valikko = new JPanel(new GridLayout(4, 1));
//        JTextField tulos = new JTextField("Score: " + 0);
//        tulos.setEnabled(false);
//        JTextField ennatys = new JTextField("Highscore: " + 0);
//        ennatys.setEnabled(false);
//        JButton pause = new JButton("Pause");
//        JButton restart = new JButton("Restart");
//        
//        valikko.add(tulos);
//        valikko.add(pause);
//        valikko.add(restart);
//        
        container.add(piirtoalusta);
//        container.add(valikko);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }
}
