
package dodgeballpeli.dodgeball;

import dodgeballpeli.gui.Kayttoliittyma;
import dodgeballpeli.peli.Peli;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        Peli dodgeball = new Peli(200, 300);
        
        Kayttoliittyma kali = new Kayttoliittyma(dodgeball.haeLogiikka());
        SwingUtilities.invokeLater(kali);
        
        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        dodgeball.setPaivitettava(kali.getPaivitettava());
        dodgeball.start();
        
    }
}
