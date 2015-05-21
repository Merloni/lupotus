
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
    
    
    public Pelilauta(int koko){
        lauta = new int[koko][koko];
        laivat = new ArrayList();
        
    }
    
    public static void main(String args[]){
        int xd = 10;
        Pelilauta pelilauta = new Pelilauta(xd);
        
        Laiva laiva = new Laiva(1,1);
        laivat.add(laiva);
        
        pelilauta.ammu(0,0);       
        pelilauta.ammu(5,5);
        pelilauta.ammu(xd-1,xd-1);
        pelilauta.ammu(10-4,5-1);
        
        for (Laiva l : laivat) {
            if (l.ammuttu){
                lauta[l.x][l.y] = 2;
            }
        }
        for (int i = 0; i < xd; i++) {
            for (int j = 0; j < xd; j++) {
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
