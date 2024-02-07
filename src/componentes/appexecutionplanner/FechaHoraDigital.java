/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
/**
 * Componente que muestra una fecha/hora en un formato determinado.
 * Tiene las propiedades:
 * - docehoras: true para mostrar la fecha en formato am/pm false para formato 24h
 * - mostrarSegundos: True para mostrar los segundos, false para no mostrarlos
 * @author Jose Javier BO
 */
public class FechaHoraDigital extends JLabel implements Serializable{
    //ATRIBUTOS
       private boolean  docehoras;
       private boolean mostrarSegundos;

     /**
      * Constructor
      * @param docehoras true para 12horas false para 24h
      * @param mostrarSegundos true para mostrar los segundos, false para no mostrarlos
      */
    public FechaHoraDigital(boolean docehoras,boolean mostrarSegundos) {
        super();
        this.docehoras=docehoras;
        this.mostrarSegundos=mostrarSegundos;
        this.actualizahora(new Date());
        

    }
    
    //GETTERS Y SETTERS
    public boolean isDocehoras() {
        return docehoras;
    }

    public void setDocehoras(boolean docehoras) {
        this.docehoras = docehoras;
    }

    public boolean isMostrarSegundos() {
        return mostrarSegundos;
    }

    public void setMostrarSegundos(boolean mostrarSegundos) {
        this.mostrarSegundos = mostrarSegundos;
    }


    /**
     * Actualiza la fecha/hora a mostrar
     * @param d  Date con la fecha/hora a mostrar
     */
    public void actualizahora(Date d) {
        String patron="dd/MM/YYYY hh:mm:ss a";
        if (docehoras){
            if (!mostrarSegundos)
            patron ="dd/MM/YYYY hh:mm a";
        }else{
            patron ="dd/MM/YYYY HH:mm:ss";
            if (!mostrarSegundos)
                patron="dd/MM/YYYY HH:mm";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(patron);
        this.setText(sdf.format(d));
    }
       

}
