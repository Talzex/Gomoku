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
public class Match {

    Board b;
    Player joueur1;
    Player joueur2;

    Match(int largeur, int hauteur, Player joueur1, Player joueur2) throws InvalidSizeException {
        if (hauteur >= 5 && hauteur <= 26 && largeur >= 5 && largeur <= 26) {
            b = new Board(largeur, hauteur);
        } else {
            throw new InvalidSizeException(hauteur, largeur);
        }
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    public void run() throws InvalidCoordinatesException {
        boolean ended = false;
        boolean win = false;
        b.initBoard();
        int nbCoup = 1;
        String joueur;
        do {
            Game.nextPlayer = Color.BLACK;
            Position p = joueur1.choice(b);
            b.set(p, Game.nextPlayer);
            Game.coupsjoues.add(p);
            b.dessiner();
            Game.nextPlayer = Color.WHITE;
            Position p2 = joueur2.choice(b);
            b.set(p2, Game.nextPlayer);
            Game.coupsjoues.add(p);
            b.dessiner();
            //win = isWin();
            //ended = isEnded();
        } while (!win && !ended);
    }
}
