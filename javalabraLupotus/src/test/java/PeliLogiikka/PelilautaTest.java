/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    Laiva ol;
    List<Ruutu> osat;
    
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
        osat = new ArrayList();
        osat.add(new Ruutu(1,1));
        osat.add(new Ruutu(1,2));
        lauta.alustaRuudut();
        
        
        ol = new Laiva(osat, lauta);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void luoLaivat(){
        assertEquals(lauta.getLaivat().size(),0);
        lauta.luoLaivat();
        assertEquals(lauta.getLaivat().size(),5);
    }
    
    
    
}
