/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author tduthil/jforme
 */
public class Position {

    final int row, col;
    //final String coord;
    Color color;

    public Position(int col, int row) {
        this.row = row;
        this.col = col;
        this.color = Color.NONE;

    }

    public Position(String coord) {
        this.col = colToInt(coord);
        this.row = rowToInt(coord);
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public static final int colToInt(String coord) {
        if (coord.length() >= 2) {
            String s = String.valueOf(coord.charAt(1));
            // Si on a un nombre à 2 chiffres
            if (coord.length() > 2) {
                s = s.concat(String.valueOf(coord.charAt(2)));
            }
            return Integer.parseInt(s);
        } else {
            // retourne une erreur
            return -1;
        }
    }

    public static int rowToInt(String coord) {
        if (coord.length() >= 2) {
            char i = coord.charAt(0);
            return (int) i - (int) 'A';
        } else {
            return -1;
        }
    }

    /*
    * @return true ssi une case est libre
     */
    public boolean isFree() {
        return this.color == Color.NONE;
    }
}
