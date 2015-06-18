package ui;

import Kuuntelijat.RuutuListener;
import Kuuntelijat.LopetaListener;
import Kuuntelijat.AloitaPeliListener;
import Kuuntelijat.HighscoreListener;
import Kuuntelijat.KeskeytysListener;
import Kuuntelijat.ValikkoListener;
import PeliLogiikka.Pelilauta;
import PeliLogiikka.TiedostoKasittelija;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tuosalme
 */
public class UI implements Runnable {

    private JFrame frame;
    private Container c;
    private final Pelilauta lauta = new Pelilauta(10);
    private final JPanel peliPaneeli = new JPanel();
    private final JPanel highscore = new JPanel();
    private int vuoro;
    private String nimi = "";
    private ArrayList<JButton> napit = new ArrayList();
    private TiedostoKasittelija tk = new TiedostoKasittelija(this);

    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * Metodi alustaa vuoromäärän nollaksi. Sen jälkeen kutsutaan lauta-luokan
     * luoPeliTilanne-metodia joka alustaa laudan ruudut ja luo siihen laivat.
     * Sen jälkeen luodaan JPanel jolla on tarvittavat komponentit.
     * 
     * 
     * 
     * 
     */
    public void luoPeli() {

        this.vuoro = 0;
        lauta.luoPeliTilanne();
        peliPaneeli.setLayout(new BorderLayout());
        peliPaneeli.add(luoSivupalkki(), BorderLayout.WEST);
        peliPaneeli.add(luoPeliPainikkeet(), BorderLayout.CENTER);
        peliPaneeli.add(luoYlapalkki(), BorderLayout.NORTH);
        peliPaneeli.add(luoLopetusNappi(), BorderLayout.SOUTH);

        c.setBackground(peliPaneeli.getBackground());

        muutaTilaa(peliPaneeli);

    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public Pelilauta getLauta() {
        return this.lauta;
    }

    public ArrayList<JButton> getNapit() {
        return this.napit;
    }

    /**
     * Luo Highscore näkymän, jossa on otsikko, lista parhaista suorituksista
     * sekä valikkoon palaamisnappi.
     *
     */
    public void luoHighscore() {
        tk.lueHighscore();

        highscore.setLayout(new BorderLayout());

        highscore.add(luoHighscoreOtsikko(), BorderLayout.NORTH);
        highscore.add(luoHighscoreLista(), BorderLayout.CENTER);
        highscore.add(luoHighscoreNapit(), BorderLayout.PAGE_END);
        c.setBackground(highscore.getBackground());

        muutaTilaa(highscore);

    }

    /**
     * Metodi luo JPanel-olion, jonka sisältöne on kymmenen parasta suoritusta
     * aikaisemmilta pelikerroilta.
     *
     * @return palauttaa JPanel-olion jossa top10 highscore
     */
    public JPanel luoHighscoreLista() {
        JPanel paneeli = new JPanel();
        paneeli.setLayout(new BorderLayout());
        paneeli.setPreferredSize(new Dimension(100, 100));
        paneeli.add(tk.lueHighscore(),BorderLayout.CENTER);

        return paneeli;
    }

    /**
     * Metodi poistaa kaikki komponentit Framen Container-oliolta ja asettaa
     * sinne sitten parametrinä saatavan JPanel olion. Metodi asettaa ruudun
     * yläreunaan tyhjän paneelin estettiisen tyydyttävyyden vuoksi.
     *
     *
     * @param panel JPanel olio, joka piirretään näkyville.
     */
    public void muutaTilaa(JPanel panel) {
        JPanel haamuPaneeli = new JPanel();
        haamuPaneeli.setPreferredSize(new Dimension(0, 500));
        c.removeAll();
        c.repaint();
        c.setLayout(new FlowLayout());
        c.add(haamuPaneeli);
        c.add(panel);

        c.validate();
        frame.pack();
    }
    public Container getC(){
        return this.c;
    }
    /**
     * Luo JPanel-olion jonka sisällä on 10x10 taulukko. Taulukkoon asetetaan
     * tarvittava määrä JButton-olioita, joille annetaan tapahtumankuuntelia.
     * Jokaisen JButtonin kuvake saadaan sitä vastaavalta ruutu-oliolta.
     *
     * @return palauttaa JPanel-olion jossa 10x10taulukko JButtoneita.
     */
    public JPanel luoPeliPainikkeet() {

        JPanel painikkeet = new JPanel();
        painikkeet.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {

                JButton nappi = new JButton("" + lauta.getRuudut()[j][i].getMerkki());
                nappi.addActionListener(new RuutuListener(lauta.getRuudut()[j][i], this, lauta, nappi));
                nappi.setPreferredSize(new Dimension(48, 29));
                napit.add(nappi);

                painikkeet.add(nappi);
            }

        }

        return painikkeet;
    }

