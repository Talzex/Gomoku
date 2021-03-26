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
   Color color;
   
   Position(int col, int row){
       this.col = col;
       this.row = row;
       this.color = Color.NONE;
   }
   
   public boolean estOccupee(){
       if(this.color == Color.NONE){
           return false;
       } else {
           return true;
       }
   }
   
}