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
import ui.UI;

/**
 *
 * @author Tuomo
 */
public class TiedostoKasittelijaTest {
    
    TiedostoKasittelija tk;
    UI ui;
    
    public TiedostoKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        UI ui = new UI();
        tk = new TiedostoKasittelija(ui);
    }
    
    @After
    public void tearDown() {
    }
   

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
