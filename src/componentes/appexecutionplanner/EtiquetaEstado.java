/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author Jose Javier BO
 */
public class EtiquetaEstado extends JLabel implements Serializable {

    public static final int NO_CARGADO = 0;
    public static final int CARGADO = 1;
    public static final int EJECUTADO = 2;
    public static final Color COLOR_NO_CARGADO = Color.RED;
    public static final Color COLOR_CARGADO = Color.YELLOW;
    public static final Color COLOR_EJECUTADO = Color.GREEN;

    private int estadoActual = NO_CARGADO;
    private Color colorActual = COLOR_NO_CARGADO;

    public EtiquetaEstado() {
        this.setOpaque(true);
        setEstado(0);
    }

    public void setEstado(int e) {
        estadoActual = 0;
        switch (e) {
            case NO_CARGADO:
                colorActual=COLOR_NO_CARGADO;
                setText("NO CARGADO");
                break;
            case CARGADO:
                colorActual=COLOR_CARGADO;
                setText("CARGADO");
                break;
            case EJECUTADO:
                colorActual=COLOR_EJECUTADO;
                setText("EJECUTADO");
                break;
        }
        
        setBackground(colorActual);
    }
 
    public Color getColorActual(){
        return colorActual;
    } 

}
