/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_2;

import java.awt.event.*;
import javax.swing.*;

class JRadioButtonEntero extends JRadioButton {

    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        this.setText(numero + "");
    }
}

public class RadioButtons extends JFrame implements ActionListener {

    private JRadioButton[] rbProgramadores;
    private JRadioButtonEntero[] rbNivel;
    private ButtonGroup grpProgramadores, grpNiveles;
    private String[] programadores = {"Ada Lovelace", "Denis Ritchie", "Grace Hopper",
        "Tim Berners Lee", "Margaret Hamilton", "Sheldon Cooper"};
    private JButton aceptar;
    private String programadorSeleccionado = "";
    private int nivelSeleccionado = 0;

    public RadioButtons() {
        super("Ejemplo Radiobuttons dinámicos");
        setLayout(null);
        // Creación de radiobuttons de programadores
        rbProgramadores = new JRadioButton[programadores.length];
        grpProgramadores = new ButtonGroup();
        int x = 10, y = 10;
        for (int i = 0; i < rbProgramadores.length; i++) {
            rbProgramadores[i] = new JRadioButton(programadores[i]);
            rbProgramadores[i].setSize(rbProgramadores[i].getPreferredSize());
            rbProgramadores[i].setLocation(x, y);
            x += 180;
            if ((i + 1) % 3 == 0) {
                x = 10;
                y += 30;
            }
            rbProgramadores[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    programadorSeleccionado = ((JRadioButton) ie.getSource()).getText();
                }
            });
            add(rbProgramadores[i]);

            grpProgramadores.add(rbProgramadores[i]);
        }
        // Creación de radiobuttons de nivel
        rbNivel = new JRadioButtonEntero[11];
        grpNiveles = new ButtonGroup();
        x = 10;
        y = 100;
        for (int i = 0; i < rbNivel.length; i++) {
            rbNivel[i] = new JRadioButtonEntero();
            rbNivel[i].setNumero(i);
            rbNivel[i].setSize(rbNivel[i].getPreferredSize());
            rbNivel[i].setLocation(x, y);
            x += 30;
            rbNivel[i].addItemListener(new GestionaNivel());
            add(rbNivel[i]);
            grpNiveles.add(rbNivel[i]);
        }
        // Botón Aceptar para mostrar información seleccionada
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(10, 200, 80, 30);
        aceptar.addActionListener(this);
        add(aceptar);
        rbNivel[0].setSelected(true);
        rbProgramadores[0].setSelected(true);
    }
    // Clase interna para gestión de Nivel

    class GestionaNivel implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            RadioButtons.this.nivelSeleccionado = ((JRadioButtonEntero) ie.getSource()).getNumero();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, String.format("%s %d", programadorSeleccionado,
                nivelSeleccionado),
                "Programadores", JOptionPane.INFORMATION_MESSAGE);
    }
}
