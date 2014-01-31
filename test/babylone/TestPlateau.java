/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babylone;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeremy
 */
public class TestPlateau {
    
    @Test
    public void testMemeHauteur() {
        Plateau plateau = new Plateau();
        Pile pile1 = new Pile(Tablette.VERTE);
        Pile pile2 = new Pile(Tablette.VERTE);
        assertTrue(plateau.memeHauteur(pile1, pile2));
        
        pile2.poser(pile1);
        assertFalse(plateau.memeHauteur(pile1, pile2));
    }
    
    @Test
    public void testMemeCouleurSommet() {
        Plateau plateau = new Plateau();
        Pile pile1 = new Pile(Tablette.VERTE);
        Pile pile2 = new Pile(Tablette.VERTE);
        assertTrue(plateau.memeCouleurSommet(pile1, pile2));
        
        Pile pile3 = new Pile(Tablette.BEIGE);
        assertFalse(plateau.memeCouleurSommet(pile1, pile3));
        
        pile3.poser(pile2);
        assertTrue(plateau.memeCouleurSommet(pile1, pile3));
    }
    
    @Test
    public void testPilesDifferentes() {
        Plateau plateau = new Plateau();
        Pile pile1 = new Pile(Tablette.VERTE);
        Pile pile2 = new Pile(Tablette.VERTE);
        
        assertTrue(plateau.pilesDifferentes(pile1, pile2));
        
        assertFalse(plateau.pilesDifferentes(pile1, pile1));
    }
    
    @Test
    public void testCoupValide() {
        Plateau plateau = new Plateau();
        Pile pile1 = new Pile(Tablette.VERTE);
        Pile pile2 = new Pile(Tablette.BEIGE);
        Pile pile3 = new Pile(Tablette.ROUGE);
        assertTrue(plateau.coupValide(pile1, pile2));
        
        // Pile 1 : [VERTE] | Pile 2 : [BEIGE, VERTE]
        pile2.poser(pile1);
        assertTrue(plateau.coupValide(pile1, pile2));
        
        assertFalse(plateau.coupValide(pile2, pile3));
    }
    
    @Test
    public void testCoupPossible() {
        Plateau plateau = new Plateau();
        
        assertTrue(plateau.coupPossible());
        
        ArrayList<Tablette> listeTablettes1 = new ArrayList<>();
        listeTablettes1.add(Tablette.VERTE);
        ArrayList<Tablette> listeTablettes2 = new ArrayList<>();
        listeTablettes2.add(Tablette.BEIGE);
        listeTablettes2.add(Tablette.BEIGE);
        
        Pile pile1 = new Pile(listeTablettes1);
        Pile pile2 = new Pile(listeTablettes2);
        
        ArrayList<Pile> listePiles = new ArrayList<>();
        listePiles.add(pile1);
        listePiles.add(pile2);
        
        plateau = new Plateau(listePiles);
        
        assertFalse(plateau.coupPossible());
    }
}
