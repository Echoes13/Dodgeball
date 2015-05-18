
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;

public class Vaistaja implements Liikkuva {
    private Peli peli;
    int x;
    int xa;
    int y;
    int ya;
    
    
    public Vaistaja(Peli peli) {
        this.peli = peli;
        this.x = peli.getLeveys()/2;
        this.y = peli.getKorkeus()/2;
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
        if (x + xa > 0 && x + xa < peli.getLeveys()) {
            x = x+xa;
        }
        if (y + ya > 0 && y + ya < peli.getLeveys()) {
           y = y+ya;
        }
    }
    
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
