
package dodgeballpeli.domain;

import dodgeballpeli.peli.Peli;

public class Pallo implements Liikkuva {
    int x;
    int xa;
    int y;
    int ya;
    private int alaseina;
    
    
    public Pallo(int heittoPiste, int sivu, int alaseina) {
        this.x = sivu;
        this.y = heittoPiste;
        this.alaseina = alaseina;
        if(sivu == 0) {
            xa = 1;
        } else {
            xa = -1;
        }
        ya = 1;
    }
    
    private void kaannyTarvittaessa(int piste, int suunta) {
        if (piste + suunta < 0 || piste + suunta > alaseina) {
            suunta *= -1;
        }
    }
    
    public int getX() {
        return x;
    }
    
    @Override
    public void liiku() {
        kaannyTarvittaessa(y,ya);
        x += xa;
        y += ya;
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
