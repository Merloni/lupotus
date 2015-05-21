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
public class PeliLogiikkaTest {
    
    public PeliLogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void laivaConstructorTest(){
        Laiva laiva = new Laiva(1,1);
        assertEquals(laiva.x,1);
        assertEquals(laiva.y,1);
        
    }
    //Tarkastetaan, että alustuu nollalle
    @Test
    public void pelilautaConstructorTest(){
        Pelilauta lauta = new Pelilauta(10);
        
        for (int i = 0; i < lauta.koko; i++) {
            for (int j = 0; j < lauta.koko; j++) {
                assertEquals(lauta.lauta[i][j],0);
                
            }
            
        }
    }
    @Test
    public void ammuTest(){
        Pelilauta lauta = new Pelilauta(10);
        Laiva laiva = new Laiva(1,1);
        assertEquals(laiva.ammuttu, false);
        lauta.ammu(1, 1);
        assertEquals(laiva.ammuttu, true);
        
        
        
    }
    @Test
    public void ruutuLaivaLisaysTest(){
        Ruutu r = new Ruutu(0,0);
        assertEquals(r.laiva,null);
        Laiva l = new Laiva(0,0);
        r.asetaLaiva(l);
        assertEquals(r.laiva,l);
        
    }
    @Test
    public void ruutuOnkoAmmuttuTest(){
        Ruutu r = new Ruutu(0,0);
        assertEquals(r.onkoAmmuttu,false);
        r.onAmmuttu();
        assertEquals(r.onkoAmmuttu,true);
    }
}
