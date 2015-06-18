/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliLogiikka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

/**
 *
 * @author Tuomo
 */
public class TiedostoKasittelija {

    private FileWriter tiedostoKirjaaja;
    private PrintWriter kirjoittaja;
    private FileReader lukija;
    private BufferedReader lukijaHommels;
    private TreeMap<Integer,String> highscore = new TreeMap();

    public void lisaaTiedostoon(String nimi, int tulos) {
        try {
            tiedostoKirjaaja = new FileWriter("Highscore.txt", true);
            kirjoittaja = new PrintWriter(tiedostoKirjaaja);

            kirjoittaja.println(nimi + "\t \t \t" + tulos);
            kirjoittaja.close();

        } catch (IOException e) {

            System.out.println("ERROR!");
        }

    }

    public void lueHighscore() {
        try {
            
            lukija = new FileReader("Highscore.txt");
            lukijaHommels = new BufferedReader(lukija);
            
            
        } catch (IOException e) {
            

        }
    }

}
