
package dodgeballpeli.domain;

import java.awt.Rectangle;
import java.util.Random;

public class Pallo implements Liikkuva {
    final private int pallonHalkaisija = 20;
    int x;
    int xa;
    int y;
    int ya;
    int vauhti;
    private int alaseina;
    private int sivuraja;
    private Random satu;
    
    
    public Pallo(int heittoPiste, int alaseina, int sivu) {
        this.x = -1*pallonHalkaisija;
        this.y = heittoPiste;
        this.alaseina = alaseina;
        this.sivuraja = sivu;
        this.satu = new Random();
        this.vauhti = 1;
        xa = 1;
        ya = 1 - satu.nextInt(3);
    }
    
    public int haeX() {
        return x;
    }
    
    public int haeY() {
        return y;
    }
    
    public int haeHalkaisija() {
        return pallonHalkaisija;
    }
    
    private void osuuSeinaan() {
        if (y + ya < 0 || y + ya + pallonHalkaisija > alaseina) {
            ya *= -1;
        }
    }
    
    public void heittoTakaisin() {
        if (x + pallonHalkaisija < 0 || x > sivuraja) {
            xa *= -1;
            ya = (1 - satu.nextInt(3)) * vauhti;
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
        return new Rectangle(x,y,pallonHalkaisija,pallonHalkaisija);
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
