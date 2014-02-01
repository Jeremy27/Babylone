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
    
    @Test
    public void testHauteur() {
        Pile pile = new Pile(Tablette.VERTE);
        assertEquals(1, pile.getHauteur());
        
        pile.poser(new Pile(Tablette.BEIGE));
        assertEquals(2, pile.getHauteur());
        
        pile.poser(pile);
        assertEquals(4, pile.getHauteur());
    }
    
    @Test
    public void testCouleurSommet() {
        Pile pile = new Pile(Tablette.VERTE);
        assertEquals(Tablette.VERTE, pile.getCouleurSommet());
        pile.poser(new Pile(Tablette.BEIGE));
        assertEquals(Tablette.BEIGE, pile.getCouleurSommet());
        pile.poser(new Pile(Tablette.NOIRE));
        assertEquals(Tablette.NOIRE, pile.getCouleurSommet());
        pile.poser(new Pile(Tablette.ROUGE));
        assertEquals(Tablette.ROUGE, pile.getCouleurSommet());
        
        pile.poser(pile);
        assertEquals(Tablette.ROUGE, pile.getCouleurSommet());
    }
}
