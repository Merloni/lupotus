
package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;



public class Laiva {
    
    private List<Ruutu> osat = new ArrayList();
    private Pelilauta lauta;
    private boolean onkoUponnut = false;
    
    public Laiva(List<Ruutu> ruudut, Pelilauta lauta){
        this.osat = ruudut;
        this.lauta = lauta;
        
    }
        /*Tarkistetaan onko kaikki osat laivasta uponneet, 
        mikäli on, muutetaan laivan tilaksi uponnut.
        */
    public boolean onkoUponnut(){
        
        
        for (Ruutu r : osat) {
            
                    
            if(!lauta.getRuudut()[r.getX()][r.getY()].getAmmuttu())
            {
                
                return false;
            }
            
        }
        System.out.println("Osui ja upposi");
        this.onkoUponnut = true;
        return this.onkoUponnut;
    }
    public List getOsat(){
        return this.osat;
    }
    @Override
    public String toString(){
        String s = "Kaikki laivan osien koordinaatit: ";
        for (int i = 0; i < osat.size(); i++) {
            s += "(" + osat.get(i).getX() + ", " + osat.get(i).getY() + ")";
            
        }
        return s;
    }
    
}
