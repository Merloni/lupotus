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
public class RuutuTest {
    Ruutu ruutu;
    Laiva laiva;
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruutu = new Ruutu(1,1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ruutuOnkoAmmuttuTest(){
        assertEquals(ruutu.getAmmuttu(),false);
        ruutu.ammu();
        assertEquals(ruutu.getAmmuttu(),true);
    }
}