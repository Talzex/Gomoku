/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author jforme
 */
public class InvalidSizeException extends Exception {

    public InvalidSizeException(int hauteur, int largeur) {
        System.out.println("La hauteur et la largeur du plateau doivent être compris entre 5 et 26 inclus. Hauteur: " + hauteur + " Largeur: " + largeur);
    }
    
}
