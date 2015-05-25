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
public class PelilautaTest {
    Pelilauta lauta;
    Laiva laiva;
    
    public PelilautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauta = new Pelilauta(10);
        laiva = new Laiva(1,1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelilautaConstructorTest(){
        
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                assertEquals(lauta.getLauta()[i][j],0);               
            }          
        }
    }
    @Test
    public void pelilautaLisaaLaivaTest(){
        assertEquals(lauta.getLaivat().size(),0);
        lauta.lisaaLaiva(laiva);
        assertEquals(lauta.getLaivat().contains(laiva),true);
    }
    @Test
    public void alustaRuudutTest(){
       assertEquals(lauta.getRuudut().isEmpty(),true);
       lauta.alustaRuudut();
       assertEquals(lauta.getRuudut().isEmpty(),false);
       
   }
}
