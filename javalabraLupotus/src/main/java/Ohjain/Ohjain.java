
package Ohjain;

import PeliLogiikka.Laiva;
import PeliLogiikka.Pelilauta;
import PeliLogiikka.Ruutu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuosalme
 */
public class Ohjain {
    
    private Pelilauta lauta = new Pelilauta(10);
    public void luoLaivat(){
        List<Ruutu> ruudut = new ArrayList();
        ruudut.add(new Ruutu(0,0));
        Laiva l = new Laiva(ruudut,lauta);
        lauta.lisaaLaiva(l);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(1,0));
        ruudut.add(new Ruutu(1,1));
        Laiva la = new Laiva(ruudut,lauta);
        lauta.lisaaLaiva(la);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(2,0));
        ruudut.add(new Ruutu(2,1));
        ruudut.add(new Ruutu(2,2));
        Laiva lai = new Laiva(ruudut,lauta);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(3,0));
        ruudut.add(new Ruutu(3,1));
        ruudut.add(new Ruutu(3,2));
        ruudut.add(new Ruutu(3,3));
        Laiva laiv = new Laiva(ruudut,lauta);
        ruudut = new ArrayList();
        ruudut.add(new Ruutu(4,0));
        ruudut.add(new Ruutu(4,1));
        ruudut.add(new Ruutu(4,2));
        ruudut.add(new Ruutu(4,3));
        ruudut.add(new Ruutu(4,4));
        Laiva laiva = new Laiva(ruudut,lauta);
        
        
    }
    
}
