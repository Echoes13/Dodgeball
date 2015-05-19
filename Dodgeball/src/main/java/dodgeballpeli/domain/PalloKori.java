
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
    
    public int pallojaKorissa() {
        return pallot.size();
    }

    @Override
    public void liiku() {
        for (Pallo pallo : pallot) {
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
