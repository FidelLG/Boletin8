/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Secundario extends JDialog implements ActionListener, ItemListener {
    JLabel lblColor,lblTitulo;
    JTextField txfTitulo;
    JComboBox<String> cbColores;
    String[] ratonColores = {"Seleccione color", "RatonDcho Rojo", "RatonDcho Azul", "RatonIzdo Naranja", "RatonIzdo Negro"};

    public Secundario(Programa8_1 f) {
        super(f, true);
        setLayout(new FlowLayout());
        setTitle("Ventana secundaria");
        
        //JLabel color
        lblColor=new JLabel("Color: ");
        add(lblColor);
        //JComboBox cbColores
        cbColores = new JComboBox<>(ratonColores);
        cbColores.setMaximumRowCount(5);
        cbColores.setSelectedIndex(0);
        cbColores.addItemListener(this);
        add(cbColores);
        
        //JLabe ltitulo
        lblColor=new JLabel("Titulo: ");
        add(lblColor);

        //JtextField txtTitulo
        txfTitulo = new JTextField(10);
        txfTitulo.addActionListener(this);
        add(txfTitulo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Programa8_1 f = (Programa8_1) this.getOwner();
        f.titulo=txfTitulo.getText();
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        Programa8_1 f = (Programa8_1) this.getOwner();
        switch (cbColores.getSelectedIndex()) {
            case 1:
                f.colorRD = Color.RED;
                break;
            case 2:
                f.colorRD = Color.BLUE;
                break;
            case 3:
                f.colorRI = Color.ORANGE;
                break;
            case 4:
                f.colorRI = Color.BLACK;
                break;
            default:
                break;
        }
    }
}
