package Kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.UI;

/**
 * Luokka on pelissä lopetusnapille annettava tapahtumakuuntelija joka muuttaa
 * näkyvyyden pelistä valikkoon.
 *
 * @author Tuomo
 */
public class ValikkoListener implements ActionListener {

    private UI ui;

    /**
     * Luokan konstruktori
     *
     * @param ui kuuntelija ottaa parametrinä ui-olion joka antaa sille pääsyn
     * luoValikko() metodiin
     */
    public ValikkoListener(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ui.luoValikko();

    }

}
