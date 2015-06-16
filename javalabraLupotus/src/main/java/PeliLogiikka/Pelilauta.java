package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Luokka pitää sisällään pelilaudan alustamiseen vaadittavan metodin,
 * tarvittavat getterit ja setterit sekä ruutujen tilaa muuttavan ammu()
 * metodin.
 *
 * Pelilauta sisältää myös metodin laudan laivojen luomiseen, jossa laivat
 * alustetaan ennaltamääritetyille paikoille.
 *
 * @author tuosalme
 */
public class Pelilauta {

    private List<Laiva> laivat = new ArrayList<Laiva>();
    private int koko;
    private Ruutu[][] ruudut;

    /**
     * Konstruktori joka määrittää kaksiulotteisen ruututaulukon koon ja muistaa
     * muuttujan koko.
     *
     * @param koko pelilaudan maksimi x ja y
     */
    public Pelilauta(int koko) {
        this.ruudut = new Ruutu[koko][koko];
        this.koko = koko;

    }

    /**
     * Metodi tarkistaa kaikkien pelilaudalla olevien laivojen uppoamistilan.
     * 
     * @return palautetaan true mikäli kaikki laivat ovat uponneet ja false
     * mikäli yksikin on vielä "ehjä"
     */
    public boolean onkoKaikkiUponneet() {
        for (Laiva l : laivat) {
            if (!l.onkoUponnut()) {
                return false;
            }
        }
        return true;
    }

    public int getKoko() {
        return this.koko;
    }

    public List getLaivat() {
        return this.laivat;
    }

    public Ruutu[][] getRuudut() {
        return this.ruudut;
    }

    /**
     * Alustaa jokaisen ruudun koordinaatit oikein.
     */
    public void alustaRuudut() {
        for (int i = 0; i < this.koko; i++) {
            for (int j = 0; j < this.koko; j++) {
                Ruutu r = new Ruutu(j, i);
                this.ruudut[j][i] = r;
            }
        }
    }

    /**
     * Metodi luo viisi eri kokoista laivaa ja lisää ne pelilaudalle ennalta
     * määrättyihin koordinaatteihin.
     *
     * Metodia ei tulla tällaisenaan käyttämään lopullisessa versiossa.
     */
    public void luoLaivat() {
        List<Ruutu> osat = new ArrayList();
        osat.add(ruudut[0][0]);
        Laiva l = new Laiva(osat, this);
        for (Ruutu o : osat) {
            ruudut[o.getX()][o.getY()].asetaLaiva(l);

        }
        this.laivat.add(l);
        osat = new ArrayList();
        osat.add(ruudut[1][0]);
        osat.add(ruudut[1][1]);
        Laiva la = new Laiva(osat, this);
        for (Ruutu o : osat) {
            ruudut[o.getX()][o.getY()].asetaLaiva(la);

        }
        this.laivat.add(la);
        osat = new ArrayList();
        osat.add(ruudut[2][0]);
        osat.add(ruudut[2][1]);
        osat.add(ruudut[2][2]);
        Laiva lai = new Laiva(osat, this);
        for (Ruutu o : osat) {
            ruudut[o.getX()][o.getY()].asetaLaiva(lai);

        }
        this.laivat.add(lai);
        osat = new ArrayList();
        osat.add(ruudut[3][0]);
        osat.add(ruudut[3][1]);
        osat.add(ruudut[3][2]);
        osat.add(ruudut[3][3]);
        Laiva laiv = new Laiva(osat, this);
        for (Ruutu o : osat) {
            ruudut[o.getX()][o.getY()].asetaLaiva(laiv);

        }
        this.laivat.add(laiv);
        osat = new ArrayList();
        osat.add(ruudut[4][0]);
        osat.add(ruudut[4][1]);
        osat.add(ruudut[4][2]);
        osat.add(ruudut[4][3]);
        osat.add(ruudut[4][4]);
        Laiva laiva = new Laiva(osat, this);
        for (Ruutu o : osat) {
            ruudut[o.getX()][o.getY()].asetaLaiva(laiva);

        }
        this.laivat.add(laiva);

    }

    /**
     * Luodaan pelilaudan alkutilanne asettamalla kaikkien ruutujen arvot oikein
     * sekä luomalla laivat.
     */
    public void luoPeliTilanne() {
        this.alustaRuudut();
        this.luoLaivat();

    }

    /**
     * Metodi yksittaisen laivan luomiseen ja sen sijoittamiseen
     * sattumanvaraiselle paikalle pelilaudalla. Vielä vaiheessa
     *
     * @param i asetettavan laivan koko
     */
    public Laiva luoLaiva(int i) {
        ArrayList<Ruutu> osat = new ArrayList();
        Random r = new Random();
        Laiva l = new Laiva(osat, this);

        return l;
    }

}
