
package PeliLogiikka;


public class Ruutu {
    
    private static int x;
    private static int y;
    private static boolean onkoLaiva = false;
    private static boolean onkoAmmuttu = false;
    private static Laiva laiva;
    
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
    public Laiva getLaiva(){
        return this.laiva;
    }
    public boolean onkoAmmuttu(){
        return onkoAmmuttu;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
}
