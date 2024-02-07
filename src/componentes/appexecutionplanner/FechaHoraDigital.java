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
