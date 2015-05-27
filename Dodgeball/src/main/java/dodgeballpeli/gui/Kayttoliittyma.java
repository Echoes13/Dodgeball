
package dodgeballpeli.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import dodgeballpeli.peli.Peli;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli dodgeballpeli;
    private PiirtoAlusta piirtoalusta;

    public Kayttoliittyma(Peli dodgeballpeli) {
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
        piirtoalusta = new PiirtoAlusta(dodgeballpeli);
        container.add(piirtoalusta);
        frame.addKeyListener(new Nappaimistonkuuntelija(dodgeballpeli.haePelaaja()));
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }
}
