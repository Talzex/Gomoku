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
public interface Player  {
    Position choice(Board b) throws InvalidCoordinatesException;
    public String getUsername();
    public void initUsername();
}
