package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Luokkaan kuuluu laivan toiminnallisuudet, sen osat Ruutu -olioina ja tieto
 * siitä onko laiva uponnut vai ei.
 *
 * @author tuosalme
 */
public class Laiva {

    private List<Ruutu> osat = new ArrayList();
    private Pelilauta lauta;
    private boolean onkoUponnut = false;

    /**
     *
     * @param ruudut Lista ruuduista jotka kuuluvat laivaan
     * @param lauta Pelialustana toimiva pohja
     */
    public Laiva(List<Ruutu> ruudut, Pelilauta lauta) {
        this.osat = ruudut;
        this.lauta = lauta;

    }

    /**
     * Metodi tarkistaa laivaan kuuluvan jokaisen ruutuolion ampumistilanteen.
     * Mikäli jokainen ruutu on ammuttu metodi palauttaa true.
     *
     * @return onko kaikki laivan osat uponneet
     */
    public boolean onkoUponnut() {

        for (Ruutu r : osat) {

            if (!lauta.getRuudut()[r.getX()][r.getY()].getAmmuttu()) {

                return false;
            }

        }

        this.onkoUponnut = true;
        return this.onkoUponnut;
    }

    public List getOsat() {
        return this.osat;
    }

    @Override
    public String toString() {
        String s = "Kaikki laivan osien koordinaatit: ";
        for (int i = 0; i < osat.size(); i++) {
            s += "(" + osat.get(i).getX() + ", " + osat.get(i).getY() + ")";

        }
        return s;
    }

    public void lisaaOsa(Ruutu r) {
        this.osat.add(r);
    }

}
