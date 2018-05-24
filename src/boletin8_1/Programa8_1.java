/*

 */
package boletin8_1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author fidi
 */
public class Programa8_1 extends JFrame implements KeyListener {

    JButton btnRatonIzquierdo;
    JButton btnRatonDerecho;
    JLabel lblTeclas;
    Color colorRD = Color.GREEN;
    Color colorRI = Color.YELLOW;

    String titulo = "Control de Ratón";

    public Programa8_1() {
        super();
        this.setLayout(null);
        setFocusable(true);
        setTitle(titulo);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿Deseas salir del programa?",
                        "Eventos Teclado/Raton",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (respuesta == JOptionPane.OK_OPTION) {
                    we.getWindow().dispose();
                }
            }
        });

//JButton btnRatonIzquierdo
        btnRatonIzquierdo = new JButton();
        btnRatonIzquierdo.setSize(60, 60);
        btnRatonIzquierdo.setLocation(80, 25);
        btnRatonIzquierdo.setBackground(Color.gray);
        btnRatonIzquierdo.addMouseMotionListener(new FuncionesRaton());
        add(btnRatonIzquierdo);

        //JButton btnRatonDerecho
        btnRatonDerecho = new JButton();
        btnRatonDerecho.setSize(60, 60);
        btnRatonDerecho.setLocation(200, 25);
        btnRatonDerecho.setBackground(Color.GRAY);
        btnRatonDerecho.addMouseMotionListener(new FuncionesRaton());
        add(btnRatonDerecho);

        //JLabel lblTeclas
        lblTeclas = new JLabel("Tecla:   Codigo:");
        lblTeclas.setSize(250, 20);
        lblTeclas.setLocation(25, 120);
        add(lblTeclas);

        this.getContentPane().addMouseMotionListener(new FuncionesRaton());
        this.getContentPane().addMouseListener(new FuncionesRaton());
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
//        lblTeclas.setText(String.format("Tecla:%c  Codigo:%d",ke.getKeyChar(),ke.getKeyCode()));
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.isControlDown() && ke.isShiftDown()) {
            Secundario f = new Secundario(this);
            f.pack(); // Tamaño necesario para ver todos los componentes
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setVisible(true);
        }
        System.err.println(ke.getKeyCode());
        lblTeclas.setText(String.format("Tecla: %c Codigo: %d", ke.getKeyChar(), ke.getKeyCode()));

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    private class FuncionesRaton implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent me) {

        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (me.getButton() == MouseEvent.BUTTON1) {
                btnRatonIzquierdo.setBackground(colorRI);
            } else if (me.getButton() == MouseEvent.BUTTON3) {
                btnRatonDerecho.setBackground(colorRD);
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (me.getButton() == MouseEvent.BUTTON1) {
                btnRatonIzquierdo.setBackground(Color.GRAY);
            } else if (me.getButton() == MouseEvent.BUTTON3) {
                btnRatonDerecho.setBackground(Color.GRAY);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
            setTitle(titulo);
        }

        @Override
        public void mouseDragged(MouseEvent me) {
//            Graphics g = getGraphics();
//            g.setColor(Color.BLUE);
//            g.fillOval(me.getX(), me.getY(), 10, 10);
        }

        @Override
        public void mouseMoved(MouseEvent me) {
//            int ix = btnRatonIzquierdo.getX();
//            int iy = btnRatonIzquierdo.getY();
//            int dx = btnRatonDerecho.getX();
//            int dy = btnRatonDerecho.getY();
            int fx = 0;
            int fy = 0;
            if (me.getSource().getClass() == JButton.class) {

                fx = ((JButton) me.getSource()).getX();/// me.getComponent().getX();
                fy = ((JButton) me.getSource()).getY();

            }
            
            setTitle(titulo + "- (X:" + (me.getX() + fx) + ",Y:" + (me.getY() + fy) + ")");

//            if (me.getSource() == btnRatonIzquierdo) {
//                System.err.println(me.getX() + ix);
//                setTitle(titulo + "- (X:" + (me.getX() + ix) + ",Y:" + (me.getY() + iy) + ")");
//            } else if (me.getSource() == btnRatonDerecho) {
//                setTitle(titulo + "- (X:" + (me.getX() + dx) + ",Y:" + (me.getY() + dy) + ")");
//
//            } else {
//                setTitle(titulo + "- (X:" + me.getX() + ",Y:" + me.getY() + ")");
//            }
        }

    }
}
