
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;
import java.awt.Rectangle;

public class Vaistaja implements Liikkuva {
    private int pelinLeveys;
    private int pelinKorkeus;
    final private int pelaajanLeveys = 20;
    int x;
    int xa;
    int y;
    int ya;
    
    
    public Vaistaja(int leveys, int korkeus) {
        this.pelinLeveys = leveys;
        this.pelinKorkeus = korkeus;
        this.x = leveys/2;
        this.y = leveys/2;
        xa = 0;
        ya = 0;
    }

    public int haeX() {
        return x;
    }
    
    public int haeY() {
        return y;
    }
    
    public int haeLeveys() {
        return pelaajanLeveys;
    }
    
    public void setSuuntaX(int suuntaX) {
        xa = suuntaX;
    }
    
    public void setSuuntaY(int suuntaY) {
        ya = suuntaY;
    }
    
    public boolean osuuPalloon(PalloKori mahdollisetKohteet) {
        for (Pallo kohde : mahdollisetKohteet.getPallot()) {
            if (haeRajat().intersects(kohde.haeRajat())) {
                return true;
            }
        }
        return false;
    }
    
    public Rectangle haeRajat() {
        return new Rectangle(x,y,pelaajanLeveys,pelaajanLeveys);
    }
    
    @Override
    public void liiku() {
        if (x + xa > 0 && x + xa + pelaajanLeveys < pelinLeveys) {
            x = x+xa;
        }
        if (y + ya > 0 && y + ya + pelaajanLeveys < pelinKorkeus) {
           y = y+ya;
        }
    }
    
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }

    
    
}
