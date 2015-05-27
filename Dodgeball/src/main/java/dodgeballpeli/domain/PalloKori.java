
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;
import java.util.ArrayList;
import java.util.Random;

public class PalloKori implements Liikkuva {
    private Random satu;
    private ArrayList<Pallo> pallot;
    private int leveys;
    private int korkeus;
    
    
    public PalloKori(int leveys, int korkeus) {
        this.satu = new Random();
        this.pallot = new ArrayList<Pallo>();
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    public void lisaaPeliinPallo() {
        pallot.add(new Pallo(satu.nextInt(korkeus-20), korkeus, leveys));
    }
    
    public int pallojaKorissa() {
        return pallot.size();
    }
    
    public ArrayList<Pallo> getPallot() {
        return pallot;
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
        return tulostus.trim();
    }
}
