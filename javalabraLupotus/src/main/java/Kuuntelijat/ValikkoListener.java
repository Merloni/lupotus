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
 *
 * @author Tuomo
 */
public class ValikkoListener implements ActionListener {

    private UI ui;

    public ValikkoListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.luoValikko();

    }

}
