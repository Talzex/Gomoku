/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.util.Scanner;

/**
 *
 * @author jforme/tduthil
 */
public class HumanPlayer implements Player {

    static Scanner in = new Scanner(System.in);
    public String username;

    public HumanPlayer(String username) {
        this.username = username;
    }

    @Override
    public Position choice(Board b) throws InvalidCoordinatesException {
        Position p = writeCoordinates(b);
        b.set(p, Game.nextPlayer);
        return p;
    }

    public Position writeCoordinates(Board b) throws InvalidCoordinatesException {
        Position p;
        boolean continuer;
        do {
            System.out.println("Quel coup voulez-vous jouer " + this.username + " ?");
            p = readCoordinates(b);
            continuer = b.isFree(p) || !b.estDansPlateau(p);
            if(!continuer){
                System.out.println("Ce choix de position n'est pas possible.");
            }
        } while (!continuer);
        return p;
    }

    static Position readCoordinates(Board b) throws InvalidCoordinatesException {
        String coupSaisi;
        Position p;
        coupSaisi = in.nextLine();
        p = new Position(coupSaisi);
        return p;
    }

}
