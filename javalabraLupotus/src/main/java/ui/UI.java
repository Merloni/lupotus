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
    private JMenuItem m;
    private Pelilauta lauta = new Pelilauta(10);
    private JTextField boksi;
    private JPanel peliPaneeli = new JPanel();

    public JFrame getFrame() {
        return this.frame;
    }

    public void paivita() {
        c.removeAll();
        c.add(peliPaneeli);
        c.repaint();

    }

    public void luoPeli() {
        lauta.alustaRuudut();

        peliPaneeli.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        peliPaneeli.setLayout(new GridLayout(10, 10));

        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                Ruutu r = lauta.getRuudut()[i][j];
                r.setLabel("" + lauta.getRuudut()[i][j].getMerkki());
                r.addActionListener(new RuutuListener(r, this, lauta));
                peliPaneeli.add(r);

            }

        }

        c.removeAll();
        c.add(peliPaneeli);
        c.repaint();

        c.validate();
        frame.pack();

    }

    public JPanel luoSivuPalkki() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        for (int i = 0; i < 10; i++) {
            panel.add(new JLabel("" + i));
        }

        return panel;
    }

    public JPanel luoValikko() {
        JButton aloitus = new JButton("Aloita Peli");
        //JButton highscore = new JButton("Highscore");
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
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = frame.getContentPane();

        c.setLayout(new FlowLayout());

        c.add(luoValikko());

        frame.pack();
        frame.setVisible(true);

    }

}
