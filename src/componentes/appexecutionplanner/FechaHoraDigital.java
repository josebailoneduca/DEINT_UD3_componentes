/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Bailon
 */
public class FechaHoraDigital extends JLabel implements Serializable{
       private boolean  docehoras;
       private boolean mostrarSegundos;

    public FechaHoraDigital(boolean docehoras,boolean mostrarSegundos) {
        super();
        this.docehoras=docehoras;
        this.mostrarSegundos=mostrarSegundos;
        this.actualizahora(new Date());
        

    }
    
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


    public void actualizahora(Date d) {

        String patron="dd/mm/YYYY hh:MM:ss a";
        if (docehoras){
            if (!mostrarSegundos)
            patron ="dd/mm/YYYY hh:MM a";
        }else{
            patron ="dd/mm/YYYY HH:mm:ss";
            if (!mostrarSegundos)
                patron="dd/mm/YYYY HH:mm";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(patron);
        this.setText(sdf.format(d));
    }
       

}
