/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tduthil/jforme
 */
public class Board {

    static public int nb_colonnes;
    static public int nb_lignes;
    Color[][] color;

    Board(int nb_colonnes, int nb_lignes) {
        Board.nb_colonnes = nb_colonnes;
        Board.nb_lignes = nb_lignes;
        color = new Color[nb_colonnes][nb_lignes];
    }

    Color get(Position p) {
        return p.color;
    }

    void set(Position p, Color c) {
        p.color = c;
        color[p.col][p.row] = c;
    }

    void dessinerLigne() {
        System.out.print("   +");
        for (int i = 0; i <= nb_colonnes * 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    void dessinerLettreHaut() {
        char letter = 'A';
        System.out.print("     ");
        for (int i = 0; i < nb_colonnes; i++) {
            System.out.print(letter + " ");
            letter += 1;
        }
        System.out.println("");
    }

    void dessinerIntérieurBoard() {

        // création du board + remplissage vide
        String board[][] = new String[nb_colonnes][nb_lignes];
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
        for (int i = 0; i < nb_lignes; i++) {
            int u = 0;
            if (i < 9) {
                System.out.print(" ");
            }
            // affichage des nombres sur le côté
            System.out.print(i + 1 + " | ");
            while (u < nb_colonnes) {
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

    void initBoardSize() {
        Scanner in = new Scanner(System.in);

        int entierSaisi = 0;
        boolean saisieCorrecte;
        for (int i = 0; i < 2; i++) {
            entierSaisi = 0;
            saisieCorrecte = false;
            do {
                try {
                    if (i == 0) {
                        System.out.println("> Indiquez le nombre de colonnes du plateau (entre 5 et 26 inclus).");
                    } else {
                        System.out.println("> Indiquez le nombre de lignes du plateau (entre 5 et 26 inclus).");
                    }
                    entierSaisi = in.nextInt();
                    saisieCorrecte = (entierSaisi >= 5 && entierSaisi <= 26);
                    if (!saisieCorrecte) {
                        System.out.println("> " + entierSaisi + " n'est pas compris entre 5 et 26...");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.err.println("> Saisie incorrecte, saisissez un entier compris entre 5 et 26 inclus.");
                    in.next();
                }
            } while (!saisieCorrecte);
            if (i == 0) {
                nb_colonnes = entierSaisi;
            } else {
                nb_lignes = entierSaisi;
            }
        }
    }

    void initBoard() {
        initBoardSize();
        color = new Color[nb_colonnes][nb_lignes];
        for (Color[] col : color) {
            Arrays.fill(col, Color.NONE);
        }
    }

    void dessiner() {
        dessinerLettreHaut();
        dessinerLigne();
        dessinerIntérieurBoard();
        dessinerLigne();
    }

    /*
    * @return true ssi une case est libre
     */
    public boolean isFree(Position p) {
        return Color.NONE == this.color[p.col][p.row];
    }

    public boolean estDansPlateau(Position p) {
        return p.col >= 0 && p.col < nb_colonnes && p.row >= 0 && p.row < nb_lignes;
    }

    public boolean isFull() {
        boolean full = true;
        for (int i = 0; i < nb_colonnes; i++) {
            for (int u = 0; u < nb_lignes; u++) {
                if(color[i][u] == Color.NONE){
                    full = false;
                }
            }
        }
        return full;
    }
    
    /*
    public boolean rowComplete(){
        Color actualColor;
        boolean isRow = false;
        for(int i = 0; i < nb_lignes; i++){
            actualColor = Color.NONE;
            for(int u = 0; u < nb_colonnes; u++){
                actualColor = color[u][i];
            }
        }
    }*/
    
    public boolean isWin(){
        return false;
    }
}
