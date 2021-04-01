/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author jforme/tduthil
 */
public class HumanPlayer implements Player {
    public String username;
    
    public HumanPlayer(String username) {
        this.username = username;
    }

    @Override
    public Position choice(Board b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
