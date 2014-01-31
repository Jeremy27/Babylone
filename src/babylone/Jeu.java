/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package babylone;

import java.util.Scanner;

/**
 *
 * @author jeremy
 */
public class Jeu {
    public static enum Joueur {
        UN,
        DEUX
    }
    
    private Joueur joueur;
    private Plateau plateau;
    
    public Jeu() {
        plateau = new Plateau();
        joueur = Joueur.UN;
    }
    
    boolean indiceNonValide(int indice) {
        return indice > plateau.getTaille()-1 || indice < 0;
    }
    
    boolean memeIndice(int indice1, int indice2) {
        return indice1 == indice2;
    }
    
    public boolean contraintesRespectees(int indicePile1, int indicePile2) {
        boolean contraintesRespectees = true;
        if(indiceNonValide(indicePile1)) {
            System.out.println("[ERREUR] La Pile "+indicePile1+" n'existe pas");
            contraintesRespectees = false;
        }
        else if(indiceNonValide(indicePile2)) {
            System.out.println("[ERREUR] La Pile "+indicePile2+" n'existe pas");
            contraintesRespectees = false;
        }
        else if(memeIndice(indicePile1, indicePile2)) {
            System.out.println("[ERREUR] La Pile "+indicePile1+" et la Pile "+indicePile2+" sont les mêmes");
            contraintesRespectees = false;
        }
        else if(!plateau.coupValide(plateau.getPile(indicePile1), plateau.getPile(indicePile2))) {
            System.out.println("[ERREUR] La Pile "+indicePile1+" ne peut pas être posée sur la Pile "+indicePile2);
            contraintesRespectees = false;
        }
        return contraintesRespectees;
    }
    
    public void poser(int indicePile1, int indicePile2) {
        plateau.poserSur(plateau.getPile(indicePile1), plateau.getPile(indicePile2));
    }
    
    public void changerJoueur() {
        if(joueur == Joueur.UN)
            joueur = Joueur.DEUX;
        else
            joueur = Joueur.UN;
    }
    
    public boolean estUnEntier(String donnee) {
        try {
            Integer.parseInt(donnee);
            return true;
        }catch(NumberFormatException e) {
            System.out.println("[ERREUR] L'indice "+donnee+" doit être un entier  et inférieur à "+Integer.MAX_VALUE);
            return false;
        }
    }
    
    public boolean estPasTermine() {
        return plateau.coupPossible();
    }
    
    Joueur getJoueurCourant() {
        return joueur;
    }
    
    public static void main(String[] args) {
        String strIndicePile1;
        String strIndicePile2;
        int indicePile1 = 0;
        int indicePile2 = 0;
        
        Scanner sc  = new Scanner(System.in);
        Jeu jeu     = new Jeu();
        boolean redemander = true;
        
        
        while(jeu.estPasTermine()) {
            redemander = true;
            System.out.println("\n\n"+jeu.plateau);
            System.out.println("JOUEUR "+ jeu.getJoueurCourant()+" à vous de jouer !");
            
            do {
                System.out.print("Veuillez choisir une première pile : ");
                strIndicePile1 = sc.next();
                System.out.print("Veuillez choisir la pile sur laquelle vous voulez poser la première : ");
                strIndicePile2 = sc.next();
                
               if(jeu.estUnEntier(strIndicePile1) && jeu.estUnEntier(strIndicePile2)) {
                   indicePile1 = Integer.parseInt(strIndicePile1);
                   indicePile2 = Integer.parseInt(strIndicePile2);
                   redemander = !jeu.contraintesRespectees(indicePile1, indicePile2);
               }

            } while(redemander);
            
            jeu.poser(indicePile1, indicePile2);
            jeu.changerJoueur();
        }
        System.out.println(jeu.plateau);
        System.out.println("-------------------------------------------------");
        System.out.println("Le JOUEUR "+jeu.getJoueurCourant()+" a perdu !!");
        System.out.println("-------------------------------------------------");
    }
    
}
