
package dodgeballpeli.peli;

import dodgeballpeli.domain.Liikkuva;
import dodgeballpeli.domain.PalloKori;
import dodgeballpeli.domain.Vaistaja;
import java.util.ArrayList;
import java.util.List;

public class Peli{
    
    int leveys;
    int korkeus;
    Vaistaja pelaaja;
    PalloKori pallokori;
    List<Liikkuva> liikkuvatOsat;

    public Peli(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        liikkuvatOsat = new ArrayList<Liikkuva>();
        luoPelaaja();
        luoPalloKori();
        pallokori.lisaaPeliinPallo();
    }
    
    private void luoPalloKori() {
        pallokori = new PalloKori(this);
        liikkuvatOsat.add(pallokori);
    }
    
    private void luoPelaaja() {
        this.pelaaja = new Vaistaja(this);
        liikkuvatOsat.add(pelaaja);
    }
    
    public int getLeveys() {
        return leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    
    public Vaistaja getPelaaja() {
        return pelaaja;
    }
 
    public void etene() {
        for(Liikkuva osa : liikkuvatOsat) {
            osa.liiku();
        }
    }
    
    
    @Override
    public String toString() {
        String tulostus = "";
        for(Liikkuva osa : liikkuvatOsat) {
            tulostus += osa.toString() + "\n";
        }
        return tulostus;
    }
}
