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
    int largeur;
    int hauteur;
    Player joueur1;
    Player joueur2;
    
    Match(int largeur, int hauteur, Player joueur1, Player joueur2){
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
    
    Match m = new Match(20,20,new HumanPlayer("Anna"), new HumanPlayer("Bob")) {};
}
