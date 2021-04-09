/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author tduthil
 */
public class GamePlayerLeaves extends Exception {

    /**
     * Soulève une exception si un joueur quitte la partie
     * @param s, le message
     */
    public GamePlayerLeaves(String s){
        System.out.println(s);
    }
}
