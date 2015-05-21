


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
    
    //Pelin alussa laivojen sijoittamiseen tarkoitetut metodit
    public void setX(int x){
        this.x = x;     
    }
    public void setY(int y){
        this.y = y;
    }
    
    
    
}
