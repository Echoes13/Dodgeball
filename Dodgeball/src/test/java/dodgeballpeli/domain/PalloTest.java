
package dodgeballpeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PalloTest {
    
    Pallo pallo;
    
    
    @Before
    public void setUp() {
        pallo = new Pallo(40,100,100);
    }
    
    @Test
    public void hakeminenOnnistuu() {
        assertEquals(-20,pallo.haeX());
        assertEquals(40,pallo.haeY());
        assertEquals(20,pallo.haeHalkaisija());
    }
    
    @Test
    public void palloAlkupisteessa() {
        assertEquals("(-20,40)",pallo.toString());
    }
    
    @Test
    public void palloLiikkuu() {
        pallo.liiku();
        assertEquals("(-19,41)",pallo.toString());
    }
    
    @Test
    public void pomppaaSeinastaAla() {
        for (int i = 0; i < 41; i++) {
            pallo.liiku();            
        }
        assertEquals("(21,79)",pallo.toString());
    }
    
    @Test
    public void pomppaaSeinastaYla() {
        pallo.setSuuntaY(-1);
        for (int i = 0; i < 41; i++) {
            pallo.liiku();            
        }
        assertEquals("(21,1)",pallo.toString());
    }
    
    @Test
    public void palloHeitetaanTakaisin() {
        for (int i=0; i<122; i++) {
            pallo.liiku();
        }
        boolean toimiiko = false;
        
        for (int i=0; i<80; i++) {
            if (pallo.toString().equals("(100," + i + ")")) {
                toimiiko = true;
            }
        }
        assertEquals(true,toimiiko);
    }
    
}
