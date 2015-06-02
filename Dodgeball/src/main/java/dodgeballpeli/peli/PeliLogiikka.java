
package dodgeballpeli.peli;

import dodgeballpeli.domain.Liikkuva;
import dodgeballpeli.domain.PalloKori;
import dodgeballpeli.domain.Vaistaja;
import java.util.ArrayList;
import java.util.List;

public class PeliLogiikka{
    
    int leveys;
    int korkeus;
    int kulunutAika;
    Vaistaja pelaaja;
    PalloKori pallokori;
    List<Liikkuva> liikkuvatOsat;

    public PeliLogiikka(int leveys, int korkeus) {  
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.kulunutAika = 1;
        liikkuvatOsat = new ArrayList<Liikkuva>();
        luoPelaaja();
        luoPalloKori();
        pallokori.lisaaPeliinPallo();
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
    
    public int haeAika() {
        return kulunutAika/100;
    }
 
    public void etene() {
        for(Liikkuva osa : liikkuvatOsat) {
            osa.liiku();
        }
        nostaVaikeustasoa();
    }
    
    public void nostaVaikeustasoa() {
        if (kulunutAika%1000 == 0) {
            pallokori.lisaaPeliinPallo();                
        }
        kulunutAika++;
    }
    
    @Override
    public String toString() {
        String tulostus = "";
        for(Liikkuva osa : liikkuvatOsat) {
            tulostus += osa.toString() + "\n";
        }
        return tulostus.trim();
    }

}
