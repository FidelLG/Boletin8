/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_2;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author fidi
 */
public class Programa8_2 extends JFrame {

    JButton[] btnMovilPad;
    JButton btnReset;
    JTextField txfPantalla;
    String[] numerosPad = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "0", "*"};
    Font fontTxf= new Font("Sathu",Font.BOLD,30);
    Font fontBtn= new Font("Sathu",Font.BOLD,18);
    public Programa8_2() {
        super("Bol8.-Ejercicio 2");
        this.setLayout(null);

        //Creación de los JButton
        btnMovilPad= new JButton[numerosPad.length];
        int x = 75, y = 120;
        for (int i = 0; i < numerosPad.length; i++) {
            btnMovilPad[i] = new JButton(numerosPad[i]);
            btnMovilPad[i].setSize(50,50);
            btnMovilPad[i].setFont(fontBtn);
            btnMovilPad[i].setLocation(x, y);
            btnMovilPad[i].addMouseListener(new FuncionesRaton());

            x += 75;
            if ((i + 1) % 3 == 0) {
                x = 75;
                y += 60;
            }

            add(btnMovilPad[i]);
        }
        
        //JTextField txfPantalla
        txfPantalla = new JTextField();
        txfPantalla.setSize(200,40);
        txfPantalla.setLocation(75,20);
        txfPantalla.setEditable(false);
        txfPantalla.setFont(fontTxf);
        txfPantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(txfPantalla);
        
        //JButton btnReset
        btnReset = new JButton("Reset");
        btnReset.setSize(90,20);
        btnReset.setLocation(130, 75);
        add(btnReset);
    }
    
    private class FuncionesRaton implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if(me.getSource().getClass()==JButton.class){
                for (int i = 0; i < btnMovilPad.length; i++) {
                 btnMovilPad[i].setBackground(Color.yellow);
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if(me.getSource().getClass()==JButton.class){
                for (int i = 0; i < btnMovilPad.length; i++) {
                 btnMovilPad[i].setBackground(null);
                }
            }
        }
    
    }
}
