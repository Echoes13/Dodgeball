
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
        g.setColor(Color.BLACK);
        int pelaajaLeveys = peli.haePelaaja().haeLeveys();
        g.fillRect(peli.haePelaaja().haeX(),peli.haePelaaja().haeY(), pelaajaLeveys, pelaajaLeveys);
    }
    
    public void piirraPallot(Graphics g) {
        g.setColor(Color.RED);
        for (Pallo pallo : peli.haeKori().getPallot()) {
            g.fillOval(pallo.haeX()-2, pallo.haeY()-2, pallo.haeHalkaisija()+4, pallo.haeHalkaisija()+4);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraPelaaja(g);
        piirraPallot(g);
    }

    @Override
    public void paivita() {
        repaint();
    }
}