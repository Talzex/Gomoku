/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author tduthil
 */
public class PositionNGTest {

    /**
     * Test of getCol method, of class Position.
     * @throws Gomoku.InvalidCoordinatesException
     */
    @Test
    public void testGetCol() throws InvalidCoordinatesException {
        System.out.println("getCol");
        Position instance = new Position(3,4);
        int expResult = 3;
        int result = instance.getCol();
        assertEquals(result, expResult);
        
        System.out.println("getColLettre");
        Position instanceLettre = new Position("A14");
        int expResultLettre = 0;
        int resultLettre = instanceLettre.getCol();
        assertEquals(resultLettre, expResultLettre);
 
    }

    /**
     * Test of getLig method, of class Position.
     * @throws Gomoku.InvalidCoordinatesException
     */
    @Test
    public void testGetLig() throws InvalidCoordinatesException {
        System.out.println("getRow");
        Position instance = new Position(3,4);
        int expResult = 4;
        int result = instance.getRow();
        assertEquals(result, expResult);
        
        System.out.println("getRowLettre");
        Position instanceLettre = new Position("A13");
        int expResultLettre = 12;
        int resultLettre = Position.rowToInt("A13");
        assertEquals(resultLettre, expResultLettre);
       
    }
    
    @Test(expectedExceptions = InvalidCoordinatesException.class)
    public void testGetLigExcept() throws InvalidCoordinatesException {       
        System.out.println("getRowException");
        Position instanceErreur = new Position("A0");
        
        System.out.println("getRowException2");
        Position instanceErreur2 = new Position("A27");
    }
    
}
