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
        List<Ruutu> osat = new ArrayList();
        List<Ruutu> kaikkiOsat = new ArrayList();
        osat.add(ruudut[0][0]);
        kaikkiOsat.add(ruudut[0][0]);
        Laiva l = new Laiva(osat, this);
        this.laivat.add(l);
        osat = new ArrayList();
        osat.add(ruudut[1][0]);
        osat.add(ruudut[1][1]);
        kaikkiOsat.add(ruudut[1][0]);
        kaikkiOsat.add(ruudut[1][1]);
        Laiva la = new Laiva(osat, this);
        this.laivat.add(la);
        osat = new ArrayList();
        osat.add(ruudut[2][0]);
        osat.add(ruudut[2][1]);
        osat.add(ruudut[2][2]);
        kaikkiOsat.add(ruudut[2][0]);
        kaikkiOsat.add(ruudut[2][1]);
        kaikkiOsat.add(ruudut[2][2]);
        Laiva lai = new Laiva(osat, this);
        this.laivat.add(lai);
        osat = new ArrayList();
        osat.add(ruudut[3][0]);
        osat.add(ruudut[3][1]);
        osat.add(ruudut[3][2]);
        osat.add(ruudut[3][3]);
        kaikkiOsat.add(ruudut[3][0]);
        kaikkiOsat.add(ruudut[3][1]);
        kaikkiOsat.add(ruudut[3][2]);
        kaikkiOsat.add(ruudut[3][3]);
        Laiva laiv = new Laiva(osat, this);
        this.laivat.add(laiv);
        osat = new ArrayList();
        osat.add(ruudut[4][0]);
        osat.add(ruudut[4][1]);
        osat.add(ruudut[4][2]);
        osat.add(ruudut[4][3]);
        osat.add(ruudut[4][4]);
        kaikkiOsat.add(ruudut[4][0]);
        kaikkiOsat.add(ruudut[4][1]);
        kaikkiOsat.add(ruudut[4][2]);
        kaikkiOsat.add(ruudut[4][3]);
        kaikkiOsat.add(ruudut[4][4]);
        Laiva laiva = new Laiva(osat, this);
        this.laivat.add(laiva);
        for (Ruutu r : kaikkiOsat) {
            ruudut[r.getX()][r.getY()].asetaLaiva();
        }

    }
    public void luoPeliTilanne(){
        this.alustaRuudut();
        this.luoLaivat();
        
    }
    

}
