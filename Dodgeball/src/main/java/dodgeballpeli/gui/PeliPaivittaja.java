
package dodgeballpeli.gui;

import dodgeballpeli.domain.Pallo;
import dodgeballpeli.gui.Paivitettava;
import dodgeballpeli.peli.PeliLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PeliPaivittaja extends Timer implements ActionListener{
    
    PeliLogiikka logiikka;
    Paivitettava paivitettava;
    boolean pause;

    public PeliPaivittaja(int leveys, int korkeus) {  
        super(10, null);
        this.logiikka = new PeliLogiikka(leveys,korkeus);
        this.pause = false;
        addActionListener(this);
        setInitialDelay(1000);
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    public PeliLogiikka haeLogiikka() {
        return logiikka;
    }
    
    public void pauseTaiJatka() {
        if (pause = true) {
            pause = false;
        } else {
            pause = true;
        }
    }
    
    public void luoUusiPeli() {
        logiikka = new PeliLogiikka(logiikka.getLeveys(),logiikka.getKorkeus());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Pallo pallo : logiikka.haeKori().getPallot()) {
            if (logiikka.haePelaaja().osuuPalloon(pallo)) {
                return;
            }
        }
        logiikka.etene();
        paivitettava.paivita();
    }

}
