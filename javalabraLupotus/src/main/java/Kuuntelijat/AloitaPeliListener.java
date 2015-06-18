package Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.UI;

/**
 *
 * Tämä luokka on aloitusvalikossa JButtoniin kiinnitettävä kuuntelija, joka
 * aloittaa pelin piirtämällä aloitustilanteen.
 *
 * @author tuosalme
 */
public class AloitaPeliListener implements ActionListener {

    private UI ui;

    public AloitaPeliListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ui.luoPeli();

    }

}
