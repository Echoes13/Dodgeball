
package dodgeballpeli.dodgeball;

import dodgeballpeli.gui.Kayttoliittyma;
import dodgeballpeli.gui.PeliValvoja;
import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
        PeliValvoja dodgeball = new PeliValvoja(200, 300);
        
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
        dodgeball.aloitaPeli();
        
    }
}
