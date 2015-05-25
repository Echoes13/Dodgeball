
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;
import java.awt.Rectangle;
import java.util.Random;

public class Pallo implements Liikkuva {
    final private int pallonLeveys = 20;
    int x;
    int xa;
    int y;
    int ya;
    private int alaseina;
    private int sivuraja;
    private Random satu;
    
    
    public Pallo(int heittoPiste, int alaseina, int sivu) {
        this.x = 0;
        this.y = heittoPiste;
        this.alaseina = alaseina;
        this.sivuraja = sivu;
        this.satu = new Random();
        xa = 1;
        ya = 1;
    }
    
    public int haeX() {
        return x;
    }
    
    public int haeY() {
        return y;
    }
    
    public int haeLeveys() {
        return pallonLeveys;
    }
    
    private void osuuSeinaan() {
        if (y + ya < 0 || y + ya > alaseina) {
            ya *= -1;
        }
    }
    
    public void heittoTakaisin() {
        if (x < 0 || x > sivuraja) {
            y = satu.nextInt(alaseina);
            xa *= -1;
        }
    }
    
    public void setSuuntaY(int suunta) {
        ya = suunta;
    }
    
    @Override
    public void liiku() {
        heittoTakaisin();
        osuuSeinaan();
        x += xa;
        y += ya;
    }
    
    public Rectangle haeRajat() {
        return new Rectangle(x,y,pallonLeveys,pallonLeveys);
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
