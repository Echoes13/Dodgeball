
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
        kori = new PalloKori(5,5);
    }
    
    @Test
    public void koriTyhja() {
        assertEquals(0,kori.pallojaKorissa());
    }
    
    @Test
    public void palloLoytyyKorista() {
        kori.lisaaPeliinPallo();
        assertEquals(1,kori.pallojaKorissa());
    }
    
    @Test
    public void useampiLoytyyKorista() {
        for (int i=0;i<5;i++) {
            kori.lisaaPeliinPallo();
        }
        assertEquals(5,kori.pallojaKorissa());
    }
    
    @Test
    public void palloLiikkuu() {
        kori.lisaaPeliinPallo();
        kori.liiku();
        boolean toimiiko = false;
        
        for (int i=0; i<6; i++) {
            for (Pallo pallo : kori.getPallot()) {
                if (pallo.toString().equals("(1," + i + ")")) {
                    toimiiko = true;
                }
            }
        }
        assertEquals(true,toimiiko);
    }
}
