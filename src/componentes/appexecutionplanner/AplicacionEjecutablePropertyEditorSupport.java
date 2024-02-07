/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package componentes.appexecutionplanner;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Jose Javier BO
 */
public class AplicacionEjecutablePropertyEditorSupport  extends PropertyEditorSupport{
    AplicacionEjecutablelPanel panel = new AplicacionEjecutablelPanel();

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
        AplicacionEjecutable r = panel.getSelectedValue();
        String rutaEscapada=escape(r.getAbsolutePath());
        return String.format("new componentes.appexecutionplanner.AplicacionEjecutabla(\"%s\")", rutaEscapada);
    }

    public static String escape(String s){
  return s.replace("\\", "\\\\")
          .replace("\t", "\\t")
          .replace("\b", "\\b")
          .replace("\n", "\\n")
          .replace("\r", "\\r")
          .replace("\f", "\\f")
          .replace("\'", "\\'")     
          .replace("\"", "\\\"");
}
    @Override
    public Object getValue() {
        return panel.getSelectedValue();
    }
}
