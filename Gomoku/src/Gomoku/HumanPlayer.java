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

    int tour = 0;
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
            if (tour < 1) {
                continuer = b.isFree(p) && b.estDansPlateau(p);
            } else {
                continuer = b.isFree(p) && b.estDansPlateau(p) && b.isAdj(p);
            }
            tour++;
            if (!b.estDansPlateau(p)) {
                System.err.println("Erreur : Coordonnées max lignes = " + b.nb_lignes);
                System.err.println("Erreur : Coordonnées max colonnes = " + b.nb_colonnes);
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
                if (Match.joueur2.getUsername().equals(Match.joueur1.getUsername())) {
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
