
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
 * Tämä luokka hoitaa valikon ja pelitilanteen piirtämisen, sekä pelitilanteen 
 * graafisen ulkoasun päivittämisen.
 * 
 * 
 * @author Tuomo
 */

public class UI implements Runnable{
    
    private JFrame frame;
    private Container c;
    private static final float nappiKoko = 24f;
    private static final int vali = 3;
    
    
    
    public void luoPeli(){
        System.out.println("asd");
        c.setLayout(new BorderLayout());
        
        c.removeAll();
        c.repaint();
        
        
        c.validate();
        frame.pack();
        
     
        

    } 
    public void paivitaPeli(){
        
    }
    public JPanel luoValikko(){
        JButton aloitus = new JButton("Aloita Peli");
        JButton highscore = new JButton("Highscore");
        JButton lopetus = new JButton("Lopeta");
        
        aloitus.addActionListener(new AloitaPeliListener(this));
        lopetus.addActionListener(new LopetaListener());
        JPanel paneeli = new JPanel(); 
        
        paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.Y_AXIS));
        paneeli.add(aloitus);
        paneeli.add(highscore);
        paneeli.add(lopetus);
        return paneeli;
        
    }
    
    
    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(800,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        c = frame.getContentPane();
        
        c.setLayout(new FlowLayout());
        
        c.add(luoValikko());
        
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
    
}