    /**
     * Luo pelinäkymään yläpalkin jossa ovat ruutujen x-akselin koordinaatit
     * muutettuina aakkosten ensimmäisiksi kymmeneksi kirjaimeksi.
     *
     * @return palauttaa JPanel-olion jossa aakkoset A-J allekkain.
     */
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
        JPanel vuoroPaneeli = new JPanel();
        vuoroPaneeli.setLayout(new BorderLayout());
        vuoroPaneeli.add(new JLabel("" + this.vuoro));

        return vuoroPaneeli;
    }

    /**
     * Metodi jota kutsutaan jokaisen kelvollisen laukauksen jälkeen. Kasvattaa
     * vuoro-attribuutin arvoa jokaisella kutsumiskerralla.
     */
    public void kasvataVuoroa() {
        this.vuoro++;
    }

    /**
     *
     * Luo paneelin ja asettaa siihen JButtonin johon lisätään
     * tapahtumankuuntelija. Tapahtumankuuntelija keskeyttää pelin ja palauttaa
     * pelaajan takaisin valikkoon.
     *
     * @return JPanel-olio jossa JButton-olio tapahtumakuuntelijalla.
     */
    public JPanel luoLopetusNappi() {
        JPanel paneeli = new JPanel();
        JButton lopetus = new JButton("Lopeta peli");
        lopetus.addActionListener(new KeskeytysListener(this));

        paneeli.add(lopetus);

        return paneeli;
    }

    /**
     * Asettaa numerot 0-9 pelilaudan sivuun näyttämään koordinaatiston kohtia.
     *
     * @return JPanel-olio jossa pelitilanteen sivupalkki.
     */
    public JPanel luoSivupalkki() {
        JPanel sivuPaneeli = new JPanel();
        sivuPaneeli.setLayout(new GridLayout(10, 0));
        for (int i = 0; i < 10; i++) {
            sivuPaneeli.add(new JLabel("" + i), BorderLayout.WEST);
        }

        return sivuPaneeli;
    }

    /**
     * Luo valikon JPanel-olion ja otsikon tiettyihin paikkoihin ja asettaa
     * taustavärin sekä muuttaa otsikon kokoa.
     *
     * @return palauttaa JPanel-olion jossa valikon näkymä.
     */
    public JPanel luoValikko() {

        JPanel paneeli = new JPanel();
        JLabel otsikko = new JLabel("Lupotus!");
        otsikko.setFont(new Font("Comic Sans", Font.PLAIN, 100));
        paneeli.setLayout(new BorderLayout());
        paneeli.add(otsikko, BorderLayout.NORTH);
        paneeli.add(luoValikkoNapit(), BorderLayout.CENTER);

        paneeli.setBackground(Color.pink);
        c.setBackground(paneeli.getBackground());
        muutaTilaa(paneeli);
        return paneeli;

    }

    /**
     * Luo valikkonäkymään napit ja antaa niille tapahtumankuuntelijat.
     *
     * @return JPanel-olio jossa kolme JButton-oliota tapahtumankuuntelijoineen.
     */
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

    /**
     *
     * @return Palauttaa JPanel-olion joka luo highscorenäkymään otsikon.
     */
    public JPanel luoHighscoreOtsikko() {
        JPanel otsikkoPaneeli = new JPanel();
        otsikkoPaneeli.setLayout(new BorderLayout());
        JLabel otsikko = new JLabel("Highscore:");
        otsikko.setFont(new Font("Comic Sans", Font.PLAIN, 80));
        otsikkoPaneeli.add(otsikko, BorderLayout.NORTH);

        return otsikkoPaneeli;

    }

    /**
     *
     *
     * @return JPanel-olio jossa on takaisin valikkoon viemä JButton-olio.
     */
    public JPanel luoHighscoreNapit() {
        JPanel highscoreNapit = new JPanel();
        highscoreNapit.setLayout(new BorderLayout());
        JButton ok = new JButton("Palaa");
        ok.addActionListener(new ValikkoListener(this));
        highscoreNapit.add(ok, BorderLayout.CENTER);

        return highscoreNapit;
    }

    /**
     * Tapahtumankuuntelija kutsuu metodia pelin päättyessä. Se tallettaa
     * pelaajan antaman nimen sekä käytettyjen vuorojen määrän highscore
     * listaukseen.
     */
    public void kirjaaHighscoreen() {
        tk.lisaaTiedostoon(nimi, vuoro);
    }

    public int getVuoro() {
        return this.vuoro;
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
