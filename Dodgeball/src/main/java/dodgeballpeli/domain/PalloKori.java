
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;
import java.util.ArrayList;
import java.util.Random;

public class PalloKori implements Liikkuva {
    private Random satu;
    Peli peli;
    ArrayList<Pallo> pallot;
    
    public PalloKori(Peli peli) {
        this.satu = new Random();
        this.peli = peli;
        this.pallot = new ArrayList<Pallo>();
    }
    
    public void lisaaPeliinPallo() {
        pallot.add(new Pallo(satu.nextInt(peli.getKorkeus()), peli.getKorkeus(), peli.getLeveys()));
    }
    
    public void heitaPallo(Pallo pallo) {
        if (pallo.meneeTakaisinKoriin()) {
            pallo.heittoToiseltaPuolelta(satu.nextInt(peli.getKorkeus()));
        }
    }
    
    public int pallojenMaara() {
        return pallot.size();
    }

    @Override
    public void liiku() {
        for (Pallo pallo : pallot) {
            heitaPallo(pallo);
            pallo.liiku();
        }
    }
    
    @Override
    public String toString() {
        String tulostus = "";
        for(Pallo pallo : pallot) {
            tulostus += pallo.toString() + "\n";
        }
        return tulostus;
    }
}
