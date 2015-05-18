
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
    PalloKori vasenPuoli;
    PalloKori oikeaPuoli;
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
        vasenPuoli = new PalloKori(this, 0);
        liikkuvatOsat.add(vasenPuoli);
        oikeaPuoli = new PalloKori(this, leveys);
        liikkuvatOsat.add(oikeaPuoli);
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
 
    public void etene() {
        for(Liikkuva osa : liikkuvatOsat) {
            osa.liiku();
        }
        lisaaPalloja();
    }
    
    public void lisaaPalloja() {
        int nykyinenMaara = oikeaPuoli.pallojenMaara() + vasenPuoli.pallojenMaara();
        if (nykyinenMaara < pallojenMaara) {
            oikeaPuoli.lisaaPeliinPallo();
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
