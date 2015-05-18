/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import javax.swing.JFrame;

/**
 *
 * @author Tuomo
 */
public class UI{
    
    
    public static void main(String args[]){
        UI ui = new UI();
        ui.luoTaulu();
        
    }
    
    public void luoTaulu(){
        JFrame frame = new JFrame("Laivanupotus");
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void piirraTaulu(){
        
    }
    
    
    
}
