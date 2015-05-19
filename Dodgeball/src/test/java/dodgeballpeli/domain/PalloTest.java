/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dodgeballpeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulvuorela
 */
public class PalloTest {
    
    Pallo pallo;
    
    
    
    @Before
    public void setUp() {
        pallo = new Pallo(3,5,5);
    }
    
    @Test
    public void palloAlkupisteessa() {
        assertEquals("(0,3)",pallo.toString());
    }
    
    @Test
    public void pomppaaSeinasta() {
        pallo.liiku();
        pallo.liiku();
        pallo.liiku();
        assertEquals("(3,4)",pallo.toString());
    }
    
    
}
