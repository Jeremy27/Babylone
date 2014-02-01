/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babylone;

import org.junit.Test;
import static org.junit.Assert.*;
import static babylone.Jeu.*;

/**
 *
 * @author jeremy
 */
public class TestJeu {
    
    public TestJeu() {
    }
    
    @Test
    public void testMemeIndice() {
        Jeu jeu = new Jeu();
        
        assertTrue(jeu.memeIndice(1, 1));
        assertFalse(jeu.memeIndice(1, 2));
    }
    
    @Test
    public void testIndiceNonValide() {
        Jeu jeu = new Jeu();
        
        assertTrue(jeu.indiceNonValide(-1));
        assertTrue(jeu.indiceNonValide(12));
        
        assertFalse(jeu.indiceNonValide(0));
        assertFalse(jeu.indiceNonValide(5));
        assertFalse(jeu.indiceNonValide(11));
    }
    
    @Test
    public void testEstUnEntier() {
        Jeu jeu = new Jeu();
        assertTrue(jeu.estUnEntier("10"));
        assertTrue(jeu.estUnEntier("-5"));
        assertTrue(jeu.estUnEntier("10000"));
        
        assertFalse(jeu.estUnEntier("1.1"));
        assertFalse(jeu.estUnEntier("aaaaa"));
        assertFalse(jeu.estUnEntier(""));
        assertFalse(jeu.estUnEntier("'_èaaa11.(-è_)"));
    }
    
    @Test
    public void testChangerJoueur() {
        Jeu jeu = new Jeu();
        Joueur joueurCourant = jeu.getJoueurCourant();
        
        assertEquals(joueurCourant, jeu.getJoueurCourant());
        jeu.changerJoueur();
        assertNotSame(joueurCourant, jeu.getJoueurCourant());
    }
}
