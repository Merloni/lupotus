package PeliLogiikka;

import javax.swing.JButton;

/**
 *
 * Luokan ominaisuuksiin kuuluu tieto omasta sijainnista x- ja y-koordinaattien
 * avulla, tieto siitä onko ruutuun ammuttu vai ei ja onko ruudussa laiva.
 *
 *
 *
 * @author tuosalme
 */
public class Ruutu {

    private int x;
    private int y;
    private boolean onkoLaiva = false;
    private boolean ampumisTilanne = false;
    private Laiva laiva;
    private char merkki = '~';

    /**
     *
     * @param x ruudun parametrina saatava x-koordinaatti
     * @param y ruudun parametrina saatava y-koordinaatti
     */
    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;

    }

    /**
     * Asettaa ruudun laivatilanteen todeksi sekä kertaa oliolle mikä laiva
     * ruudussa on.
     *
     * @param l ruutuun asetettava laiva
     */
    public void asetaLaiva(Laiva l) {
        this.onkoLaiva = true;
        this.laiva = l;

    }

    /**
     * Asettaa ruudun laivan nulliksi sekä muuttaa laivatilanteen epätodeksi.
     */
    public void poistaLaiva() {
        this.onkoLaiva = false;
        this.laiva = null;
    }

    /**
     * Asettaa ruudun ammutuksi ja muuttaa sen merkkiä. Merkkiä ei tällä
     * hetkellä käytetä vaan JButton muuttaa ampumistilanteessa oman labelinsa
     * tarvittavaksi merkiksi.
     */
    public void ammu() {
        this.ampumisTilanne = true;
        if (this.onkoLaiva) {
            setMerkki('X');
        } else {

            setMerkki('O');
        }

    }

    public Laiva getLaiva() {
        return this.laiva;
    }

    public boolean getAmmuttu() {
        return ampumisTilanne;
    }

    public void setAmmuttu(boolean arvo) {
        this.ampumisTilanne = arvo;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Tarkistaa onko ruudussa laiva.
     *
     * @return palauttaa totuusarvon siitä onko ruudussa laiva vai ei
     */
    public boolean onkoLaiva() {
        return this.onkoLaiva;
    }

    public void setMerkki(char c) {
        this.merkki = c;
    }

    public char getMerkki() {
        return this.merkki;
    }

    @Override
    public String toString() {
        return this.x + ", " + this.y + ", " + this.ampumisTilanne;
    }

}
