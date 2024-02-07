/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import com.toedter.calendar.JCalendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bailon
 */
public class FechaPlanificada extends JCalendar implements Serializable{
    int hora;
    int minuto;
    int segundo;
    
    public FechaPlanificada (long date,int hora,int minuto,int segundo){
        super();
        this.setDate(new Date(date));
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
 
    
//    public boolean esLaFecha(Date d){
//      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
//      return fecha.equals(sdf.format(d));
//    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
}
