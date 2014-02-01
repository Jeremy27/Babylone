/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babylone;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jeremy
 */
public class Plateau {
    private ArrayList<Pile> listePiles;
    
    public Plateau() {
        listePiles = new ArrayList<>(12);
        initialiserPlateau();
    }
    
    Plateau(ArrayList<Pile> listePiles) {
        this.listePiles = listePiles;
    }
    
    private void initialiserPlateau() {
        for(Tablette tablette : Tablette.values())
            for (int j = 0; j < 3; j++)
                listePiles.add(new Pile(tablette));
        
        Collections.shuffle(listePiles);
    }
    
    public boolean coupValide(Pile pile1, Pile pile2) {
        boolean memeHauteur = memeHauteur(pile1, pile2);
        boolean memeCouleurSommet = memeCouleurSommet(pile1, pile2);
        
        return memeHauteur || memeCouleurSommet;
    }
    
    public boolean coupPossible() {
        Pile pile1;
        Pile pile2;
        for (int i = 0; i < listePiles.size(); i++) {
            pile1 = listePiles.get(i);
            for (int j = 0; j < listePiles.size(); j++) {
                pile2 = listePiles.get(j);
                if(pilesDifferentes(pile1, pile2)) {
                    if(memeHauteur(pile1, pile2))
                        return true;
                    if(memeCouleurSommet(pile1, pile2))
                        return true;
                }
            }
        }
        return false;
    }
    
    public void poserSur(Pile pile1, Pile pile2) {
        int indicePile2 = listePiles.indexOf(pile2);
        pile1.poser(listePiles.remove(indicePile2));
    }
    
    public boolean pilesDifferentes(Pile pile1, Pile pile2) {
        return (pile1 != pile2);
    }
    
    public boolean memeHauteur(Pile pile1, Pile pile2) {
        return pile1.getHauteur() == pile2.getHauteur();
    }
    
    public boolean memeCouleurSommet(Pile pile1, Pile pile2) {
        return pile1.getCouleurSommet() == pile2.getCouleurSommet();
    }
    
    public Pile getPile(int indicePile) {
        return listePiles.get(indicePile);
    }
    
    public int getTaille() {
        return listePiles.size();
    }
    
    @Override
    public String toString() {
        String strPile      = "";
        String strHauteur   = "";
        String strCouleur   = "";
        Pile pile;
        
        for (int i = 0; i < listePiles.size(); i++) {
            pile = listePiles.get(i);
            
            strPile     += " ==PILE " + i + "==\t|";
            strHauteur  += "Hauteur: " + pile.getHauteur() + "\t|";
            strCouleur  += "Couleur: " + pile.getCouleurSommet() + "\t|";
        }
        
        return strPile+"\n"+strHauteur+"\n"+strCouleur+"\n";
    }
}
