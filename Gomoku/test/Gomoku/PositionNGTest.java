/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author tduthil
 */
public class PositionNGTest {

    /**
     * Test of getCol method, of class Position.
     */
    @Test
    public void testGetCol() {
        System.out.println("getCol");
        Position instance = new Position(3,4);
        int expResult = 3;
        int result = instance.getCol();
        assertEquals(result, expResult);
        
        System.out.println("getColLettre");
        /*Position instanceLettre = new Position("A4");*/
    }

    /**
     * Test of getLig method, of class Position.
     */
    @Test
    public void testGetLig() {
        System.out.println("getRow");
        Position instance = new Position(3,4);
        int expResult = 4;
        int result = instance.getRow();
        assertEquals(result, expResult);
    }
    
}
