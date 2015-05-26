/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;
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
    List<Ruutu> ruudut;
    Pelilauta lauta;
    
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
        ruudut = new ArrayList();
        Ruutu ruutu = new Ruutu(1,1);
        Ruutu ruutu2 = new Ruutu(2,2);
        ruudut.add(ruutu);
        ruudut.add(ruutu2);
        lauta = new Pelilauta(10);
        laiva = new Laiva(ruudut,lauta);
    }
    
    @After
    public void tearDown() {
    }

}
