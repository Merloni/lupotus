/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ui.UI;

/**
 * Luokka on pelin keskeytystä varten luotu tapahtumankuuntelija joka
 * kiinnitetään pelin ollessa käynnissä ilmestyvään "Keskeytä peli"- JButtoniin.
 * Valikkonäkymän luomisen lisäksi se muuttaa kaikkien pelitilassa olevien
 * nappien ulkoasun takaisin alkutilaan.
 *
 * @author tuosalme
 */
public class KeskeytysListener implements ActionListener {

    private UI ui;

    /**
     *
     * @param ui parametrinä saatava ui-olio mahdollistaa pääsyn valikkotilan
     * luomiseen sekä nappien muuttamiseen takaisin oikeanlaiseen ulkoasuun.
     */
    public KeskeytysListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.muutaTilaa(ui.luoValikko());
        for (JButton b : ui.getNapit()) {
            b.setLabel("~");
            b.setBackground(new JButton().getBackground());

        }
    }

}
