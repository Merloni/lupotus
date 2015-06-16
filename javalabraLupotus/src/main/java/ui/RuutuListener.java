package ui;

import PeliLogiikka.Laiva;
import PeliLogiikka.Pelilauta;
import PeliLogiikka.Ruutu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Tuomo
 */
public class RuutuListener implements ActionListener {

    private Ruutu ruutu;
    private UI ui;
    private Pelilauta lauta;
    private JButton button;

    /**
     *
     * @param ruutu ruutu jonka koordinaatit kuuntelijan tulee tietää.
     * @param ui tapa päästä käsiksi frameen jotta asiat piirtyvät oikeisiin
     * paikkoihin.
     * @param lauta pelilaudalta tarvitaan tieto laivalistasta, jotta saadaan
     * selville kaikkien laivojen uponneisuus
     * @param button nappi jossa kuuntelija on kiinni. Klikattaessa ensimmäistä
     * kertaa tulee napin kuvakkeen muuttua
     */
    public RuutuListener(Ruutu ruutu, UI ui, Pelilauta lauta, JButton button) {
        this.ruutu = ruutu;
        this.ui = ui;
        this.lauta = lauta;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.ruutu.getAmmuttu()) {
            JOptionPane.showMessageDialog(ui.getFrame(), "Ruutuun on jo ammuttu, yritä uudestaan.");
        } else if (!this.ruutu.onkoLaiva()) {

            eiOsumaa();

        } else {

            osuma();

            voititkoPelin();
        }

    }

    /**
     * Mikäli klikattussa ruudussa ei ole, laivaa palautetaan tämä metodi.
     */
    public void eiOsumaa() {
        char aakkoset[] = "ABCDEFGHIJ".toCharArray();
        JOptionPane.showMessageDialog(ui.getFrame(), "Ammuit ruutuun " + Character.toString(aakkoset[ruutu.getX()]) + ruutu.getY() + ", ei osumaa.");
        lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].ammu();
        lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].muutaMerkkia('O');
        this.button.setLabel("O");

    }

    /**
     * Mikäli klikatussa ruudussa on laiva, palautetaan tämä metodi.
     */
    public void osuma() {
        char aakkoset[] = "ABCDEFGHIJ".toCharArray();
        String teksti = "Ammuit ruutuun " + Character.toString(aakkoset[ruutu.getX()]) + ruutu.getY();
        lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].ammu();
        lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].muutaMerkkia('X');
        this.button.setLabel("X");
        if (this.ruutu.getLaiva().onkoUponnut()) {
            teksti += ", osui ja upposi!";
            JOptionPane.showMessageDialog(ui.getFrame(), teksti);
        } else {
            teksti += ", osui!";
            JOptionPane.showMessageDialog(ui.getFrame(), teksti);
        }

    }

    /**
     * Tarkistetaan voittiko pelaaja pelin. Metodia kutsutaan jokaisen osuneen
     * laukauksen jälkeen.
     */
    public void voititkoPelin() {
        if (lauta.onkoKaikkiUponneet()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            int result = JOptionPane.showConfirmDialog(ui.getFrame(),
                    "Onneksi olkoon, voitit pelin!",
                    "Voitit pelin!", JOptionPane.DEFAULT_OPTION);
            if (result == 0 || result == 1) {
                ui.muutaTilaa(ui.luoValikko());
            }
        }

    }

}
