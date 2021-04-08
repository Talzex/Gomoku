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

    /**
     * Constructeur de la classe Board
     *
     * @param nb_colonnes, le nombre de colonnes chosit par le joueur
     * @param nb_lignes, le nombre de ligne chosiit per le joueur
     */
    public Board(int nb_colonnes, int nb_lignes) {
        this.nb_colonnes = nb_colonnes;
        this.nb_lignes = nb_lignes;
        color = new Color[nb_colonnes][nb_lignes];
    }

    /**
     * Méthode permettant de connaître la couleur d'une position
     *
     * @param p, la Position
     * @return la couleur
     */
    Color get(Position p) {
        return p.color;
    }

    /**
     * Méthode permettant d'attribuer une couleur à une position
     *
     * @param p, la position
     * @param c, la couleur
     */
    void set(Position p, Color c) {
        p.color = c;
        color[p.col][p.row] = c;
    }

    /**
     * Méthode permettant de dessiner les lignes des côtés de notre Board
     */
    void dessinerLigne() {
        System.out.print("   +");
        for (int i = 0; i <= nb_colonnes * 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    /**
     * Méthode permettant de dessiner les lettres sur le haut du Board
     */
    void dessinerLettreHaut() {
        char letter = 'A';
        System.out.print("     ");
        for (int i = 0; i < nb_colonnes; i++) {
            System.out.print(letter + " ");
            letter += 1;
        }
        System.out.println("");
    }

    /**
     * Méthode permettant d'afficher les symboles en fonction de leur Couleurs
     */
    public void dessinerIntérieurBoard() {

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

    /**
     * Méthode permettant d'initialiser la taille du Board, en demandant aux
     * joueurs
     */
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

    /**
     * Méthode permettant d'initialiser toute les cases du Board à None
     */
    void initBoard() {
        initBoardSize();
        color = new Color[nb_colonnes][nb_lignes];
        for (Color[] col : color) {
            Arrays.fill(col, Color.NONE);
        }
    }

    /**
     * Méthode permettant de dessiner notre Board au complet
     */
    public void dessiner() {
        dessinerLettreHaut();
        dessinerLigne();
        dessinerIntérieurBoard();
        dessinerLigne();
    }

    /**
     * Méthode permettant de vérifier que le joueur pose sur une case vide
     * @param p, la position à vérifier
     * @return true si la Position est Libre, false sinon
     */
    public boolean isFree(Position p) {
        return  Color.NONE == this.color[p.col][p.row];
    }

    /**
     * Méthode permettant de vérifier que la position est bien dans le plateau.
     * @param p, la position à vérifier.
     * @return true si la Position est dans le plateau, faux sinon.
     */
    public boolean estDansPlateau(Position p) {
        return p.col >= 0 && p.col < nb_colonnes && p.row >= 0 && p.row < nb_lignes;
    }

    /**
     * Méthode permettant de vérifier que la postion est bien adjacente à une Position.
     * alliées.
     * @param p, la position à vérifier
     * @return true si la Position est adjacente à une autre, faux sinon.
     */
    public boolean isAdj(Position p) {
        boolean isAdj = false;
        Position adj[] = Position.PositionAdj(p);
        for (int f = 0; f < 8; f++) {
            if (estDansPlateau(adj[f])) {
                if (color[adj[f].col][adj[f].row] == Game.nextPlayer) {
                    isAdj = true;
                }
            }
        }
        return isAdj;
    }

    /**
     * Méthode permettant de savoir si le Board, est plein
     * @return true si il n'y a plus de place, faux sinon
     */
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

    /**
     * Méthode permettant de savoir si une Ligne est complète.
     * @return true si elle est complete, faux sinon.
     */
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

    /**
     * Méthode permettant de savoir si la colonne est complete.
     * @return true si elle complete, faux sinon.
     */
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

    /**
     * Méthode permettant de savoir si une diagonale est complete
     * @return true si elle est complete, faux sinon.
     */
    public boolean diagComplete() {
        boolean isDiag = false;
        int count = 0;
        for (int u = 0; u < nb_colonnes; u++) {
            for (int i = 0; i < nb_lignes; i++) {

                count = 0;

                Position p = new Position(u, i);
                Position diagC[] = Position.diagonalesCroissantes(p);
                Position diagD[] = Position.diagonalesDecroissantes(p);

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

    /**
     * Méthode pour savoir si il y a un gagnant.
     * @return true si une de ces trois conditions de victoires est vérifié
     */
    public boolean isWin() {
        return rowComplete() || colComplete() || diagComplete();
    }
    
    public Position[] coupsJouables(Board b){
        Position[] coupsJouables = new Position[676];
        int n = 0;
        for(int i = 0; i < nb_lignes; i++){
            for(int u = 0; u < nb_colonnes; u++){
                Position p = new Position(u,i);
                if(color[u][i] == Color.NONE && Game.tour <= 1){
                    coupsJouables[n] = p;
                    n++;
                } else if(b.isAdj(p) && isFree(p)){
                    coupsJouables[n] = p;
                    n++;
                }
            }
        }
        return Arrays.copyOf(coupsJouables, n);
    }
}
