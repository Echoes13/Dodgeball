
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
    
    /**
     *
     * @param g
     */
    public void piirraRajat(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(10, 0, peli.getLeveys()-20, peli.getKorkeus());
        g.drawRect(0, 0, peli.getLeveys(), peli.getKorkeus());
        g.drawLine(10, peli.getKorkeus()/2, peli.getLeveys()-10, peli.getKorkeus()/2);
        g.drawOval(peli.getLeveys()/2 - 30, peli.getKorkeus()/2 - 30, 60, 60);
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
        piirraRajat(g);
        piirraPelaaja(g);
        piirraPallot(g);
    }

    @Override
    public void paivita() {
        repaint();
    }
}