/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babylone;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeremy
 */
public class TestPile {
    
    public TestPile() {
    }
    
    @Test
    public void testToString() {
        Pile pile1 = new Pile(Tablette.VERTE);
        assertEquals("[VERTE]", pile1.toString());
        
        Pile pile2 = new Pile(Tablette.BEIGE);
        assertEquals("[BEIGE]", pile2.toString());
        
        Pile pile3 = new Pile(Tablette.NOIRE);
        assertEquals("[NOIRE]", pile3.toString());
        
        Pile pile4 = new Pile(Tablette.ROUGE);
        assertEquals("[ROUGE]", pile4.toString());
    }
    
    @Test
    public void testToString2() {
        Pile pile1 = new Pile(Tablette.VERTE);
        Pile pile2 = new Pile(Tablette.BEIGE);
        pile1.poser(pile2);
        
        assertEquals("["+Tablette.VERTE+", "+Tablette.BEIGE+"]", pile1.toString());
    }
}
