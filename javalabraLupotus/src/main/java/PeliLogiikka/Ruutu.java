
package PeliLogiikka;


public class Ruutu {
    
    public static int x;
    public static int y;
    public static boolean onkoLaiva = false;
    public static boolean onkoAmmuttu = false;
    public static Laiva laiva;
    
    public Ruutu(int x, int y){
        this.x = x;
        this.y = y;
        
        
    }
    public void asetaLaiva(Laiva l){
        this.onkoLaiva = true;
        this.laiva = l;
    }
    public void onAmmuttu(){
        this.onkoAmmuttu = true;
    }
    
}
