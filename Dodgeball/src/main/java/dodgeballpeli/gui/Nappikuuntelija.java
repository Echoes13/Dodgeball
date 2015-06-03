
package dodgeballpeli.gui;

import dodgeballpeli.peli.PeliLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Nappikuuntelija implements ActionListener {
    private JButton restart;
    private JButton submit;
    private PeliPaivittaja dodgeballpeli;
    
    public Nappikuuntelija(JButton restart, JButton submit, PeliPaivittaja peli) {
        this.restart = restart;
        this.submit = submit;
        this.dodgeballpeli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restart) {
            
        }
        if (e.getSource() == submit) {
            
        }
    }
    
    
}
