/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package componentes.appexecutionplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jose Javier BO
 */
public class Mensaje extends JDialog{
    
    public Mensaje(Frame owner,Color color, String titulo, String mensaje) {
        super(owner,true);
        this.setTitle(titulo);
        this.setBackground(color);
        JPanel panel=new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setBackground(color);
        BorderLayout bl = new BorderLayout(0, 10);
        panel.setLayout(bl);
        JLabel label = new JLabel(mensaje);
        label.setOpaque(true);
        panel.add(label,BorderLayout.NORTH);
        JButton boton= new JButton("Aceptar");
        panel.add(boton,BorderLayout.SOUTH);
        boton.addActionListener((e) -> {
            this.dispose();
        });
        this.add(panel);
        this.pack();
    }
    

}
