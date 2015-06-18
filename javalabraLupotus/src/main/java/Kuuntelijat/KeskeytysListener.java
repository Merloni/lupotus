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
 *
 * @author Tuomo
 */
public class KeskeytysListener implements ActionListener {

    private UI ui;

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
