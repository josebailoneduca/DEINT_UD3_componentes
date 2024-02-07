/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 * Property editor support de la propiedad FechaPlanificacion.
 * 
 * @author Jose Javier BO
 */
public class FechaPlanificadaPropertyEditorSupport extends PropertyEditorSupport {
    
    //panel editor
    FechaPlanificadaPanel fpp = new FechaPlanificadaPanel();
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return fpp;
    }

    @Override
    public String getJavaInitializationString() {
        FechaPlanificada fplanif=fpp.getSelectedValue();
        return String.format("new componentes.appexecutionplanner.FechaPlanificada(new java.util.Date().getTime(),"+fplanif.getHora()+","+fplanif.getMinuto()+","+fplanif.getSegundo())+")";
    }

    @Override
    public Object getValue() {
        return fpp.getSelectedValue();
    }
    
    
    
}
