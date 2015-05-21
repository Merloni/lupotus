/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import PeliLogiikka.Pelilauta;

/**
 *
 * @author Tuomo
 */
public class Main {
    
    public static void main(String args[]){
        Pelilauta pelilauta = new Pelilauta(10);
        pelilauta.ammu(0, 0);
        pelilauta.ammu(1, 1);
        pelilauta.ammu(2, 2);
        pelilauta.ammu(3, 3);
        pelilauta.ammu(4, 4);
        pelilauta.piirraValiaikainenLauta(pelilauta.koko);
        
        
        
    }
    
}
