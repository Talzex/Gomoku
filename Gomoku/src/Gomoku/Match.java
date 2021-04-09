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
    static Player joueur1;
    static Player joueur2;

    /**
     * Constructeur de la classe Match
     * @param largeur, la largeur choisit par le joueur
     * @param hauteur, la hauteur choisit par le joueur
     * @param j1, le joueur 1
     * @param j2, le joueur 2
     * @throws InvalidSizeException
     */
     Match(int largeur, int hauteur, Player j1, Player j2) throws InvalidSizeException {
        if (hauteur >= 5 && hauteur <= 26 && largeur >= 5 && largeur <= 26) {
            Game.board = new Board(largeur, hauteur);
        } else {
            throw new InvalidSizeException(hauteur, largeur);
        }
        joueur1 = j1;
        joueur2 = j2;
    }

    /**
     * Méthode permettant de lancer le jeu, de l'arrêter sous certaines conditions
     * @throws InvalidCoordinatesException
     */
    public void run() throws InvalidCoordinatesException  {
        boolean ended = false;
        boolean win = false;
        Game.board .initBoard();
        joueur1.initUsername();
        joueur2.initUsername();
        System.out.println();
        System.out.println("> Pour jouer il faut écrire une position de la forme 'A5', 'B12'.");
        System.out.println();
        do {
            Game.nextPlayer = Color.BLACK;
            Game.coupsjoues.add(joueur1.choice(Game.board));
            Game.board .dessiner();
            Game.tour++;
            ended = Game.board .isFull();
            win = Game.board .isWin();
            if (!ended && !win) {
                Game.nextPlayer = Color.WHITE;
                Game.coupsjoues.add(joueur2.choice(Game.board ));
                Game.board .dessiner();
                Game.tour++;
            }
            System.out.println(Game.tour);
            win = Game.board .isWin();
            ended = Game.board .isFull();
        } while (!win && !ended);

        if (win) {
            
            if(Game.nextPlayer == Color.BLACK){
                System.out.println();
                System.out.println("> Victoire du joueur " + joueur1.getUsername()
                    + ".");
                System.out.println();
            } else {
                System.out.println();
                System.out.println("> Victoire du joueur " + joueur2.getUsername()
                    + ".");
                System.out.println();
            } 
        } else {
            System.out.println();
            System.out.println("> Aucun joueur n'a gagné, match nul.");
            System.out.println();
            
        }
        Game.afficherCoupsJoues();
        System.out.println();
    }
}
