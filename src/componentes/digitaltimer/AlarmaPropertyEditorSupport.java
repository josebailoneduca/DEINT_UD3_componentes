/*
 LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
Lista de paquetes:
 */
package componentes.digitaltimer;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 * PropertyEditorSupport para la propiedad Alarma del componente DigitalTimer
* @author Jose Javier BO
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

    /**
     * Construir la string de creación 
     * @return 
     */
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
