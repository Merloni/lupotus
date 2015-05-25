


package PeliLogiikka;



/**
 *
 * @author tuosalme
 */
public class Laiva {
    
    private boolean ammuttu;
    private int x;
    private int y;
    private int koko;
    
    
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
    public void setKoko(int koko){
        this.koko = koko;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getKoko(){
        return this.koko;
    }
    
    
    
}
