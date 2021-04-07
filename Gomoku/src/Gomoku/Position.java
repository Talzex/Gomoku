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
        this.row = row;
        this.col = col;
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

    public static int rowToInt(String coord) throws InvalidCoordinatesException {

        try {
            if (coord.length() >= 2) {
                String s = String.valueOf(coord.charAt(1));
                // Si on a un nombre à 2 chiffres
                if (coord.length() > 2) {
                    s = s.concat(String.valueOf(coord.charAt(2)));
                }
                if (Integer.parseInt(s) > 26 || Integer.parseInt(s) <= 0) {
                    throw new InvalidCoordinatesException("Erreur : Taille entre 1 et 26");
                }
                return Integer.parseInt(s) - 1;

            } else {
                throw new InvalidCoordinatesException("Erreur : De la forme 'A1' ou 'A15'.");
            }
        } catch (NumberFormatException exception) {
            throw new InvalidCoordinatesException("Erreur : Caractère Invalide");
        }
    }

    public static int colToInt(String coord) throws InvalidCoordinatesException {
        try {
            if (coord.length() >= 2) {
                char i = coord.charAt(0);
                return (int) i - (int) 'A';
            } else {
                throw new InvalidCoordinatesException("Erreur : De la forme 'A1' ou 'A15'.");
            }
        } catch (NumberFormatException exception) {
            throw new InvalidCoordinatesException("Erreur : Caractère Invalide");
        }
    }

    public static Position[] diagonalesCroissantes(Position p) {
        Position[] diagonales = new Position[Game.nbToWin - 1];
        diagonales[0] = new Position(p.col + 1, p.row - 1); // NORD-EST 1
        diagonales[1] = new Position(p.col + 2, p.row - 2); // NORD-EST 2
        diagonales[2] = new Position(p.col - 1, p.row + 1); // SUD-OUEST 1
        diagonales[3] = new Position(p.col - 2, p.row + 2); // SUD-OUEST 2
        return diagonales;
    }

    public static Position[] diagonalesDecroissantes(Position p) {
        Position[] diagonales = new Position[Game.nbToWin - 1];
        diagonales[0] = new Position(p.col - 1, p.row - 1); // NORD-OUEST 1
        diagonales[1] = new Position(p.col - 2, p.row - 2); // NORD-OUEST 2
        diagonales[2] = new Position(p.col + 1, p.row + 1); // SUD-EST 1
        diagonales[3] = new Position(p.col + 2, p.row + 2); // SUD-EST 2
        return diagonales;
    }
    
    public static Position[] PositionAdj(Position p) {
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
}
