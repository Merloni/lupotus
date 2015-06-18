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
    Ruutu toinenRuutu;
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
        lauta.alustaRuudut();
        ruutu = new Ruutu(1, 1);
        toinenRuutu = new Ruutu(1, 2);
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
    public void merkkiMuuttuuJosAmmutaanKunRuudussaOnLaivaTest() {
        ruutu.asetaLaiva(laiva);
        assertEquals(ruutu.getMerkki(), '~');
        ruutu.ammu();
        assertEquals(ruutu.getMerkki(), 'X');

    }

    @Test
    public void merkkiMuuttuuJosAmmutaanKunRuudussaEiOleLaivaaTest() {
        assertEquals(ruutu.getMerkki(), '~');
        ruutu.ammu();
        assertEquals(ruutu.getMerkki(), 'O');
    }

    @Test
    public void toStringTest() {
        assertEquals(ruutu.toString(), "1, 1, false");
        toinenRuutu.ammu();
        assertEquals(toinenRuutu.toString(), "1, 2, true");
    }

}
