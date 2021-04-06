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
    public String getUsername() {
        return username;
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
            System.out.println("> Quel coup voulez-vous jouer " + this.username + " ?");
            p = readCoordinates(b);
            continuer = b.isFree(p) && b.estDansPlateau(p);
            if(!b.estDansPlateau(p)){
                System.err.println("Une position doit être de la forme 'A1' ou 'A15' en étant compris entre 1 et " + Board.nb_lignes + ".");
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

    @Override
    public void initUsername() {
        boolean continuer;
        do {
            if (Match.joueur1.getUsername().length() == 0) {
                System.out.println("> Comment s'appelle le joueur 1 ?");
            } else {
                if(Match.joueur2.getUsername().equals(Match.joueur1.getUsername())){
                    System.out.println();
                    System.out.println("> Cet utilisateur existe déjà");
                    System.out.println();
                }
                System.out.println("> Comment s'appelle le joueur 2 ?");
            }
            username = in.nextLine();
            continuer = username.length() == 0 || username.trim().equals("") || Match.joueur2.getUsername().equals(Match.joueur1.getUsername());
        } while (continuer);
    }

}
