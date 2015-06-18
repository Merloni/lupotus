package Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JOptionPane;
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
    Scanner lukija = new Scanner(System.in);

    public AloitaPeliListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int nimenTekoApu = 0;
        while (nimenTekoApu == 0) {
            ui.setNimi(JOptionPane.showInputDialog(ui.getFrame(),"Valitse nimi; "));
            if (ui.getNimi().length() > 0) {
                nimenTekoApu++;
                ui.luoPeli();

            }

        }



    }

}
