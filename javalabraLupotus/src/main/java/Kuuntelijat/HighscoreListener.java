/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.UI;

/**
 * Luokka on "Highscore"-JButton olioon lisättävä tapahtumankuuntelija joka
 * muuttaa näkymän valikosta highscoreen.
 *
 * @author Tuomo
 */
public class HighscoreListener implements ActionListener {

    private UI ui;

    /**
     *
     * @param ui parametrinä saatava ui-olio joka mahdollistaa pääsyn highscoren
     * luomiseen.
     */
    public HighscoreListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.luoHighscore();
    }

}
