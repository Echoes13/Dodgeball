
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
        dodgeball = new Peli(100,100);
    }
    
    public boolean korinSisalto(int X) {
        boolean toimiiko = false;
        
        for (int i=1; i<79; i++) {
            if (dodgeball.haeKori().toString().equals("(" + X + "," + i + ")")) {
               toimiiko = true;
            }
        }
        return toimiiko;
    }
    
    @Test
    public void hakeminenOnnistuu() {
        assertEquals(100,dodgeball.getLeveys());
        assertEquals(100,dodgeball.getKorkeus());
        assertEquals("[40,40]",dodgeball.haePelaaja().toString());
        assertEquals(true,korinSisalto(-20));
    }
    
    
    
    @Test
    public void peliEtenee() {
        dodgeball.etene();
        boolean toimiiko = false;
        
        for (int i=1; i<79; i++) {
            if (dodgeball.toString().equals(dodgeball.haePelaaja().toString() + "\n" + "(-19," + i + ")")) {
               toimiiko = true;
            }
        }
        
        assertEquals(true,toimiiko);
    }
}