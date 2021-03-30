/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author tduthil/jforme
 */
public class Board {

    Color get(Position p) {
        return p.color;
    }

    void set(Position p, Color c) {
        p.color = c;
    }

    static void dessinerLigne() {
        System.out.print("   +");
        for (int i = 0; i <= Match.nb_colonnes * 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    static void dessinerLettreHaut() {
        char letter = 'A';
        System.out.print("     ");
        for (int i = 0; i < Match.nb_colonnes; i++) {
            System.out.print(letter + " ");
            letter += 1;
        }
        System.out.println("");
    }

    static void dessinerBoard() {
        // création du board + remplissage vide
        String board[][] = new String[Match.nb_colonnes][Match.nb_lignes];
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        for (int i = 0; i < Match.nb_lignes; i++) {
            int u = 0;
            if (i < 9) {
                System.out.print(" ");
            }
            // affichage des nombres sur le côté
            System.out.print(i + 1 + " | ");
            while (u < Match.nb_colonnes) {
                System.out.print(board[u][i] + " ");
                u++;
            }
            System.out.print("|");
            System.out.println("");
        }
    }

    static void dessiner() {
        dessinerLettreHaut();
        dessinerLigne();
        dessinerBoard();
        dessinerLigne();
    }
}
