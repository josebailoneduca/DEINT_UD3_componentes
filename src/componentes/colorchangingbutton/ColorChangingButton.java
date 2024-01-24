/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
Lista de paquetes:
 */
package componentes.colorchangingbutton;

import java.awt.Color;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Jose Javier BO
 */
public class ColorChangingButton extends JButton implements Serializable {
    
    private Color colorPorDefecto;
    private boolean alternarColores = false;
    private Color colorSecundario;
    private boolean colorActualEsElInicial = true;
    
    public ColorChangingButton() {
        this.addActionListener((e) -> {
            alternarColor();
        });
    }
    
    public Color getColorPorDefecto() {
        return colorPorDefecto;
    }
    
    public void setColorPorDefecto(Color colorPorDefecto) {
        this.colorPorDefecto = colorPorDefecto;
        actualizaColor();
    }
    
    public boolean isAlternarColores() {
        return alternarColores;
    }
    
    public void setAlternarColores(boolean alternarColores) {
        this.alternarColores = alternarColores;
        actualizaColor();
        
    }
    
    public Color getColorSecundario() {
        return colorSecundario;
    }
    
    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
        actualizaColor();
    }
    
    private void alternarColor() {
        if (!alternarColores) {
            return;
        }
        colorActualEsElInicial = !colorActualEsElInicial;
        actualizaColor();
    }
    
    private void actualizaColor() {
        if (!alternarColores) {
            this.setBackground(colorPorDefecto);
        } else if (colorActualEsElInicial) {
            if (colorPorDefecto != null) {
                this.setBackground(colorPorDefecto);
            } else {
                this.setBackground(Color.RED);
            }
        } else if (colorSecundario != null) {
            this.setBackground(colorSecundario);
        } else {
            this.setBackground(Color.PINK);
        }
    }
    
}
