
package dodgeballpeli.dodgeball;

import dodgeballpeli.gui.Kayttoliittyma;
import dodgeballpeli.gui.PeliPaivittaja;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        PeliPaivittaja dodgeball = new PeliPaivittaja(200, 300);
        
        Kayttoliittyma kali = new Kayttoliittyma(dodgeball);
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
