


package PeliLogiikka;



/**
 *
 * @author tuosalme
 */
public class Laiva {
    
    public boolean ammuttu;
    public int x;
    public int y;
    
    public Laiva(int x, int y){
        this.x = x;
        this.y = y;
        this.ammuttu = false;
        
    } 
    public void onAmmuttu(){
        this.ammuttu = true;
    }
    
    
    
}
