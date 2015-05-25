/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import PeliLogiikka.Pelilauta;
import PeliLogiikka.Ruutu;
import java.util.ArrayList;

/**
 *
 * @author Tuomo
 */
public class Main {
    
    public static void main(String args[]){
        ArrayList<Ruutu> asd = new ArrayList();
        asd.add(new Ruutu(1,1));
        Pelilauta pelilauta = new Pelilauta(10);
        /*pelilauta.ammu(0, 0);
        pelilauta.ammu(1, 1);
        pelilauta.ammu(2, 2);
        pelilauta.ammu(3, 3);
        pelilauta.ammu(4, 4);
        pelilauta.piirraValiaikainenLauta();
        */
        pelilauta.alustaRuudut();
        for (Ruutu r: asd) {
            System.out.println(r.getX() + " " + r.getY());
        }
        
        
        
        
        
    }
    
}
