/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin8_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author fidi
 */
public class EventosRaton extends JFrame {

    JLabel lbl, lbl2;

    public EventosRaton() {
        super("Pueba eventos");
        setLayout(new FlowLayout());
        lbl = new JLabel("<html><h1>Probando eventos de ratón</h1></html>");
        lbl.addMouseListener(new MouseHandler());
        lbl.addMouseMotionListener(new MouseHandler());
        add(lbl);
        lbl2 = new JLabel("Datos");
        add(lbl2);
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            lbl2.setText(String.format(
                    "Posición X:%d Y:%d Botón pulsado: %s",
                    e.getX(), e.getY(),
                    SwingUtilities.isLeftMouseButton(e)
                    ? "principal" : "otro"));
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            lbl2.setText(String.format("Posición X:%d Y:%d ", e.getX(),
                    e.getY()));
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (e.getClickCount() > 1) {
                lbl2.setText("Pulsación múltiple");
            } else {
                lbl2.setText(String.format(
                        "<html>Boton Pulsado: %d<br>Teclas: CTRL:%s ALT:%s SHIFT:%s ",
                        e.getButton(),
                        e.isControlDown() ? "Si" : "No",
                        e.isAltDown() ? "Si" : "No",
                        e.isShiftDown() ? "Si" : "No"));
            }
        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            lbl.setForeground(Color.BLUE);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            lbl.setForeground(Color.BLACK);
            lbl2.setText("Fuera de la etiqueta");
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            lbl.setForeground(Color.YELLOW);
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            lbl.setForeground(Color.BLUE);
        }
    }
}

