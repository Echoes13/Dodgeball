
package dodgeballpeli.peli;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliLogiikkaTest {
    
    PeliLogiikka dodgeball;
    
    @Before
    public void setUp() {
        dodgeball = new PeliLogiikka(100,150);
    }
    
    
    @Test
    public void hakeminenOnnistuu() {
        assertEquals(100,dodgeball.getLeveys());
        assertEquals(150,dodgeball.getKorkeus());
        assertEquals("[40,65]",dodgeball.haePelaaja().toString());
        assertEquals(0,dodgeball.haeKori().pallojaKorissa());
        assertEquals(0,dodgeball.haePisteet());
        assertEquals(false,dodgeball.getLose());
        assertEquals(false,dodgeball.getPause());
    }
    
    @Test
    public void pauseJaLose() {
        dodgeball.setLose(true);
        assertEquals(true,dodgeball.getLose());
        dodgeball.setLose(false);
        dodgeball.setPause(true);
        assertEquals(true,dodgeball.getPause());
    }
    
    
    @Test
    public void peliEtenee() {
        dodgeball.haePelaaja().setSuuntaX(1);
        dodgeball.etene();
        boolean toimiiko = false;
        
        for (int i=1; i<129; i++) {
            if (dodgeball.toString().equals("[41,65]" + "\n" + "(-20," + i + ")")) {
               toimiiko = true;
            }
        }
        assertEquals(true,toimiiko);
    }
    
    @Test
    public void peliinLisataanPallo() {
        for (int i=0; i<1200; i++) {
            dodgeball.etene();
        }
        assertEquals(2,dodgeball.haeKori().pallojaKorissa());
    }
    
    @Test
    public void pisteitaTulee() {
        for (int i=0; i<10; i++) {
            dodgeball.etene();
        }
        assertEquals(1,dodgeball.haePisteet());
    }
}
