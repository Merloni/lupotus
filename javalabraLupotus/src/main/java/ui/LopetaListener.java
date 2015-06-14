/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Tämä luokka on aloitusvalikossa JButtoniin kiinnitettävä kuuntelija, joka
 * sulkee ohjelman.
 *
 * @author tuosalme
 */
public class LopetaListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

}
