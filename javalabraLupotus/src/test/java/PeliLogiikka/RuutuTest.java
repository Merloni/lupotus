/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliLogiikka;

import java.util.ArrayList;
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
    Pelilauta lauta;

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
        lauta = new Pelilauta(10);
        ruutu = new Ruutu(1, 1);
        ArrayList<Ruutu> osat = new ArrayList();
        osat.add(new Ruutu(1, 1));
        osat.add(new Ruutu(1, 2));
        laiva = new Laiva(osat, lauta);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void ruutuOnkoAmmuttuTest() {
        assertEquals(ruutu.getAmmuttu(), false);
        ruutu.ammu();
        assertEquals(ruutu.getAmmuttu(), true);
    }

    @Test
    public void laivanLisaaminenRuutuunTest() {
        assertEquals(ruutu.onkoLaiva(), false);
        ruutu.asetaLaiva(laiva);
        assertEquals(ruutu.onkoLaiva(), true);
    }

    @Test
    public void toStringTest() {
        assertEquals(ruutu.toString(), "1, 1, false");
    }

    @Test
    public void getLaivaTest() {
        ruutu.asetaLaiva(laiva);
        assertEquals(ruutu.getLaiva().toString(), "Kaikki laivan osien koordinaatit: (1, 1)(1, 2)");
    }
}
