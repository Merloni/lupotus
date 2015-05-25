/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliLogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tuomo
 */
public class LaivaTest {
    Laiva laiva;
    
    public LaivaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        laiva = new Laiva(1,1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void laivaConstructorTest(){
        assertEquals(laiva.getX(),1);
        assertEquals(laiva.getY(),1);
        
    }
    @Test
    public void muutaLaivanKoordinaatitTest(){
        assertEquals(laiva.getX(),1);
        assertEquals(laiva.getY(),1);
        laiva.setX(2);
        laiva.setY(3);
        assertEquals(laiva.getX(),2);
        assertEquals(laiva.getY(),3);
   }
}
