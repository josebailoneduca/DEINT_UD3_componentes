/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.limitedjtextfield;
/*
 * LICENCIA JOSE JAVIER BO
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Lista de paquetes:
 */

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/** 
 * Configura el soporte de editor personalizado para un atributo, en este caso el atributo Colores
 * @author Jose Javier BO
 */
public class ColoresPropertyEditorSupport extends PropertyEditorSupport{
    
    //instancia del panel del editor
    private ColoresPanel cp = new ColoresPanel();

    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return cp;
    }

    @Override
    public String getJavaInitializationString() {
        Colores colores= cp.getSelectedValue();
        //valores del color de fondo
        int fR=colores.getColorFondo().getRed();
        int fG=colores.getColorFondo().getGreen();
        int fB=colores.getColorFondo().getBlue();
        int fA=colores.getColorFondo().getAlpha();
        
        //valores del color del texto
        int tR=colores.getColorTexto().getRed();
        int tG=colores.getColorTexto().getGreen();
        int tB=colores.getColorTexto().getBlue();
        int tA=colores.getColorFondo().getAlpha();
        
        //retornar cadena de texto que construirá el componente
        return String.format("new componentes.limitedjtextfield.Colores(new java.awt.Color(%d,%d,%d,%d),new java.awt.Color(%d,%d,%d,%d))",fR,fG,fB,fA,tR,tG,tB,tA);
                
    }

    
    @Override
    public Object getValue() {
        //devolver el valor de la propiedad
        return cp.getSelectedValue();
    }


    
    
    
}
