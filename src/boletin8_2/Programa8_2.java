/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_2;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author fidi
 */
public class Programa8_2 extends JFrame implements ActionListener {

    JButton[] btnMovilPad;
    JButton btnReset;
    JMenuBar mnuPrincipal;
    JMenu mnuArchivo, mnuMovil, mnuOtros;
    JMenuItem mnuGrabar, mnuLeer, mnuReset, mnuSalir, mnuAcerca;
    JTextField txfPantalla;
    String[] numerosPad = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "#", "0", "*"};
    Font fontTxf = new Font("Sathu", Font.BOLD, 30);
    Font fontBtn = new Font("Sathu", Font.BOLD, 18);
    String home = System.getProperty("user.home");

    public Programa8_2() {
        super("Bol8.-Ejercicio 2");
        this.setLayout(null);
        
        //Creación de los JButton
        btnMovilPad = new JButton[numerosPad.length];
        int x = 75, y = 120;
        for (int i = 0; i < numerosPad.length; i++) {
            btnMovilPad[i] = new JButton(numerosPad[i]);
            btnMovilPad[i].setSize(50, 50);
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
        txfPantalla = new JTextField("");
        txfPantalla.setSize(200, 40);
        txfPantalla.setLocation(75, 20);
        txfPantalla.setEditable(false);
        txfPantalla.setFont(fontTxf);
     //   txfPantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
     
        add(txfPantalla);

        //JButton btnReset
        btnReset = new JButton("Reset");
        btnReset.setSize(90, 20);
        btnReset.setLocation(130, 75);
        btnReset.addActionListener(this);
        add(btnReset);

        //Menu Archivo
        mnuGrabar = new JMenuItem("Grabar");
        mnuGrabar.setMnemonic('G');
        mnuGrabar.addActionListener(this);

        mnuLeer = new JMenuItem("Leer");
        mnuLeer.setMnemonic('L');
        mnuLeer.addActionListener(this);

        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setMnemonic('A');
        mnuArchivo.add(mnuGrabar);
        mnuArchivo.add(mnuLeer);

        //Menu Movil
        mnuReset = new JMenuItem("Reset");
        mnuReset.setMnemonic('R');
        mnuReset.addActionListener(this);

        mnuSalir = new JMenuItem("Salir");
        mnuSalir.setMnemonic('S');
        mnuSalir.addActionListener(this);

        mnuMovil = new JMenu("Móvil");
        mnuMovil.setMnemonic('M');
        mnuMovil.add(mnuReset);
        mnuMovil.addSeparator();
        mnuMovil.add(mnuSalir);

        //Menu Otros
        mnuAcerca = new JMenuItem("Acerca");
        mnuAcerca.setMnemonic('A');
        mnuAcerca.addActionListener(this);

        mnuOtros = new JMenu("Otros");
        mnuOtros.setMnemonic('O');
        mnuOtros.add(mnuAcerca);

        //Menu Principal
        mnuPrincipal = new JMenuBar();
        mnuPrincipal.add(mnuArchivo);
        mnuPrincipal.add(mnuMovil);
        mnuPrincipal.add(mnuOtros);
        this.setJMenuBar(mnuPrincipal);
        
       this.getContentPane().addKeyListener(new EventosRaton());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int respuesta;
        String texto;

        if (ae.getSource() == btnReset || ae.getSource() == mnuReset) {
            for (int i = 0; i < btnMovilPad.length; i++) {
                btnMovilPad[i].setBackground(null);
                txfPantalla.setText("");
            }
        }

        if (ae.getSource() == mnuSalir) {

            if (!txfPantalla.getText().equals("")) {
                respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Guardar antes de salir",
                        "Salir del programa",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                switch (respuesta) {
                    case JOptionPane.YES_OPTION:

                        guardarNumero();
                        System.exit(0);
                        
                        break;
                    default:
                        System.exit(0);
                }
            } else {
                System.exit(0);
            }
        }

        if (ae.getSource() == mnuAcerca) {
            JOptionPane.showMessageDialog(
                    null,
                    "Agenda rudimentaria con la que podras gestionar tus numeros telefonicos\nAutor: FidelLG ",
                    "Info",
                    JOptionPane.PLAIN_MESSAGE);
        }

        if (ae.getSource() == mnuGrabar) {

            guardarNumero();
        }

        if (ae.getSource() == mnuLeer) {

            try (Scanner sc = new Scanner(new File(home+"/agenda.txt"))){
                while(sc.hasNext()){
                texto=sc.nextLine();
                JOptionPane.showConfirmDialog(null,
                        texto,
                        "Agenda de numeros",
                        JOptionPane.CLOSED_OPTION,
                        JOptionPane.PLAIN_MESSAGE);
                }
            } catch (Exception e) {
                System.err.println("Error de acceso al archivo");
            }
        }
        
       

    }

    private void guardarNumero() {
        try (PrintWriter f = new PrintWriter(new FileWriter(home + "/agenda.txt", true))) {
            f.println(txfPantalla.getText());
        } catch (Exception e) {
            System.err.println("Error de acceso al archivo");
        }
    }

    private class FuncionesRaton implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource().getClass() == JButton.class) {
                ((JButton) me.getSource()).setBackground(Color.ORANGE);
            }

           
            
            if(me.getSource().getClass() == JButton.class){
                txfPantalla.setText(txfPantalla.getText()+((JButton) me.getSource()).getActionCommand());
                
            }

        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if (me.getSource().getClass() == JButton.class) {
                if (((JButton) me.getSource()).getBackground() != Color.ORANGE) {
                    ((JButton) me.getSource()).setBackground(Color.YELLOW);
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {

            if (me.getSource().getClass() == JButton.class) {
                if (((JButton) me.getSource()).getBackground() == Color.YELLOW) {
                    ((JButton) me.getSource()).setBackground(null);
                }
            }
        }

    }
    
    private class EventosRaton extends KeyAdapter{
    
        @Override
        
        public void keyTyped( KeyEvent e){
        
        if(e.getKeyCode()== KeyEvent.VK_1){
            System.err.println("asd");
            txfPantalla.setText(txfPantalla.getText()+e.getKeyChar());
        }
        }
    
    }
}
