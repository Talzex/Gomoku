/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.util.Arrays;

/**
 *
 * @author tduthil/jforme
 */
public class Board {

    static Color[][] color = new Color[Match.nb_colonnes][Match.nb_lignes];
    
    
    static Color get(Position p) {
        return p.color;
    }

    static void set(Position p, Color c) {
        p.color = c;
        color[p.col][p.row] = c;
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

    static void dessinerIntérieurBoard() {
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
                if (color[u][i] == Color.BLACK) {
                    board[u][i] = "X";
                } else if (color[u][i] == Color.WHITE) {
                    board[u][i] = "O";
                }
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
        dessinerIntérieurBoard();
        dessinerLigne();
    }
}
