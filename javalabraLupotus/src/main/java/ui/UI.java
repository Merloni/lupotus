
package ui;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tuomo
 */

public class UI implements Runnable{
    
    public static JFrame frame;
    public static Container c;
    
    
    
    public static void luoPeli(){
        
        

    } 
    public static void luoValikko(){
        JButton aloitus = new JButton("Aloita Peli");
        JButton highscore = new JButton("Highscore");
        JButton lopetus = new JButton("Lopeta");
        
        aloitus.addActionListener(new AloitaPeliListener());
        lopetus.addActionListener(new LopetaListener());
        JPanel paneeli = new JPanel(); 
        
        paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.Y_AXIS));
        paneeli.add(aloitus);
        paneeli.add(highscore);
        paneeli.add(lopetus);
        frame.add(paneeli);
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        luoValikko();
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
    
}
