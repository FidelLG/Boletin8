/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_2;

import javax.swing.*;

/**
 *
 * @author fidi
 */
public class Programa8_2 extends JFrame {

    JButton[] btnMovilPad;
    JTextField txfPantalla;

    String[] numerosPad = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "0", "*"};

    public Programa8_2() {
        super("Bol8.-Ejercicio 2");
        this.setLayout(null);

        //Creación de los JButton
        btnMovilPad= new JButton[numerosPad.length];
        int x = 80, y = 100;
        for (int i = 0; i < numerosPad.length; i++) {
            btnMovilPad[i] = new JButton(numerosPad[i]);
            btnMovilPad[i].setSize(btnMovilPad[i].getPreferredSize());
            btnMovilPad[i].setLocation(x, y);

            x += 80;
            if ((i + 1) % 3 == 0) {
                x = 80;
                y += 40;
            }

            add(btnMovilPad[i]);
        }

    }
}
