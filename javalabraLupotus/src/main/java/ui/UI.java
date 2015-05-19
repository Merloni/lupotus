
package ui;


import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tuomo
 */

public class UI implements Runnable{
    
    public static JFrame frame;
    
    
    
    
    public void luoPeli(){
        
        

    } 
    public static void luoValikko(JFrame taulu){
        JButton aloitus = new JButton("Aloita Peli");
        JButton lopetus = new JButton("Lopeta");
        JPanel paneeli = new JPanel(); 
        paneeli.add(aloitus);
        paneeli.add(lopetus);
        taulu.add(paneeli);
        
    }

    public static void main(String args[]){
        UI ui = new UI();
        ui.run();
        
    }

    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setSize(800,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        luoValikko(frame);
        
    }
    
    
    
}
