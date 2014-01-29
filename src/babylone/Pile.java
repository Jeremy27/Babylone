/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babylone;

import java.util.ArrayList;

/**
 *
 * @author jeremy
 */
public class Pile {
    
    private ArrayList<Tablette> listeTablettes;
    
    public Pile(Tablette tablette) {
        listeTablettes = new ArrayList<>(12);
        listeTablettes.add(tablette);
    }
    
    Pile(ArrayList<Tablette> listeTablettes) {
        this.listeTablettes = listeTablettes;
    }
    
    public void poser(Pile pile) {
        listeTablettes.addAll(pile.getListeTablettes());
    }
    
    public ArrayList<Tablette> getListeTablettes() {
        return listeTablettes;
    }
    
    public int getHauteur() {
        return listeTablettes.size();
    }
    
    public Tablette getCouleurSommet() {
        return listeTablettes.get(listeTablettes.size()-1);
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += listeTablettes.toString();
        
        return str;
    }
}
