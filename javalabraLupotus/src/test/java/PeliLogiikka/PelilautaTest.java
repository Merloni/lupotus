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
    ArrayList<Ruutu> osat;

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
        osat.add(new Ruutu(0, 1));
        osat.add(new Ruutu(0, 2));

        laiva = new Laiva(osat, lauta);
        osat = new ArrayList();
        osat.add(new Ruutu(5, 5));
        osat.add(new Ruutu(5, 6));
        laiva2 = new Laiva(osat, lauta);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoAlustusTest() {
        assertEquals(lauta.getRuudut()[0][1], null);
        lauta.alustaRuudut();
        assertEquals(lauta.getRuudut()[0][1].getX(), 0);
        assertEquals(lauta.getRuudut()[5][5].getAmmuttu(), false);
        lauta.getRuudut()[5][5].ammu();
        assertEquals(lauta.getRuudut()[5][5].getAmmuttu(), true);
    }

    @Test
    public void onkoKaikkiUponneet() {
        lauta.alustaRuudut();
        assertEquals(lauta.onkoKaikkiUponneet(), true);
        lauta.lisaaLaivaManuaalisesti(laiva);
        lauta.lisaaLaivaManuaalisesti(laiva2);
        lauta.getRuudut()[0][1].ammu();
        lauta.getRuudut()[0][2].ammu();
        assertEquals(lauta.onkoKaikkiUponneet(), false);
        lauta.getRuudut()[5][5].ammu();
        lauta.getRuudut()[5][6].ammu();
        assertEquals(lauta.onkoKaikkiUponneet(), true);
    }

    @Test
    public void osuukoKokoOikeinTest() {
        assertEquals(lauta.getKoko(), 10);
    }

    @Test
    public void laivanLisaaminenManuaalisesti() {
        lauta.alustaRuudut();
        assertEquals(lauta.getRuudut()[0][1].getLaiva(), null);
        lauta.lisaaLaivaManuaalisesti(laiva);
        assertEquals(lauta.getRuudut()[0][1].getLaiva(), laiva);
        assertEquals(lauta.getRuudut()[0][2].getLaiva(), laiva);
    }

    @Test
    public void laivojenGettausTest() {
        lauta.alustaRuudut();
        lauta.lisaaLaivaManuaalisesti(laiva);
        lauta.lisaaLaivaManuaalisesti(laiva2);
        assertEquals(lauta.getLaivat().size(), 2);
    }

    @Test
    public void peliTilanteenLuomisTest() {
        lauta.luoPeliTilanne();
        assertEquals(lauta.getLaivat().size(), 6);
        lauta.getRuudut()[2][2].ammu();
        assertEquals(lauta.getRuudut()[2][2].getAmmuttu(), true);
    }

    @Test
    public void luoPeliTilanneTest() {
        lauta.luoPeliTilanne();
        assertEquals(lauta.getLaivat().size(), 6);
        lauta.getLaivat().clear();
        assertEquals(lauta.getLaivat().size(), 0);

    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit00Test() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(0, 0);
        lauta.getRuudut()[0][1].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[0][1].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[1][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[1][0].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[0][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);

    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit09Test() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(0, 9);
        lauta.getRuudut()[0][8].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[0][8].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[1][9].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[1][9].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[0][9].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);

    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit018Test() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(0, 5);
        lauta.getRuudut()[0][4].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[0][4].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[0][6].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[0][6].poistaLaiva();
        lauta.getRuudut()[1][5].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit99Test() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(9, 9);
        lauta.getRuudut()[9][8].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[9][8].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[9][9].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit90Test() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(9, 0);
        lauta.getRuudut()[8][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[8][0].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[9][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit918() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(9, 5);
        lauta.getRuudut()[9][4].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[9][4].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[9][6].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[9][6].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[8][5].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[8][5].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit1818() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(5, 5);
        lauta.getRuudut()[5][4].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[5][4].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[5][6].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[5][6].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[4][5].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[4][5].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[6][5].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[6][5].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[5][5].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);

    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit180() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(4, 0);
        lauta.getRuudut()[5][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[5][0].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[3][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[3][0].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[4][1].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[4][1].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[4][0].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);

    }

    @Test
    public void tarkistaRuudunSallittavuusKunKoordinaatit189() {
        lauta.alustaRuudut();
        Ruutu r = new Ruutu(4, 9);
        lauta.getRuudut()[5][9].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[5][9].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[3][9].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[3][9].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[4][8].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);
        lauta.getRuudut()[4][8].poistaLaiva();
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), true);
        lauta.getRuudut()[4][9].asetaLaiva(laiva);
        assertEquals(lauta.tarkistaOnkoRuutuSallittu(r), false);

    }

}
