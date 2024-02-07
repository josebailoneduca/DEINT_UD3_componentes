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
 * Atributo  FechaPlanificada. Extiende de JCalendar con lo que es capaz de almacenar
 * la fecha. Además tiene atributos hora, minuto, segundo
 * 
 * @author Jose Javier BO
 */
public class FechaPlanificada extends JCalendar implements Serializable{
    
    //ATRIBUTOS
    int hora;
    int minuto;
    int segundo;
    
    
    /**
     * Constructor
     * @param date Parametro de fecha
     * @param hora Hora
     * @param minuto Minuto
     * @param segundo Segundo
     */
    public FechaPlanificada (long date,int hora,int minuto,int segundo){
        super();
        this.setDate(new Date(date));
        this.hora=hora;
        this.minuto=minuto;
        this.segundo=segundo;
    }
 
 
    //GETTERS Y SETTERS
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
    
    /**
     * Devuelve la fecha/hora en formato de texto dd/MM/yyy HH:MM:ss
     * 
     * @return  El texto don la fecha/hora
     */
    public String getTextoHoraFecha(){
    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(this.getDate());
            String horafecha = String.format("%s a las %02d:%02d:%02d",fecha,hora,minuto,segundo);
            return horafecha;
    }
}
