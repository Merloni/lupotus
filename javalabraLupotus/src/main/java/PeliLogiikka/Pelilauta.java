package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;

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

    private List<Laiva> laivat = new ArrayList();
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
                Ruutu r = new Ruutu(i, j);
                this.ruudut[i][j] = r;
            }
        }
    }

    /**
     * Metodi luo viisi eri kokoista laivaa ja lisää ne pelilaudalle ennalta
     * määrättyihin koordinaatteihin.
     *
     */
    public void luoLaivat() {
        List<Ruutu> ruudut = new ArrayList();
        ruudut.add(new Ruutu(0, 0));
        Laiva l = new Laiva(ruudut, this);
        this.laivat.add(l);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(1, 0));
        ruudut.add(new Ruutu(1, 1));
        Laiva la = new Laiva(ruudut, this);
        this.laivat.add(la);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(2, 0));
        ruudut.add(new Ruutu(2, 1));
        ruudut.add(new Ruutu(2, 2));
        Laiva lai = new Laiva(ruudut, this);
        this.laivat.add(lai);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(3, 0));
        ruudut.add(new Ruutu(3, 1));
        ruudut.add(new Ruutu(3, 2));
        ruudut.add(new Ruutu(3, 3));
        Laiva laiv = new Laiva(ruudut, this);
        this.laivat.add(laiv);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(4, 0));
        ruudut.add(new Ruutu(4, 1));
        ruudut.add(new Ruutu(4, 2));
        ruudut.add(new Ruutu(4, 3));
        ruudut.add(new Ruutu(4, 4));
        Laiva laiva = new Laiva(ruudut, this);
        this.laivat.add(laiva);

    }

}
