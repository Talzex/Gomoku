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
    public static Board board;
    public static int nbToWin = 5;
    public static int tour = 0;
    public static ArrayList<Position> coupsjoues = new ArrayList();

    /**
     * Méthode permettant de savoir si le coup du joueur est valide
     * @param p, la Position jouée
     * @return true si valide, false sinon.
     */
    public static boolean play(Position p) {
        if (tour < 1) {
            return estDansPlateau(p) && isFree(p);
        } else {
            return isFree(p) && estDansPlateau(p) && isAdj(p);
        }
    }

    /**
     * Méthode permettant de vérifier que le joueur pose sur une case vide
     *
     * @param p, la position à vérifier
     * @return true si la Position est Libre, false sinon
     */
    public static boolean isFree(Position p) {
        if (estDansPlateau(p)) {
            return Color.NONE == board.color[p.col][p.row];
        } else {
            return false;
        }
    }

    /**
     * Méthode permettant de vérifier que la position est bien dans le plateau.
     *
     * @param p, la position à vérifier.
     * @return true si la Position est dans le plateau, faux sinon.
     */
    public static boolean estDansPlateau(Position p) {
        return p.col >= 0 && p.col < board.nb_colonnes && p.row >= 0 && p.row < board.nb_lignes;
    }

    /**
     * Méthode permettant de vérifier que la postion est bien adjacente à une
     * Position. alliées.
     *
     * @param p, la position à vérifier
     * @return true si la Position est adjacente à une autre, faux sinon.
     */
    public static boolean isAdj(Position p) {
        boolean isAdj = false;
        Position adj[] = Position.PositionAdj(p);
        for (int f = 0; f < 8; f++) {
            if (estDansPlateau(adj[f])) {
                if (board.color[adj[f].col][adj[f].row] != Color.NONE) {
                    isAdj = true;
                }
            }
        }
        return isAdj;
    }

    /**
     * Méthode affichant les coups jouées lors de la partie
     */
    public static void afficherCoupsJoues() {
        System.out.print("Listes des " + coupsjoues.size() + " coups joués : ");
        for (Position p : coupsjoues) {
            System.out.print(Position.positionToString(p) + " ");
        }
    }
    
    public static void quit() {
        
    }
}
