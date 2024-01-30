package componentes.limitedjtextfield;
/*
 * LICENCIA JOSE JAVIER BO
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Lista de paquetes:
 */

import java.awt.Color;
import java.io.Serializable;

/**
 * Clase del atributo "Colores"
 * Almacena dos colores, uno para el fondo y otro para el texto
 * @author Jose Javier BO
 */
public class Colores implements Serializable {
    //color usado para el fondo
    private Color colorFondo;
    
    //color usado para el texto
    private Color colorTexto;

    /**
     * Constructor
     * @param colorFondo Color para el fondo
     * @param colorTexto Color para el texto
     */
    public Colores(Color colorFondo, Color colorTexto) {
        this.colorFondo = colorFondo;
        this.colorTexto = colorTexto;
    }

    
    //GETTERS Y SETTERS
    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }
    
    
}
