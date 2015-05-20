
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;

public class Vaistaja implements Liikkuva {
    private int leveys;
    private int korkeus;
    int x;
    int xa;
    int y;
    int ya;
    
    
    public Vaistaja(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.x = leveys/2;
        this.y = leveys/2;
        xa = 0;
        ya = 0;
        
    }
    public void setSuuntaX(int suuntaX) {
        xa = suuntaX;
    }
    
    public void setSuuntaY(int suuntaY) {
        ya = suuntaY;
    }
    
    @Override
    public void liiku() {
        if (x + xa > 0 && x + xa < leveys) {
            x = x+xa;
        }
        if (y + ya > 0 && y + ya < korkeus) {
           y = y+ya;
        }
    }
    
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
