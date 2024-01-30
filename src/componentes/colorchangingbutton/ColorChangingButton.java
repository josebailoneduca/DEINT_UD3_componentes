/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
Lista de paquetes:
 */
package componentes.colorchangingbutton;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JButton;

/**
 * Botón que cambia de color a cada click. Tiene un atributo "alternarColores" que
 * activa y desactiva esta caracteristica de cambo de colores.
 * 
 * Los colores entre los que se alterna se definen en los atributos:
 * colorPorDefecto 
 * colorSecundario
 * 
 *
 *
 * @author Jose Javier BO
 */
public class ColorChangingButton extends JButton implements Serializable {

    /**
     * Color que se usa por defecto
     */
    private Color colorPorDefecto;

    /**
     * Color secundario mostrado cuando se alterna
     */
    private Color colorSecundario;

    /**
     * Define si se alternan colores o no
     */
    private boolean alternarColores = false;

    /**
     * Define si el color Actual a usar es el inicial
     */
    private boolean colorActualEsElInicial = true;

    /**
     * Constructor. Agrega al botón un action listener con un lambda que llama a
     * la funcion alternar color
     */
    public ColorChangingButton() {
        this.addActionListener((e) -> {
            alternarColor();
        });
    }

    //GETTERS Y SETTERS
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

    /**
     * Si se deben alternar colores alterna entre que actualmente se debe usar
     * el color inicial o no
     */
    private void alternarColor() {
        if (alternarColores) {
            colorActualEsElInicial = !colorActualEsElInicial;
            actualizaColor();
        }
    }

    /**
     * Actualiza el color de fondo del botón según cual sea el color a usar
     */
    private void actualizaColor() {

        //si no está activo alternarColores se pone el color por defecto.
        if (!alternarColores) {
            this.setBackground(colorPorDefecto);

            //si el color a usar es el inicial
        } else if (colorActualEsElInicial) {
            //si hay definido colorPor defecto se pone de fondo. Si no entonces blanco.
            if (colorPorDefecto != null) {
                this.setBackground(colorPorDefecto);
            } else {
                this.setBackground(Color.WHITE);
            }
            //si hay definido color Secundario se pone de fondo. Si no entonces blanco.
        } else if (colorSecundario != null) {
            this.setBackground(colorSecundario);
        } else {
            this.setBackground(Color.WHITE);
        }
    }

}
