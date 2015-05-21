
package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuosalme
 */
public class Pelilauta {
    public static int[][] lauta;
    public static List<Laiva> laivat;
    public static int koko;
    
    
    public Pelilauta(int koko){
        this.lauta = new int[koko][koko];
        this.laivat = new ArrayList();
        this.koko = koko;
        
    } 
    
    public void piirraValiaikainenLauta(int koko){
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                if (lauta[i][j] == 1){
                    System.out.print("X");
                }
                else if(lauta[i][j] == 2){
                    System.out.println("O");
                }
                else{
                    System.out.print("~");
                }
            }
            System.out.println("");
        }
        
    }
    public void ammu(int x, int y){
        for (Laiva l : laivat) {
            if(l.x == x && l.y == y){
                l.onAmmuttu();
            }
            
        }
        if(lauta[x][y] == 1){
            System.out.println("Kohtaan " + x + " " + y + " on jo ammuttu");
        }
        else{
            lauta[x][y] = 1;
        }
        
    }
    public void lisaaLaiva(Laiva laiva){
        laivat.add(laiva);
    }
    
    
}
