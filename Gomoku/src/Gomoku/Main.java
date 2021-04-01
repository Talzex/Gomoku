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

    public static void main(String args[]) throws InvalidPositionException, InvalidSizeException {

        Match m = new Match(20, 20, new HumanPlayer("Anna"), new HumanPlayer("Bob"));
        //m.run();

        Match.nb_colonnes = 18;
        Match.nb_lignes = 12;

        Board.dessiner();

        Position p = new Position("A4");
        Position p1 = new Position("A1");

        System.out.println(p.col);
        System.out.println(p.row);

        Board.set(p, Color.BLACK);
        System.out.println("La couleur de p : " + Board.get(p));

        Board.set(p1, Color.WHITE);
        System.out.println("La couleur de p1 : " + Board.get(p1));

        Board.dessiner();
    }
}
