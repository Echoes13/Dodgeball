
package dodgeballpeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import dodgeballpeli.domain.Pallo;
import dodgeballpeli.peli.PeliLogiikka;


public class PiirtoAlusta extends JPanel implements Paivitettava {
    private PeliLogiikka peli;
    
    public PiirtoAlusta(PeliLogiikka peli) {
        this.peli = peli;
    }
    
    public void piirraPelaaja(Graphics g) {
        int pelaajaLeveys = peli.haePelaaja().haeLeveys();
        g.fillRect(peli.haePelaaja().haeX(),peli.haePelaaja().haeY(), pelaajaLeveys, pelaajaLeveys);
    }
    
    public void piirraPallot(Graphics g) {
        for (Pallo pallo : peli.haeKori().getPallot()) {
            g.fillOval(pallo.haeX(), pallo.haeY(), pallo.haeHalkaisija(), pallo.haeHalkaisija());
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        piirraPelaaja(g);
        g.setColor(Color.RED);
        piirraPallot(g);
    }

    @Override
    public void paivita() {
        repaint();
    }
}