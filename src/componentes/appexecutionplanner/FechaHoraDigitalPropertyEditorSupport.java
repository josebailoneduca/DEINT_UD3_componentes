/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 * Property editor support de atributo FechaHoraDigital
 * @author Jose Javier BO
 */
public class FechaHoraDigitalPropertyEditorSupport extends PropertyEditorSupport {
        FechaHoraDigitalPanel panel = new FechaHoraDigitalPanel();

    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return panel;
    }

    @Override
    public String getJavaInitializationString() {
        FechaHoraDigital r = panel.getSelectedValue();
        return String.format("new componentes.appexecutionplanner.FechaHoraDigital(%b,%b)", r.isDocehoras(),r.isMostrarSegundos());
    }

    @Override
    public Object getValue() {
        return panel.getSelectedValue();
    }

        
}
