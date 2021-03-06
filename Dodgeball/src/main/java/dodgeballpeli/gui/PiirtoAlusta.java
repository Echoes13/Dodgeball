
package dodgeballpeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import dodgeballpeli.domain.Pallo;
import dodgeballpeli.peli.PeliLogiikka;
import java.awt.Font;

/**
  * Luokka joka piirtää pelin tapahtumat
  * Luokka laajentaa luokkaa JPanel ja toteuttaa
  * rajapinnan Paivitettava
  */  
public class PiirtoAlusta extends JPanel implements Paivitettava {
  
    private PeliLogiikka peli;
    
/**
  * Konstruktorissa asetetaan pelin logiikka alustalle
  * 
  * @param peli pelin logiikka
  */      
    public PiirtoAlusta(PeliLogiikka peli) {
        this.peli = peli;
    }
    
    
/**
  * Metodissa piirretään pelialue
  * 
  * @param g piirtäjä
  */
    public void piirraRajat(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, peli.getLeveys(), peli.getKorkeus());
        g.setColor(Color.BLACK);
        g.drawRect(10, 0, peli.getLeveys()-20, peli.getKorkeus());
        g.drawRect(0, 0, peli.getLeveys(), peli.getKorkeus());
        g.drawRect(peli.getLeveys()/2 - 40, 0, 80, 30);
        g.drawRect(peli.getLeveys()/2 - 40, peli.getKorkeus()-30, 80, 30);
        g.drawLine(10, peli.getKorkeus()/2, peli.getLeveys()-10, peli.getKorkeus()/2);
        g.drawOval(peli.getLeveys()/2 - 30, peli.getKorkeus()/2 - 30, 60, 60);
    }
    
/**
  * Metodissa piirretään pelaajahahmo
  * 
  * @param g piirtäjä
  */    
    public void piirraPelaaja(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        int pelaajaLeveys = peli.haePelaaja().haeLeveys();
        g.fillRect(peli.haePelaaja().haeX(),peli.haePelaaja().haeY(), pelaajaLeveys, pelaajaLeveys);
    }

/**
  * Metodissa piirretään pelin pallot
  * 
  * @param g piirtäjä
  */    
    public void piirraPallot(Graphics g) {
        g.setColor(Color.RED);
        for (Pallo pallo : peli.haeKori().getPallot()) {
            g.fillOval(pallo.haeX()-2, pallo.haeY()-2, pallo.haeHalkaisija()+4, pallo.haeHalkaisija()+4);
        }
    }
    
/**
  * Metodissa piirretään että peli on pausella
  * 
  * @param g piirtäjä
  */    
    public void piirraPause(Graphics g) {
        if(peli.getPause()) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("PAUSE", peli.getLeveys()/2 - peli.getLeveys()/6, 80);
        }
    } 
    
/**
  * Metodissa piirretään pelin pallot
  * 
  * @param g piirtäjä
  */    
    public void piirraLose(Graphics g) {
        if(peli.getLose()) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, peli.haePelaaja().haeLeveys() + 10));
            g.drawString("YOU LOSE", peli.getLeveys()/12, peli.getKorkeus()/3);
        }
    }     
    
/**
  * Metodissa piirretään kaikki pelin osat
  * 
  * @param g piirtäjä
  */    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraRajat(g);
        piirraPelaaja(g);
        piirraPallot(g);
        piirraPause(g);
        piirraLose(g);
    }
    
/**
  * Metodi asettaa piirtoalustalle uuden pelin piirrettäväksi
  * 
  * @param uusiPeli uuden pelin logiikka
  */
    @Override
    public void setNewGame(PeliLogiikka uusiPeli) {
        this.peli = uusiPeli;
    }  
    
/**
  * Metodi päivittää kuvaa muuttuneeseen tilanteeseen
  */    
    @Override
    public void paivita() {
        repaint();
    }
}