
package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuosalme
 */
public class Pelilauta {
    private List<Laiva> laivat = new ArrayList();
    private int koko;
    private Ruutu[][] ruudut;
    
    
    public Pelilauta(int koko){
        this.ruudut = new Ruutu[koko][koko];
        this.koko = koko;
        
        
    }

    public int getKoko(){
        return this.koko;
    }
    public List getLaivat(){
        return this.laivat;
    }
    public Ruutu[][] getRuudut(){
        return this.ruudut;
    }
    public void alustaRuudut(){
        for (int i = 0; i < this.koko; i++) {
            for (int j = 0; j < this.koko; j++) {
                Ruutu r = new Ruutu(i,j);
                this.ruudut[i][j] = r;
            }        
        }
    }
    public void piirraValiaikainenLauta(){
        for (int i = 0; i < this.koko; i++) {
            for (int j = 0; j < this.koko; j++) {
                if(ruudut[i][j].getAmmuttu()){
                    System.out.print("X");
                }
                else{
                    System.out.print("~");
                }
            }
            System.out.println("");
        }
        
    }
    public void ammu(int x, int y){
        System.out.println("Yritit ampua ruutuun: (" + x + ", " + y + ")" );
        
        if (ruudut[x][y].getAmmuttu()){
            System.out.println("Olet jo ampunut ruutuun: (" + x + ", " + y + ")");
        }
        else{
            ruudut[x][y].ammu();
            System.out.println("Ammuit ruutuun: (" + x + ", " + y + ")");
            
            for (Laiva laiva : laivat) {
                laiva.onkoUponnut();

            
            }
            
        }
        
        
        
        
        
        
    }
    public void lisaaLaiva(Laiva ol){
        laivat.add(ol);
    }
    
    
}
