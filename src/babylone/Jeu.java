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
    
    private boolean indiceNonValide(int indice) {
        if(indice > plateau.getTaille() || indice < 0)
            return true;
        return false;
    }
    
    private boolean memeIndice(int indice1, int indice2) {
        return indice1 == indice2;
    }
    
    private boolean verifierIndices(int indice1, int indice2) {
        if(indiceNonValide(indice1))
            return true;
        return false;
    }
    
    public boolean verifierContrainte(int indicePile1, int indicePile2) {
        boolean contraintesRespectees = true;
        if(indiceNonValide(indicePile1)) {
            System.out.println("La Pile "+indicePile1+" n'existe pas");
            contraintesRespectees = false;
        }
        else if(indiceNonValide(indicePile2)) {
            System.out.println("La Pile "+indicePile2+" n'existe pas");
            contraintesRespectees = false;
        }
        else if(memeIndice(indicePile1, indicePile2)) {
            System.out.println("La Pile "+indicePile1+" et la Pile "+indicePile2+" sont les mêmes");
            contraintesRespectees = false;
        }
        else if(plateau.coupValide(plateau.getPile(indicePile1), plateau.getPile(indicePile2))) {
            System.out.println("La Pile "+indicePile1+" ne peut pas être posée sur la Pile "+indicePile2);
            contraintesRespectees = false;
        }
        return contraintesRespectees;
    }
    
    public boolean estPasTermine() {
        return plateau.coupPossible();
    }
    
    private Joueur getJoueurCourant() {
        return joueur;
    }
    
    public static void main(String[] args) {
        int indicePile1;
        int indicePile2;
        boolean coupNonValide = true;
        Scanner sc = new Scanner(System.in);
        Jeu jeu = new Jeu();
        System.out.println(jeu);
        while(jeu.estPasTermine()) {
            System.out.println("JOUEUR "+ jeu.getJoueurCourant()+"à toi de jouer !");
            
            while(coupNonValide) {
                System.out.print("Choisi une première pile : ");
                indicePile1 = sc.nextInt();
                System.out.print("Choisi la pile sur laquelle tu veux poser la première : ");
                indicePile2 = sc.nextInt();
                coupNonValide = jeu.verifierContrainte(indicePile1, indicePile2);
                // TODO : faire coup suivant + changer de joueur
            }
        }
    }
    
}
