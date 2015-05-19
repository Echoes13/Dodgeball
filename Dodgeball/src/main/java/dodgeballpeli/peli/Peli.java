
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
    private int pallojenMaara;
    
    public Peli(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        liikkuvatOsat = new ArrayList<Liikkuva>();
        luoPelaaja();
        luoPalloKorit();
        pallojenMaara = 1;
    }
    
    private void luoPalloKorit() {
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
        lisaaPalloja();
        for(Liikkuva osa : liikkuvatOsat) {
            osa.liiku();
        }
    }
    
    public void lisaaPalloja() {
        if (pallokori.pallojenMaara() < pallojenMaara) {
            pallokori.lisaaPeliinPallo();
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
