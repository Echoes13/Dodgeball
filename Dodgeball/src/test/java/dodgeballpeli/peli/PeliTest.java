
package dodgeballpeli.peli;

import dodgeballpeli.domain.Vaistaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliTest {
    
    Peli dodgeball;
    
    @Before
    public void setUp() {
        dodgeball = new Peli(10,10);
    }
    
    @Test
    public void getLeveysToimii() {
        assertEquals(10,dodgeball.getLeveys());
    }
        
    @Test
    public void getKorkeusToimii() {
        assertEquals(10,dodgeball.getKorkeus());
    }
    
    @Test
    public void getPelaajaToimii() {
        Vaistaja pelaaja = dodgeball.getPelaaja();
        assertEquals("[5,5]",pelaaja.toString());
    }
    
    
}
