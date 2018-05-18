/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_1;

import javax.swing.JFrame;

/**
 *
 * @author fidi
 */
public class Boletin8_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Programa8_1 p= new Programa8_1();
//        EventosRaton p = new EventosRaton();
//        EventosTeclado p = new EventosTeclado();
        p.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        p.setVisible(true);
        p.setSize(350, 350);
        
    }
    
}
