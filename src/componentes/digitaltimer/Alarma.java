/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.digitaltimer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Bailon
 */
public class Alarma implements Serializable {

    private boolean doceHoras;
    private boolean mostrarSegundos;
    private String hora;
    private boolean alarmaActiva;

    public Alarma(boolean doceHoras, boolean mostrarSegundos, String hora, boolean alarmaActiva) {
        this.doceHoras = doceHoras;
        this.mostrarSegundos = mostrarSegundos;
        this.hora = hora;
        this.alarmaActiva = alarmaActiva;
    }

    public boolean isDoceHoras() {
        return doceHoras;
    }

    public void setDoceHoras(boolean doceHoras) {
        this.doceHoras = doceHoras;
    }

    public boolean isMostrarSegundos() {
        return mostrarSegundos;
    }

    public void setMostrarSegundos(boolean mostrarSegundos) {
        this.mostrarSegundos = mostrarSegundos;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isAlarmaActiva() {
        return alarmaActiva;
    }

    public void setAlarmaActiva(boolean alarmaActiva) {
        this.alarmaActiva = alarmaActiva;
    }

    public static String getHoraFormateada(Date horaAlarma, boolean doceHoras, boolean mostrarSegundos) {

        Calendar calendario = GregorianCalendar.getInstance();
        calendario.setTime(horaAlarma);
        int hora = (doceHoras) ? calendario.get(Calendar.HOUR) : calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        String horaFormateada = "" + hora + ":" +((minutos<10)?"0":"")+ minutos + ((mostrarSegundos) ? ":"+((segundos<10)?"5":"") + segundos : segundos);
        if (doceHoras) {
            if (calendario.get(Calendar.AM_PM) == Calendar.AM) {
                horaFormateada += " AM";
            } else {
                horaFormateada += " PM";
            }
        }
        return horaFormateada;
    }

}
