package ui;

import PeliLogiikka.Laiva;
import PeliLogiikka.Pelilauta;
import PeliLogiikka.Ruutu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public RuutuListener(Ruutu ruutu, UI ui, Pelilauta lauta) {
        this.ruutu = ruutu;
        this.ui = ui;
        this.lauta = lauta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char aakkoset[] = "ABCDEFGHIJ".toCharArray();

        if (this.ruutu.getAmmuttu()) {
            JOptionPane.showMessageDialog(ui.getFrame(), "Ruutuun on jo ammuttu, yritä uudestaan.");
        } else if (!this.ruutu.onkoLaiva()) {

            JOptionPane.showMessageDialog(ui.getFrame(), "Ammuit ruutuun " + Character.toString(aakkoset[ruutu.getX()]) + ruutu.getY() + ", ei osumaa.");
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].ammu();
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].muutaMerkkia('O');

        } else {

            String teksti = "Ammuit ruutuun " + Character.toString(aakkoset[ruutu.getX()]) + ruutu.getY();
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].ammu();
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].muutaMerkkia('X');
            if (this.ruutu.getLaiva().onkoUponnut()) {
                teksti += ", osui ja upposi!";
                JOptionPane.showMessageDialog(ui.getFrame(), teksti);
            } else {
                teksti += ", osui!";
                JOptionPane.showMessageDialog(ui.getFrame(), teksti);
            }

            if (lauta.onkoKaikkiUponneet()) {
                int result = JOptionPane.showConfirmDialog(ui.getFrame(),
                        "Onneksi olkoon, voitit pelin!",
                        "Voitit pelin!", JOptionPane.DEFAULT_OPTION);
                if (result == 0 || result == 1) {
                    System.exit(0);
                }
            }
        }

    }

}
