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

    /**
     * Metodin tarkoituksena on laivojen lisääminen pelilaudalle manuaalisesti
     * testaamista varten
     *
     * @param laiva manuaalisesti lisättävä laiva
     */
    public void lisaaLaivaManuaalisesti(Laiva laiva) {
        this.laivat.add(laiva);
        for (Ruutu r : laiva.getOsat()) {
            this.ruudut[r.getX()][r.getY()].asetaLaiva(laiva);

        }
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
     * Alustaa jokaisen ruudun koordinaatit oikein. Jotta vanhojen pelien tiedot
     * eivät rikkoisi peliä, metodi asettaa myös jokaisen ruudun ammuttu
     * tilanteeksi false, ja poistaa mahdolliset laivat ruuduista.
     *
     */
    public void alustaRuudut() {
        for (int i = 0; i < this.koko; i++) {
            for (int j = 0; j < this.koko; j++) {
                Ruutu r = new Ruutu(j, i);
                r.setAmmuttu(false);
                r.poistaLaiva();
                this.ruudut[j][i] = r;
            }
        }
    }

    /**
     * Metodi luo viisi eri kokoista laivaa ja lisää ne pelilaudalle.
     *
     *
     */
    public void luoLaivat() {

        luoLaiva(2);
        luoLaiva(2);
        luoLaiva(3);
        luoLaiva(3);
        luoLaiva(4);
        luoLaiva(5);

    }

    /**
     * Luodaan pelilaudan alkutilanne asettamalla kaikkien ruutujen arvot oikein
     * sekä luomalla laivat. Metodi myös tyhjentää laivalistan, jotta edellisten
     * pelien laivat eivät jäisi muistiin.
     */
    public void luoPeliTilanne() {

        this.alustaRuudut();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.ruudut[j][i].poistaLaiva();
            }
        }
        this.laivat.clear();
        this.luoLaivat();

    }

    /**
     * Metodi yksittaisen laivan luomiseen ja sen sijoittamiseen
     * sattumanvaraiselle paikalle pelilaudalla.
     *
     * @param i
     * @return palauttaa laivan
     */
    public Laiva luoLaiva(int i) {
        ArrayList<Ruutu> osat = new ArrayList();
        Laiva laiva = new Laiva(osat, this);
        Random arpoja = new Random();
        int suunta = arpoja.nextInt(2);

        int paikka = arpoja.nextInt(9 - i);
        int tiedettyPaikka = arpoja.nextInt(9);
        for (int j = 0; j < i; j++) {
            if (suunta == 1) {

                Ruutu r = new Ruutu(paikka + j, tiedettyPaikka);
                if (!tarkistaOnkoRuutuSallittu(r)) {
                    luoLaiva(i);
                    laiva = new Laiva(new ArrayList(), this);
                    osat = new ArrayList();
                    break;
                } else {

                    osat.add(r);
                }
            } else {

                Ruutu r = new Ruutu(tiedettyPaikka, paikka + j);
                if (!tarkistaOnkoRuutuSallittu(r)) {
                    luoLaiva(i);
                    laiva = new Laiva(new ArrayList(), this);
                    osat = new ArrayList();
                    break;

                } else {

                    osat.add(r);

                }
            }

        }

        for (Ruutu o : osat) {
            ruudut[o.getX()][o.getY()].asetaLaiva(laiva);

        }
        if (laiva.getOsat().size() != 0) {
            this.laivat.add(laiva);
        }

        return laiva;
    }

    /**
     *
     * Metodin tehtävän on tarkistaa uuden laivan luontia varten ruutujen
     * kelpoisuus laivan sijoittamista varten.
     *
     * @param r parametrina saatu ruutu jonka vaaka- ja pystysuunnassa (mikäli
     * mahdollista) olevat viereiset ruudut tarkistetaan muiden laivojen
     * varalta. Mikäli muita laivoja löytyy palautetaan false.
     * @return palautetaan totuusarvo siitä voiko ruutuun asettaa laivan vai ei.
     */
    public boolean tarkistaOnkoRuutuSallittu(Ruutu r) {

        if (ruudut[r.getX()][r.getY()].onkoLaiva()) {
            return false;
        } else if (r.getX() == 0 && r.getY() == 0) {
            if (ruudut[r.getX() + 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() + 1].onkoLaiva()) {
                return false;
            }

        } else if (r.getX() == 0 && r.getY() == 9) {
            if (ruudut[r.getX() + 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() - 1].onkoLaiva()) {
                return false;
            }

        } else if (r.getX() == 0 && (r.getY() < 9 && r.getY() > 0)) {
            if (ruudut[r.getX() + 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() + 1].onkoLaiva() || ruudut[r.getX()][r.getY() - 1].onkoLaiva()) {
                return false;
            }
        } else if (r.getX() == 9 && r.getY() == 9) {
            if (ruudut[r.getX() - 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() - 1].onkoLaiva()) {
                return false;
            }
        } else if (r.getX() == 9 && r.getY() == 0) {
            if (ruudut[r.getX() - 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() + 1].onkoLaiva()) {
                return false;
            }
        } else if (r.getX() == 9 && (r.getY() < 9 || r.getY() > 0)) {
            if (ruudut[r.getX() - 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() - 1].onkoLaiva() || ruudut[r.getX()][r.getY() + 1].onkoLaiva()) {
                return false;
            }
        } else if ((r.getX() < 9 && r.getX() > 0) && (r.getY() < 9 && r.getY() > 0)) {
            if (ruudut[r.getX() - 1][r.getY()].onkoLaiva() || ruudut[r.getX() + 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() + 1].onkoLaiva() || ruudut[r.getX()][r.getY() - 1].onkoLaiva()) {
                return false;
            }

        } else if ((r.getX() < 9 && r.getX() > 0) && r.getY() == 0) {
            if (ruudut[r.getX() - 1][r.getY()].onkoLaiva() || ruudut[r.getX() + 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() + 1].onkoLaiva()) {
                return false;
            }
        } else if ((r.getX() < 9 && r.getY() > 0) && r.getY() == 9) {
            if (ruudut[r.getX() - 1][r.getY()].onkoLaiva() || ruudut[r.getX() + 1][r.getY()].onkoLaiva() || ruudut[r.getX()][r.getY() - 1].onkoLaiva()) {
                return false;
            }
        }

        return true;
    }
}
