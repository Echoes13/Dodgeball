
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
        pelaaja = new Vaistaja(100,100);
    }
    
    @Test
    public void hakeminenOnnistuu() {
        assertEquals(40,pelaaja.haeX());
        assertEquals(40,pelaaja.haeY());
        assertEquals(20,pelaaja.haeLeveys());
    }
    
    @Test
    public void vaistajaOikeassaKohtaa() {
        assertEquals("[40,40]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiiku() {
        pelaaja.liiku();
        assertEquals("[40,40]",pelaaja.toString());
    }
    
    @Test
    public void vaistajanSuunnanAsettaminenX() {
        pelaaja.setSuuntaX(1);
        pelaaja.liiku();
        assertEquals("[41,40]",pelaaja.toString());
    }
    
    @Test
    public void vaistajanSuunnanAsettaminenY() {
        pelaaja.setSuuntaY(1);
        pelaaja.liiku();
        assertEquals("[40,41]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuSivunYliOikea() {
        pelaaja.setSuuntaX(1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[69,40]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuSivunYliVasen() {
        pelaaja.setSuuntaX(-1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[12,40]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuAlaseinanYli() {
        pelaaja.setSuuntaY(1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[40,79]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuYlaseinanYli() {
        pelaaja.setSuuntaY(-1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[40,1]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiMeneNurkastaUlos() {
        pelaaja.setSuuntaX(1);
        pelaaja.setSuuntaY(1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[69,79]",pelaaja.toString());
    }
    
    @Test
    public void palloEiOsuuVaistajaan() {
        Pallo pallo = new Pallo(40,100,100);
        pallo.liiku();
        assertEquals(false,pelaaja.osuuPalloon(pallo));
    }
    
    @Test
    public void palloOsuuVaistajaan() {
        Pallo pallo = new Pallo(40,100,100);
        pallo.setSuuntaY(0);
        for (int i = 0; i < 51; i++) {
            pallo.liiku();
        }
        assertEquals(true,pelaaja.osuuPalloon(pallo));
    }
    
}
