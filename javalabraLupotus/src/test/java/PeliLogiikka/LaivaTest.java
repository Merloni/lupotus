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
    Ruutu ruutu;
    Ruutu ruutu2;

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
        ruutu = new Ruutu(1, 1);
        ruutu2 = new Ruutu(2, 1);
        ruudut.add(ruutu);
        ruudut.add(ruutu2);
        lauta = new Pelilauta(10);
        lauta.alustaRuudut();
        laiva = new Laiva(ruudut, lauta);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getOsatTest() {
        assertEquals(laiva.getOsat().size(), 2);
    }
    
}
