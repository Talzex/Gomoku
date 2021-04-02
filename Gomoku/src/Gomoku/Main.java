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
public class Main {

    public static void main(String args[]) throws InvalidCoordinatesException, InvalidSizeException{
        
        Match m = new Match(5,5, new HumanPlayer("Anna"), new HumanPlayer("Bob"));
        m.run();
    }
}
