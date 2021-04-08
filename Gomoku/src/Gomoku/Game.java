/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.util.ArrayList;

/**
 *
 * @author tduthil/jforme
 */
public class Game {

    public static Color nextPlayer;
    public Board board;
    public static int nbToWin = 5;
    public static int tour = 0;
    public static ArrayList<Position> coupsjoues = new ArrayList();

    private boolean play(Position p) {
        // Tente d'éxecuter un coup
        return false;
    }

    public static void afficherCoupsJoues() {
        System.out.print("Listes des coups joués : ");
        for (Position p : coupsjoues) {
            System.out.print(Position.positionToString(p) + " ");
        }
    }
}
