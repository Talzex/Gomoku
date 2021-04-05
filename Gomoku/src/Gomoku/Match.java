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
    static Player joueur1;
    static Player joueur2;

    Match(int largeur, int hauteur, Player j1, Player j2) throws InvalidSizeException {
        if (hauteur >= 5 && hauteur <= 26 && largeur >= 5 && largeur <= 26) {
            b = new Board(largeur, hauteur);
        } else {
            throw new InvalidSizeException(hauteur, largeur);
        }
        joueur1 = j1;
        joueur2 = j2;
    }

    public void run() throws InvalidCoordinatesException {
        boolean ended = false;
        boolean win = false;
        b.initBoard();
        joueur1.initUsername();
        joueur2.initUsername();
        do {
            Game.nextPlayer = Color.BLACK;
            Position p = joueur1.choice(b);
            b.set(p, Game.nextPlayer);
            Game.coupsjoues.add(p);
            b.dessiner();
            ended = b.isFull();
            if (!ended) {
                Game.nextPlayer = Color.WHITE;
                Position p2 = joueur2.choice(b);
                b.set(p2, Game.nextPlayer);
                Game.coupsjoues.add(p);
                b.dessiner();
            }
            //win = isWin();
            ended = b.isFull();
        } while (!win && !ended);

        if (win) {
            System.out.println("> Victoire du joueur " + joueur1.getUsername()
                    + ".");
        } else {
            System.out.println("> Aucun joueur n'a gagné, match nul.");
        }
    }
}
