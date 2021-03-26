/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author tduthil/jforme
 */
public class Match {
    static int nb_lignes;
    static int nb_colonnes;
    Player joueur1;
    Player joueur2;
    
    Match(int hauteur,int largeur, Player joueur1, Player joueur2) throws InvalidSizeException{   
        if(hauteur >= 5 && hauteur <= 26 && largeur >= 5 && largeur <= 26){
            Match.nb_lignes = hauteur;
            Match.nb_colonnes = largeur;
        } else {
            throw new InvalidSizeException(hauteur, largeur);
        }
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    
    Match m = new Match(20,20,new HumanPlayer("Anna"), new HumanPlayer("Bob")) {};
}
