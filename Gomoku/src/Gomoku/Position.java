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
public class Position {

    final int row, col;
    //final String coord;
    Color color;

    public Position(int col, int row) {
        this.row = row;
        this.col = col;
        this.color = Color.NONE;
        
    }

    /*public Position(String coord ) {
        this.col = coord.getCol();
        this.row = coord.getLig();
    }*/

    public  int getCol(){
        return this.col;
    }
    
    public int getLig(){
        return this.row;
    }
}

  
