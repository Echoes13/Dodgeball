
package dodgeballpeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PalloKoriTest {
    
    PalloKori kori;
    
    @Before
    public void setUp() {
        kori = new PalloKori(100,100);
    }
    
    @Test
    public void koriTyhja() {
        assertEquals(0,kori.pallojaKorissa());
    }
    
    @Test
    public void pallojaLoytyyKorista() {
        kori.lisaaPeliinPallo();
        assertEquals(1,kori.pallojaKorissa());
        
        for (int i=0;i<5;i++) {
            kori.lisaaPeliinPallo();
        }
        assertEquals(6,kori.pallojaKorissa());
    }
    
    @Test
    public void palloLiikkuu() {
        kori.lisaaPeliinPallo();
        kori.liiku();
        boolean toimiiko = false;
        
        for (int i=0; i<80; i++) {
            if (kori.toString().equals("(-19," + i + ")")) {
               toimiiko = true;
            }
        }
        assertEquals(true,toimiiko);
    }
    
}
