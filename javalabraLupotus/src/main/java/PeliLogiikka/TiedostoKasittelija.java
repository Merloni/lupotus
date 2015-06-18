/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeliLogiikka;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;
import javax.swing.BoxLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import ui.UI;

/**
 *
 * @author Tuomo
 */
public class TiedostoKasittelija {

    private FileWriter tiedostoKirjaaja;
    private PrintWriter kirjoittaja;
    private TreeMap<Integer, String> highscore = new TreeMap();
    private UI ui;

    public TiedostoKasittelija(UI ui) {
        this.ui = ui;
    }

    public void lisaaTiedostoon(String nimi, int tulos) {
        try {
            tiedostoKirjaaja = new FileWriter("Highscore.txt", true);
            kirjoittaja = new PrintWriter(tiedostoKirjaaja);

            kirjoittaja.println(nimi + "\t" + tulos);
            highscore.put(tulos, nimi);
            kirjoittaja.close();

        } catch (IOException e) {

            System.out.println("ERROR!");
        }

    }

    public JPanel lueHighscore() {

        JPanel paneeli = new JPanel();
        paneeli.setLayout(new BorderLayout());
        JTextArea tekstiAlue = new JTextArea();
        tekstiAlue.setBackground(new JPanel().getBackground());
        tekstiAlue.setSize(new Dimension(400, 400));
        tekstiAlue.setEditable(false);
        tekstiAlue.setFont(new Font("Comic Sans", Font.PLAIN, 13));

        try {

            FileReader lukija = new FileReader("Highscore.txt");
            BufferedReader lukijaHommels = new BufferedReader(lukija);
            String teksti;
            while ((teksti = lukijaHommels.readLine()) != null) {
                int i = Integer.parseInt(teksti.replaceAll("[^0-9]", ""));
                String s = teksti.split("\t")[0];
                highscore.put(i, s);

            }
            lukijaHommels.close();

        } catch (IOException e) {

        }
        if (highscore.size() > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.println(highscore.get(highscore.keySet().toArray()[i]));
                System.out.println(highscore.keySet().toArray()[i]);
                tekstiAlue.append(highscore.get(highscore.keySet().toArray()[i]) + "\t \t \t" + highscore.keySet().toArray()[i] + "\n");

            }

        } else {
            for (int i = 0; i < highscore.size(); i++) {
                System.out.println(highscore.get(highscore.keySet().toArray()[i]));
                System.out.println(highscore.keySet().toArray()[i]);
                tekstiAlue.append(highscore.get(highscore.keySet().toArray()[i]) + "\t \t \t" + highscore.keySet().toArray()[i] + "\n");

            }

        }

        paneeli.setBackground(ui.getC().getBackground());
        paneeli.add(tekstiAlue, BorderLayout.CENTER);
        return paneeli;
    }
    public void tyhjennaHighscore() throws IOException{
        tiedostoKirjaaja = new FileWriter("Highscore.txt");
        
        kirjoittaja = new PrintWriter(tiedostoKirjaaja);
        kirjoittaja.print("");
        kirjoittaja.close();
    }

}
