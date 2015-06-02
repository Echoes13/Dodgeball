
package dodgeballpeli.gui;

import dodgeballpeli.peli.PeliLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Nappikuuntelija implements ActionListener {
    private JButton pause;
    private JButton restart;
    private PeliPaivittaja dodgeballpeli;
    
    public Nappikuuntelija(JButton pause, JButton restart, PeliPaivittaja peli) {
        this.pause = pause;
        this.restart = restart;
        this.dodgeballpeli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pause) {
            
        }
        if (e.getSource() == restart) {
            
        }
    }
    
    
}
