
package ui;

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
public class RuutuListener implements ActionListener{
    private Ruutu ruutu;
    private UI ui;
    private Pelilauta lauta;
    
    
    public RuutuListener(Ruutu ruutu, UI ui, Pelilauta lauta){
        this.ruutu = ruutu;
        this.ui = ui;
        this.lauta = lauta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(this.ruutu.getAmmuttu()){
            JOptionPane.showMessageDialog(ui.getFrame(),"Ruutuun on jo ammuttu, yritä uudestaan.");
        }
        else if(!this.ruutu.onkoLaiva()){
            
            JOptionPane.showMessageDialog(ui.getFrame(), "Ammuit ruutuun; " + ruutu.getX() + ", " + ruutu.getY() + ", ei osumaa.");
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].ammu();
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].muutaMerkkia('O');
            ui.paivita();
        }
        else{
            JOptionPane.showMessageDialog(ui.getFrame(), "Ammuit ruutuun; " + ruutu.getX() + ", " + ruutu.getY() + ", osui!");
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].ammu();
            lauta.getRuudut()[this.ruutu.getX()][this.ruutu.getY()].muutaMerkkia('X');
            ui.paivita();
        }

        
        
    }
    
}
