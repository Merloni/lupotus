
package PeliLogiikka;


public class Ruutu {
    
    private int x;
    private int y;
    private boolean onkoLaiva = false;
    private boolean ampumisTilanne = false;
    private Laiva laiva;
    
    public Ruutu(int x, int y){
        this.x = x;
        this.y = y;
              
    }
    public void asetaLaiva(Laiva l){
        this.onkoLaiva = true;
        this.laiva = l;
    }
    public void ammu(){
        this.ampumisTilanne = true;
    }
    public Laiva getLaiva(){
        return this.laiva;
    }
    public boolean getAmmuttu(){
        return ampumisTilanne;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    @Override
    public String toString(){
        return this.x + ", " + this.y + ", " + this.ampumisTilanne;
    }
    
}
