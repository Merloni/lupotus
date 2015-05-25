
package PeliLogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuosalme
 */
public class Pelilauta {
    private static int[][] lauta;
    private static List<Laiva> laivat;
    private static int koko;
    private static List<Ruutu> ruudut = new ArrayList();
    
    
    public Pelilauta(int koko){
        this.lauta = new int[koko][koko];
        this.laivat = new ArrayList();
        this.koko = koko;
        
        
    }
    public void luoLaivat(){
        Laiva[] laivat = {new Laiva(1,1), new Laiva(2,2),new Laiva(3,3)};
        for (Laiva l : laivat) {
            this.laivat.add(l);
            
        }
    }
    public int[][] getLauta(){
        return this.lauta;
    }
    public int getKoko(){
        return this.koko;
    }
    public List getLaivat(){
        return this.laivat;
    }
    public List getRuudut(){
        return this.ruudut;
    }
    public void alustaRuudut(){
        for (int i = 0; i < this.koko; i++) {
            for (int j = 0; j < this.koko; j++) {
                Ruutu r = new Ruutu(i,j);
                this.ruudut.add(r);
            }        
        }
    }
    public void piirraValiaikainenLauta(){
        for (int i = 0; i < this.koko; i++) {
            for (int j = 0; j < this.koko; j++) {
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
            if(l.getX() == x && l.getY() == y){
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
