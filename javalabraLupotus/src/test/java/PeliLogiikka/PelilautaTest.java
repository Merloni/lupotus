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
    Laiva laiva;
    Laiva laiva2;
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
        osat.add(new Ruutu(1, 1));
        osat.add(new Ruutu(1, 2));

        laiva = new Laiva(osat, lauta);
        osat = new ArrayList();
        osat.add(new Ruutu(5, 5));
        osat.add(new Ruutu(5, 6));
        laiva2 = new Laiva(osat, lauta);
        lauta.lisaaLaivaManuaalisesti(laiva);
        lauta.lisaaLaivaManuaalisesti(laiva2);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoAlustusTest() {
        assertEquals(lauta.getRuudut()[1][1], null);
        lauta.alustaRuudut();
        assertEquals(lauta.getRuudut()[1][1].getX(), 1);
        lauta.getRuudut()[5][5].ammu();
        assertEquals(lauta.getRuudut()[5][5].getAmmuttu(), true);
    }

    @Test
    public void onkoKaikkiUponneet() {
        lauta.alustaRuudut();
        assertEquals(lauta.onkoKaikkiUponneet(), false);
        lauta.getRuudut()[1][1].ammu();
        lauta.getRuudut()[1][2].ammu();
        assertEquals(laiva.onkoUponnut(), true);
        lauta.getRuudut()[5][5].ammu();
        lauta.getRuudut()[5][6].ammu();
        assertEquals(lauta.onkoKaikkiUponneet(), true);
    }

    @Test
    public void osuukoKokoOikeinTest() {
        assertEquals(lauta.getKoko(), 10);
    }

    @Test
    public void laivojenGettausTest() {
        lauta.alustaRuudut();
        assertEquals(lauta.getLaivat().size(), 2);
    }

    @Test
    public void peliTilanteenLuomisTest() {
        lauta.luoPeliTilanne();
        assertEquals(lauta.getLaivat().size(), 8);
        lauta.getRuudut()[2][2].ammu();
        assertEquals(lauta.getRuudut()[2][2].getAmmuttu(), true);
    }

}
