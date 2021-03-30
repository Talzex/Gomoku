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
    public static void main(String args[]) throws InvalidPositionException{
        Match.nb_colonnes = 10;
        Match.nb_lignes = 18;
        Board.dessiner();
        
        Position p = new Position("A4");
        System.out.println(p.col);
        System.out.println(p.row);
    }
}
