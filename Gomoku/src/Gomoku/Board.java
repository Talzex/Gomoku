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

    public int nb_colonnes;
    public int nb_lignes;
    Color[][] color;

    Board(int nb_colonnes, int nb_lignes) {
        this.nb_colonnes = nb_colonnes;
        this.nb_lignes = nb_lignes;
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
        boolean isFree = true;
        try {
            isFree = Color.NONE == this.color[p.col][p.row];
        } catch (ArrayIndexOutOfBoundsException exception) {
        }
        return isFree;
    }

    public boolean estDansPlateau(Position p) {
        return p.col >= 0 && p.col < nb_colonnes && p.row >= 0 && p.row < nb_lignes;
    }

    public Position[] PositionAdj(Position p) {
        Position[] adj = new Position[8];
        adj[0] = new Position(p.col + 1, p.row); // NORD
        adj[1] = new Position(p.col - 1, p.row); // SUD
        adj[2] = new Position(p.col, p.row + 1);
        adj[3] = new Position(p.col, p.row - 1);
        adj[4] = new Position(p.col + 1, p.row + 1);
        adj[5] = new Position(p.col - 1, p.row + 1);
        adj[6] = new Position(p.col + 1, p.row - 1);
        adj[7] = new Position(p.col - 1, p.row - 1);
        return adj;
    }

    public boolean isAdj(Position p) {
        boolean isadj = false;
        Position adj[] = PositionAdj(p);
        for (int f = 0; f < 8; f++) {
            if (estDansPlateau(adj[f])) {
                if (color[adj[f].col][adj[f].row] == Game.nextPlayer) {
                    isadj = true;
                }
            }
        }
        return isadj;
    }

    public boolean isFull() {
        boolean full = true;
        for (int i = 0; i < nb_colonnes; i++) {
            for (int u = 0; u < nb_lignes; u++) {
                if (color[i][u] == Color.NONE) {
                    full = false;
                }
            }
        }
        return full;
    }

    public boolean rowComplete() {
        Color actualColor;
        boolean isRow = false;
        int count = 0;
        for (int i = 0; i < nb_lignes; i++) {
            actualColor = null;
            count = 0;
            for (int u = 0; u < nb_colonnes; u++) {

                if (color[u][i] != Color.NONE && (null == actualColor || actualColor == color[u][i])) {
                    actualColor = color[u][i];
                    count++;
                } else {
                    count = 0;
                }

                if (count >= Game.nbToWin) {
                    isRow = true;
                }
            }
        }
        return isRow;
    }

    public boolean colComplete() {
        Color actualColor;
        boolean isCol = false;
        int count = 0;
        for (int u = 0; u < nb_colonnes; u++) {
            actualColor = null;
            count = 0;
            for (int i = 0; i < nb_lignes; i++) {

                if (color[u][i] != Color.NONE && (null == actualColor || actualColor == color[u][i])) {
                    actualColor = color[u][i];
                    count++;
                } else {
                    count = 0;
                }
                if (count >= Game.nbToWin) {
                    isCol = true;

                }
            }
        }
        return isCol;
    }

    public Position[] diagonalesCroissantes(Position p) {
        Position[] diagonales = new Position[Game.nbToWin - 1];
        diagonales[0] = new Position(p.col + 1, p.row - 1); // NORD-EST 1
        diagonales[1] = new Position(p.col + 2, p.row - 2); // NORD-EST 2
        diagonales[2] = new Position(p.col - 1, p.row + 1); // SUD-OUEST 1
        diagonales[3] = new Position(p.col - 2, p.row + 2); // SUD-OUEST 2
        return diagonales;
    }

    public Position[] diagonalesDecroissantes(Position p) {
        Position[] diagonales = new Position[Game.nbToWin - 1];
        diagonales[0] = new Position(p.col - 1, p.row - 1); // NORD-OUEST 1
        diagonales[1] = new Position(p.col - 2, p.row - 2); // NORD-OUEST 2
        diagonales[2] = new Position(p.col + 1, p.row + 1); // SUD-EST 1
        diagonales[3] = new Position(p.col + 2, p.row + 2); // SUD-EST 2
        return diagonales;
    }

    public boolean diagComplete() {
        boolean isDiag = false;
        int count = 0;
        for (int u = 0; u < nb_colonnes; u++) {
            for (int i = 0; i < nb_lignes; i++) {

                count = 0;

                Position p = new Position(u, i);
                Position diagC[] = diagonalesCroissantes(p);
                Position diagD[] = diagonalesDecroissantes(p);

                for (int f = 0; f < 4; f++) {
                    if (estDansPlateau(diagC[f])) {
                        if (color[diagC[f].col][diagC[f].row] == color[u][i] && color[u][i] != Color.NONE) {
                            count++;
                        } else {
                            count = 0;
                        }
                    }
                    if (count >= 4) {
                        isDiag = true;
                    }
                }
                count = 0;
                for (int f = 0; f < 4; f++) {
                    if (estDansPlateau(diagD[f])) {
                        if (color[diagD[f].col][diagD[f].row] == color[u][i] && color[u][i] != Color.NONE) {
                            count++;
                            System.out.println("count" + count);
                        } else {
                            count = 0;
                        }

                    }
                    if (count >= 4) {
                        isDiag = true;
                    }
                }

            }
        }
        return isDiag;
    }

    public boolean isWin() {
        return rowComplete() || colComplete() || diagComplete();
    }
}
