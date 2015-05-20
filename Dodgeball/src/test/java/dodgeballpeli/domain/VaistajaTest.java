
package dodgeballpeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VaistajaTest {
    
    Vaistaja pelaaja;
    
    @Before
    public void setUp() {
        pelaaja = new Vaistaja(5,5);
    }
    
    @Test
    public void vaistajaOikeassaKohtaa() {
        assertEquals("[2,2]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiiku() {
        pelaaja.liiku();
        assertEquals("[2,2]",pelaaja.toString());
    }
    
    @Test
    public void vaistajanSuunnanAsettaminenX() {
        pelaaja.setSuuntaX(1);
        pelaaja.liiku();
        assertEquals("[3,2]",pelaaja.toString());
    }
    
    @Test
    public void vaistajanSuunnanAsettaminenY() {
        pelaaja.setSuuntaY(1);
        pelaaja.liiku();
        assertEquals("[2,3]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuSivunYliOikea() {
        pelaaja.setSuuntaX(2);
        pelaaja.liiku();
        pelaaja.liiku();
        assertEquals("[4,2]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuSivunYliVasen() {
        pelaaja.setSuuntaX(-1);
        pelaaja.liiku();
        pelaaja.liiku();
        assertEquals("[1,2]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuAlaseinanYli() {
        pelaaja.setSuuntaY(2);
        pelaaja.liiku();
        pelaaja.liiku();
        assertEquals("[2,4]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuYlaseinanYli() {
        pelaaja.setSuuntaY(-1);
        pelaaja.liiku();
        pelaaja.liiku();
        assertEquals("[2,1]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiMeneNurkastaUlos() {
        pelaaja.setSuuntaX(1);
        pelaaja.setSuuntaY(2);
        pelaaja.liiku();
        pelaaja.liiku();
        pelaaja.liiku();
        assertEquals("[4,4]",pelaaja.toString());
    }
}
