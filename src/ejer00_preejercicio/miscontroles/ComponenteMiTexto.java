/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
Lista de paquetes:
 */
package ejer00_preejercicio.miscontroles;

import java.awt.Color;
import java.awt.Font;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author Jose Javier BO
 */
public class ComponenteMiTexto extends JTextField implements Serializable {

    private int ancho;
    private Color color;
    private Font fuente;

    
        
    public ComponenteMiTexto() {
    }
    
    
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.setColumns(ancho);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setForeground(color);
    }

    public Font getFuente() {
        return fuente;
    }

    public void setFuente(Font fuente) {
        this.fuente = fuente;
        this.setFont(fuente);
    }

    
    
}
