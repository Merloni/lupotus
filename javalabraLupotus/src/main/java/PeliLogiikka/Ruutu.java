package PeliLogiikka;

import javax.swing.JButton;

/**
 *
 * Luokan ominaisuuksiin kuuluu tieto omasta sijainnista x- ja y-koordinaattien
 * avulla, tieto siitä onko ruutuun ammuttu vai ei ja onko ruudussa laiva.
 *
 * Ruutu toimii myös guihin piirretävänä JButton olentona.
 *
 * @author tuosalme
 */
public class Ruutu extends JButton {

    private int x;
    private int y;
    private boolean onkoLaiva = false;
    private boolean ampumisTilanne = false;
    private Laiva laiva;
    private char merkki = '~';

    public Ruutu(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void asetaLaiva() {
        this.onkoLaiva = true;
    }

    public void ammu() {
        this.ampumisTilanne = true;
        if (this.onkoLaiva) {
            muutaMerkkia('X');
        } else {

            muutaMerkkia('O');
        }

        this.setText((this.merkki) + "");
    }

    public Laiva getLaiva() {
        return this.laiva;
    }

    public boolean getAmmuttu() {
        return ampumisTilanne;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public boolean onkoLaiva() {
        return this.onkoLaiva;
    }

    public void muutaMerkkia(char c) {

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
