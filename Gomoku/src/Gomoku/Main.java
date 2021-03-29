/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author jforme
 */
public class Main {
    public static void main(String args[]){
        Match.nb_colonnes = 11;
        Match.nb_lignes = 8;
        Board.dessiner();
        
        // test vite fait
        // manque une erreur si que des lettres
        String s = "A20";
        System.out.println(Position.rowToInt(s));
        System.out.println(Position.colToInt(s));
        
    }
}
