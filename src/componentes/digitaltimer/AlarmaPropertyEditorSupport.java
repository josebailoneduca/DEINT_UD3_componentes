/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.digitaltimer;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 *
 * @author Bailon
 */
public class AlarmaPropertyEditorSupport extends PropertyEditorSupport {

    private AlarmaPanel ap = new AlarmaPanel();

    @Override
    public Component getCustomEditor() {
        return ap;
    }

    
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public String getJavaInitializationString() {
        Alarma al= ap.getSelectedValue();
        boolean mostrarSegundos=al.isMostrarSegundos();
        boolean doceHoras = al.isDoceHoras();
        String hora = al.getHora();
        boolean alarmaActiva=al.isAlarmaActiva();
        return String.format("new componentes.digitaltimer.Alarma(%s, %s, \"%s\", %s)",doceHoras,mostrarSegundos,hora,alarmaActiva);
    }

    @Override
    public Object getValue() {
        return ap.getSelectedValue();
    }

}
