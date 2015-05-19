
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;

public class Pallo implements Liikkuva {
    int x;
    int xa;
    int y;
    int ya;
    private int alaseina;
    private int sivuraja;
    
    
    public Pallo(int heittoPiste, int alaseina, int sivu) {
        this.x = 0;
        this.y = heittoPiste;
        this.alaseina = alaseina;
        this.sivuraja = sivu;
        xa = 1;
        ya = 1;
    }
    
    public boolean meneeTakaisinKoriin() {
        if (x < 0 || x > sivuraja) {
            return true;
        }
        return false;
    }
    
    private void osuuSeinaan() {
        if (y + ya < 0 || y + ya > alaseina) {
            ya *= -1;
        }
    }
    
    public void heittoToiseltaPuolelta(int heitonYKoordinaatti) {
        y = heitonYKoordinaatti;
        xa *= -1;
    }
    
    @Override
    public void liiku() {
        osuuSeinaan();
        x += xa;
        y += ya;
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
