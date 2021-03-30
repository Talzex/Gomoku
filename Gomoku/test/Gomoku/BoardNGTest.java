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
public class BoardNGTest {

    public void BordNGTest() {
        Match.nb_colonnes = 10;
        Match.nb_lignes = 5;
        Board.dessiner();
    }

    /**
     * Test of get method, of class Board.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Position p = new Position(1, 1);
        Board instance = new Board();
        Color expResult = null;
        Color result = instance.get(p);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Board.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Position p = null;
        Color c = null;
        Board instance = new Board();
        instance.set(p, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dessinerLigne method, of class Board.
     */
    @Test
    public void testDessinerLigne() {
        Match.nb_colonnes = 10;
        Match.nb_lignes = 5;
        System.out.println("dessinerLigne");
        Board.dessinerLigne();

    }

    /**
     * Test of dessinerLettreHaut method, of class Board.
     */
    @Test
    public void testDessinerLettreHaut() {
        Match.nb_colonnes = 10;
        Match.nb_lignes = 5;
        System.out.println("dessinerLettreHaut");
        Board.dessinerLettreHaut();

    }

    /**
     * Test of dessinerBoard method, of class Board.
     */
    @Test
    public void testDessinerBoard() {
        Match.nb_colonnes = 10;
        Match.nb_lignes = 5;
        System.out.println("dessinerBoard");
        Board.dessinerBoard();
    }

    /**
     * Test of dessiner method, of class Board.
     */
    @Test
    public void testDessiner() {
        Match.nb_colonnes = 10;
        Match.nb_lignes = 5;
        System.out.println("dessiner");
        Board.dessiner();
    }

}
