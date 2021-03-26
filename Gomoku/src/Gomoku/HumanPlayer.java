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
public class HumanPlayer implements Player {
    String pseudo;
    
    public HumanPlayer(String pseudo) {
        this.pseudo = pseudo;
    }    

    @Override
    public Position choice(Board b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
