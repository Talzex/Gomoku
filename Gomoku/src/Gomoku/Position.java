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
   
   Position(int row, int col){
       this.row = row;
       this.col = col;
       this.color = Color.NONE;
   }
}