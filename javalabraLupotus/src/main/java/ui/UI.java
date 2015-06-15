package ui;

import PeliLogiikka.Pelilauta;
import PeliLogiikka.Ruutu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private Pelilauta lauta = new Pelilauta(10);
    private JPanel peliPaneeli = new JPanel();
    private JPanel konePaneeli = new JPanel();

    public JFrame getFrame() {
        return this.frame;
    }

    public void luoPeli() {

        peliPaneeli.setLayout(new BorderLayout());
        peliPaneeli.add(luoSivupalkki(), BorderLayout.WEST);
        peliPaneeli.add(luoPeliPainikkeet(), BorderLayout.CENTER);
        peliPaneeli.add(luoYlapalkki(), BorderLayout.NORTH);

        konePaneeli.setLayout(new BorderLayout());
        konePaneeli.add(luoSivupalkki(), BorderLayout.EAST);
        konePaneeli.add(luoKonePainikkeet(), BorderLayout.CENTER);
        konePaneeli.add(luoYlapalkki(), BorderLayout.NORTH);
        
        

        c.removeAll();
        c.repaint();
        c.setLayout(new BorderLayout());
        c.add(peliPaneeli);

        c.validate();
        frame.pack();

    }

    public JPanel luoPeliPainikkeet() {
        JPanel painikkeet = new JPanel();
        painikkeet.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painikkeet.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                Ruutu r = lauta.getRuudut()[i][j];
                r.setLabel("" + lauta.getRuudut()[i][j].getMerkki());
                r.addActionListener(new RuutuListener(r, this, lauta));

                painikkeet.add(r);

            }

        }
        return painikkeet;
    }
    
    public JPanel luoKonePainikkeet() {
        JPanel kohdat = new JPanel();
        kohdat.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        kohdat.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Ruutu r = new Ruutu(i,j);
                r.setLabel("~");
                kohdat.add(r);
            }
        }
        
        return new JPanel();
    }

    

    public JPanel luoYlapalkki() {
        JPanel ylaPaneeli = new JPanel();
        ylaPaneeli.setLayout(new GridLayout(0, 10));
        char aakkoset[] = "ABCDEFGHIJ".toCharArray();
        for (int i = 0; i < 10; i++) {
            ylaPaneeli.add(new JLabel(Character.toString(aakkoset[i])), BorderLayout.NORTH);

        }
        return ylaPaneeli;
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

        JButton aloitus = new JButton("Aloita Peli");
        JButton lopetus = new JButton("Lopeta");

        aloitus.addActionListener(new AloitaPeliListener(this));
        lopetus.addActionListener(new LopetaListener());
        JPanel paneeli = new JPanel();

        paneeli.setLayout(new BorderLayout());
        paneeli.add(aloitus, BorderLayout.CENTER);
        paneeli.add(lopetus, BorderLayout.SOUTH);
        return paneeli;

    }

    @Override
    public void run() {
        lauta.luoPeliTilanne();

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
