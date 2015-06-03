
package dodgeballpeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import dodgeballpeli.domain.Vaistaja;

public class Nappaimistonkuuntelija implements KeyListener {
    private PeliPaivittaja dodgeball;
    private Vaistaja pelaaja;
    
    public Nappaimistonkuuntelija(PeliPaivittaja dodgeball) {
        this.dodgeball = dodgeball;
        this.pelaaja = dodgeball.haeLogiikka().haePelaaja();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            dodgeball.pauseTaiJatka();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.setSuuntaX(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.setSuuntaX(1);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.setSuuntaY(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.setSuuntaY(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.setSuuntaX(0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.setSuuntaX(0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.setSuuntaY(0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.setSuuntaY(0);
        }
    }
    
    
}