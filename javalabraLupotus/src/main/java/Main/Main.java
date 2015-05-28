/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import PeliLogiikka.Laiva;
import PeliLogiikka.Laiva;
import PeliLogiikka.Pelilauta;
import PeliLogiikka.Ruutu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuomo
 */
public class Main {
    
    
    public static void main(String args[]){
        Pelilauta lauta = new Pelilauta(10);
        lauta.alustaRuudut();
        List<Ruutu> osat = new ArrayList();
        osat.add(new Ruutu(1,1));
        osat.add(new Ruutu(1,2));
        Laiva laiva = new Laiva(osat,lauta);
        lauta.lisaaLaiva(laiva);
        
        System.out.println(laiva);
        lauta.ammu(1, 1);
        lauta.ammu(1, 2);
        lauta.ammu(1, 1);
        System.out.println(lauta.getLaivat());
        
        
        
        
        
        
        
        
        
        
    }
    
}
