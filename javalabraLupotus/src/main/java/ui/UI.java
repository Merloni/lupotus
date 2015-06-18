package ui;

import Kuuntelijat.RuutuListener;
import Kuuntelijat.LopetaListener;
import Kuuntelijat.AloitaPeliListener;
import Kuuntelijat.HighscoreListener;
import Kuuntelijat.KeskeytysListener;
import Kuuntelijat.ValikkoListener;
import PeliLogiikka.Pelilauta;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * TÃ¤mÃ¤ luokka hoitaa valikon ja pelitilanteen piirtÃ¤misen, sekÃ¤
 * pelitilanteen graafisen ulkoasun pÃ¤ivittÃ¤misen.
 *
 *
 * @author Tuomo
 */
public class UI implements Runnable {
    
    private JFrame frame;
    private Container c;
    private final Pelilauta lauta = new Pelilauta(10);
    private final JPanel peliPaneeli = new JPanel();
    private final JPanel highscore = new JPanel();
    private int vuoro = 0;
    private ArrayList<JButton> napit = new ArrayList();
    
    public JFrame getFrame() {
        return this.frame;
    }
    
    public void luoPeli() {
        
        lauta.luoPeliTilanne();
        System.out.println(lauta.getLaivat());
        peliPaneeli.setLayout(new BorderLayout());
        peliPaneeli.add(luoSivupalkki(), BorderLayout.WEST);
        peliPaneeli.add(luoPeliPainikkeet(), BorderLayout.CENTER);
        peliPaneeli.add(luoYlapalkki(), BorderLayout.NORTH);
        peliPaneeli.add(luoLopetusNappi(), BorderLayout.SOUTH);
        
        muutaTilaa(peliPaneeli);
        
    }

    public Pelilauta getLauta() {
        return this.lauta;
    }

    public ArrayList<JButton> getNapit() {
        return this.napit;
    }
    
    public void luoHighscore() {
        
        highscore.setLayout(new BorderLayout());
        
        highscore.add(luoHighscoreOtsikko(), BorderLayout.NORTH);
        highscore.add(luoHighscoreNapit(), BorderLayout.SOUTH);
        
        muutaTilaa(highscore);
        
    }
    
    public void muutaTilaa(JPanel panel) {
        c.removeAll();
        c.repaint();
        c.setLayout(new FlowLayout());
        c.add(panel);
        
        c.validate();
        frame.pack();
    }
    
    public JPanel luoPeliPainikkeet() {
        
        JPanel painikkeet = new JPanel();
        painikkeet.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                
                JButton nappi = new JButton("" + lauta.getRuudut()[j][i].getMerkki());
                nappi.addActionListener(new RuutuListener(lauta.getRuudut()[j][i], this, lauta, nappi));
                nappi.setPreferredSize(new Dimension(43, 26));
                napit.add(nappi);
                
                painikkeet.add(nappi);
            }
            
        }
        
        return painikkeet;
    }
    
    public JPanel luoYlapalkki() {
        JPanel ylaPaneeli = new JPanel();
        ylaPaneeli.setLayout(new GridLayout(1, 10));
        char aakkoset[] = "ABCDEFGHIJ".toCharArray();
        for (int i = 0; i < 10; i++) {
            ylaPaneeli.add(new JLabel(Character.toString(aakkoset[i])), BorderLayout.NORTH);
            
        }
        return ylaPaneeli;
    }
    
    public JPanel luoVuoronSeuraaja() {
        JPanel sivuPaneeli = new JPanel();
        sivuPaneeli.setLayout(new BorderLayout());
        sivuPaneeli.add(new JLabel("" + this.vuoro));
        
        return sivuPaneeli;
    }

    public void kasvataVuoroa() {
        this.vuoro++;
    }

    public JPanel luoLopetusNappi() {
        JPanel paneeli = new JPanel();
        JButton lopetus = new JButton("Lopeta peli");        
        lopetus.addActionListener(new KeskeytysListener(this));
        
        paneeli.add(lopetus);
        
        return paneeli;
    }
    
    public JPanel luoSivupalkki() {
        JPanel sivuPaneeli = new JPanel();
        sivuPaneeli.setLayout(new GridLayout(10, 0));
        for (int i = 0; i < 10; i++) {
            sivuPaneeli.add(new JLabel("" + i), BorderLayout.WEST);
        }
        
        return sivuPaneeli;
    }
    
    public JPanel luoValikko() {
        
        JPanel paneeli = new JPanel();
        paneeli.setLayout(new BorderLayout());
        paneeli.add(luoValikkoNapit(), BorderLayout.NORTH);
        
        muutaTilaa(paneeli);
        return paneeli;
        
    }
    
    public JPanel luoValikkoNapit() {
        JPanel paneeli = new JPanel();
        JButton aloitus = new JButton("Aloita Peli");
        JButton tulos = new JButton("Highscore");
        JButton lopetus = new JButton("Lopeta");
        
        aloitus.addActionListener(new AloitaPeliListener(this));
        tulos.addActionListener(new HighscoreListener(this));
        lopetus.addActionListener(new LopetaListener());
        paneeli.setLayout(new BorderLayout());
        paneeli.add(aloitus, BorderLayout.NORTH);
        paneeli.add(tulos, BorderLayout.CENTER);
        paneeli.add(lopetus, BorderLayout.SOUTH);
        
        return paneeli;
        
    }
    
    public JPanel luoHighscoreOtsikko() {
        JPanel otsikkoPaneeli = new JPanel();
        otsikkoPaneeli.setLayout(new BorderLayout());
        JLabel otsikko = new JLabel("Highscore:");
        otsikkoPaneeli.add(otsikko, BorderLayout.NORTH);
        
        return otsikkoPaneeli;
        
    }
    
    public JPanel luoHighscoreNapit() {
        JPanel highscoreNapit = new JPanel();
        highscoreNapit.setLayout(new BorderLayout());
        JButton ok = new JButton("Palaa");
        ok.addActionListener(new ValikkoListener(this));
        highscoreNapit.add(ok);
        
        return highscoreNapit;
    }
    
    @Override
    public void run() {
        
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c = frame.getContentPane();
        
        c.setLayout(new FlowLayout());
        
        c.add(luoValikko(), BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
