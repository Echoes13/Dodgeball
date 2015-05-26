
package dodgeballpeli.peli;

import dodgeballpeli.domain.Liikkuva;
import dodgeballpeli.domain.PalloKori;
import dodgeballpeli.domain.Vaistaja;
import dodgeballpeli.gui.Paivitettava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

public class Peli extends Timer implements ActionListener{
    
    boolean peliJatkuu;
    int leveys;
    int korkeus;
    Vaistaja pelaaja;
    PalloKori pallokori;
    List<Liikkuva> liikkuvatOsat;
    Paivitettava paivitettava;

    public Peli(int leveys, int korkeus) {  
        super(10, null);
        this.peliJatkuu = true;
        this.leveys = leveys;
        this.korkeus = korkeus;
        liikkuvatOsat = new ArrayList<Liikkuva>();
        luoPelaaja();
        luoPalloKori();
        pallokori.lisaaPeliinPallo();
        addActionListener(this);
        setInitialDelay(2000);
    }
    
    private void luoPalloKori() {
        pallokori = new PalloKori(leveys, korkeus);
        liikkuvatOsat.add(pallokori);
    }
    
    private void luoPelaaja() {
        this.pelaaja = new Vaistaja(leveys, korkeus);
        liikkuvatOsat.add(pelaaja);
    }
    
    public int getLeveys() {
        return leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public Vaistaja haePelaaja() {
        return pelaaja;
    }
    
    public PalloKori haeKori() {
        return pallokori;
    }
 
    public void etene() {
        for(Liikkuva osa : liikkuvatOsat) {
            osa.liiku();
        }
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    
    @Override
    public String toString() {
        String tulostus = "";
        for(Liikkuva osa : liikkuvatOsat) {
            tulostus += osa.toString() + "\n";
        }
        return tulostus.trim();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (pelaaja.osuuPalloon(pallokori)) {
            return;
        }
        etene();
        paivitettava.paivita();
        }

}
