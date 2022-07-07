package Ejercicio3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Ventanas extends JFrame {
    private JPanel panel;
    private JLabel etiqueta;
    private JToggleButton botonRojo, botonVerde, botonAzul;

    int conRojo = 0, contVerde = 0, contAzul = 0;

    private int pulsado = 0;
    public Ventanas() {
        setSize(600,400);
        setTitle("Ejercicio 3");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiqueta();
        colocarBoton();
        eventoRaton();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

    }

    private void colocarEtiqueta() {
        etiqueta = new JLabel("Color (Rojo, Verde, Azul)");
        etiqueta.setBounds(100,30,400,50);
        etiqueta.setFont(new Font("arial",0,20));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);

    }

    private void colocarBoton() {
        botonRojo = new JToggleButton();
        botonRojo.setBounds(150,300,100,50);
        botonRojo.setForeground(Color.RED);
        botonRojo.setFont(new Font("arial rounded mt bold",0,20));
        botonRojo.setText("Rojo");
        panel.add(botonRojo);

        botonRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 1;
            }
        });

        botonVerde = new JToggleButton();
        botonVerde.setBounds(250,300,100,50);
        botonVerde.setForeground(Color.GREEN);
        botonVerde.setFont(new Font("arial rounded mt bold",0,20));
        botonVerde.setText("Verde");
        panel.add(botonVerde);

        botonVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 2;
            }
        });

        botonAzul = new JToggleButton();
        botonAzul.setBounds(350,300,100,50);
        botonAzul.setForeground(Color.BLUE);
        botonAzul.setFont(new Font("arial rounded mt bold",0,20));
        botonAzul.setText("Azul");
        panel.add(botonAzul);

        botonAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 3;
            }
        });
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(botonRojo);
        grupo.add(botonVerde);
        grupo.add(botonAzul);
    }

    private void eventoRaton() {
        MouseWheelListener eventoMouse = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {

                if(pulsado != 0) {
                    if(pulsado == 1) {
                        conRojo += e.getWheelRotation();
                        if(conRojo < 0) conRojo = 0;
                        if(conRojo > 255) conRojo = 255;

                    }
                    else if(pulsado == 2) {
                        contVerde += e.getWheelRotation();
                        if(contVerde < 0) contVerde = 0;
                        if(contVerde > 255) contVerde = 255;
                    }
                    else {
                        contAzul += e.getWheelRotation();
                        if(contAzul < 0) contAzul = 0;
                        if(contAzul > 255) contAzul = 255;
                    }
                }
                etiqueta.setText("Color ( Rojo = " + conRojo + " Verde = " + contVerde + " Azul = " + contAzul);
                panel.setBackground(new Color(conRojo, contVerde, contAzul));
            }

        };

        panel.addMouseWheelListener(eventoMouse);
    }

}
