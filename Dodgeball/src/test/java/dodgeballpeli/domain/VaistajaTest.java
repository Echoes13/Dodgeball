
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
        pelaaja = new Vaistaja(100,150);
    }
    
    @Test
    public void hakeminenOnnistuu() {
        assertEquals(40,pelaaja.haeX());
        assertEquals(65,pelaaja.haeY());
        assertEquals(20,pelaaja.haeLeveys());
    }
    
    @Test
    public void vaistajaOikeassaKohtaa() {
        assertEquals("[40,65]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiiku() {
        pelaaja.liiku();
        assertEquals("[40,65]",pelaaja.toString());
    }
    
    @Test
    public void vaistajanSuunnanAsettaminenX() {
        pelaaja.setSuuntaX(1);
        pelaaja.liiku();
        assertEquals("[41,65]",pelaaja.toString());
    }
    
    @Test
    public void vaistajanSuunnanAsettaminenY() {
        pelaaja.setSuuntaY(1);
        pelaaja.liiku();
        assertEquals("[40,66]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuSivunYliOikea() {
        pelaaja.setSuuntaX(1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[69,65]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuSivunYliVasen() {
        pelaaja.setSuuntaX(-1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[12,65]",pelaaja.toString());
    }
    
    @Test
    public void vaistajaEiLiikuAlaseinanYli() {
        pelaaja.setSuuntaY(1);
        for (int i = 0; i < 100; i++) {
            pelaaja.liiku();
        }
        assertEquals("[40,129]",pelaaja.toString());
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
        assertEquals("[69,129]",pelaaja.toString());
    }
    
    @Test
    public void palloEiOsuuVaistajaan() {
        Pallo pallo = new Pallo(65,100,150);
        pallo.liiku();
        assertEquals(false,pelaaja.osuuPalloon(pallo));
    }
    
    @Test
    public void palloOsuuVaistajaan() {
        Pallo pallo = new Pallo(65,100,150);
        pallo.setSuuntaY(0);
        for (int i = 0; i < 51; i++) {
            pallo.liiku();
        }
        assertEquals(true,pelaaja.osuuPalloon(pallo));
    }
    
}
