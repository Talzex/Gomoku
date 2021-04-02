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
    Color color;

    public Position(int col, int row) {
        this.row = row-1;
        this.col = col-1;
        this.color = Color.NONE;

    }

    public Position(String coord) throws InvalidCoordinatesException {
        this.col = colToInt(coord);
        this.row = rowToInt(coord);
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public static final int rowToInt(String coord) throws InvalidCoordinatesException {
        try {
            if (coord.length() >= 2) {
                String s = String.valueOf(coord.charAt(1));
                // Si on a un nombre à 2 chiffres
                if (coord.length() > 2) {
                    s = s.concat(String.valueOf(coord.charAt(2)));
                }
                if (Integer.parseInt(s) <= 25 && Integer.parseInt(s) > 0) {
                    return Integer.parseInt(s) - 1;
                } else {
                    throw new InvalidCoordinatesException("La taille de la ligne doit être comprise entre 1 et 25.");
                }
            } else {
                throw new InvalidCoordinatesException("Une position doit être de la forme 'A1' ou 'A15'.");
            }
        } catch (NumberFormatException exception) {
            throw new InvalidCoordinatesException("Le type de caractère est invalide." + exception);
        }
    }

    public static int colToInt(String coord) throws InvalidCoordinatesException {
            if (coord.length() >= 2) {
                char i = coord.charAt(0);
                return (int) i - (int) 'A';
            } else {
                throw new InvalidCoordinatesException("Une position doit être de la forme 'A1' ou 'A15'.");
            }
    }

}
