/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author Julian Forme
 */
public class InvalidCoordinatesException extends Exception{

    /**
     * Soulève une exception si une case est déjà occupé
     * @param s
     */
    public InvalidCoordinatesException(String s){
        System.err.println(s);
    }
    
}
