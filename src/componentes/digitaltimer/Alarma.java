/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
Lista de paquetes:
 */
package componentes.digitaltimer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase del atributo Alarma. Contiene si el formato son 12 o 24 horas, si hay
 * que mostrar los segundos, la hora a la que saltaría la alarma y si está activa
 * o no.
 * 
 * 
 * @author Jose J. Bailon
 */
public class Alarma implements Serializable {

    /**
     * True: formato 12 horas AM/PM. False; Formato 24 horas
     */
    private boolean doceHoras;
    
    /**
     * True: Mostrar segundos. False: No mostrarlos.
     */
    private boolean mostrarSegundos;
    
    /**
     * Hora a la que hacer saltar la alarma
     */
    private String hora;
    
    /**
     * True: la alarma está activa. False: La alarma no está activa
     */
    private boolean alarmaActiva;

    /**
     * Datos de alarma 
     * 
     * @param doceHoras True: formato 12 horas AM/PM. False; Formato 24 horas
     * @param mostrarSegundos Mostrar segundos. False: No mostrarlos.
     * @param hora Hora a la que hacer saltar la alarma
     * @param alarmaActiva  True: la alarma está activa. False: La alarma no está activa
     */
    public Alarma(boolean doceHoras, boolean mostrarSegundos, String hora, boolean alarmaActiva) {
        this.doceHoras = doceHoras;
        this.mostrarSegundos = mostrarSegundos;
        this.hora = hora;
        this.alarmaActiva = alarmaActiva;
    }

    //GETTERS Y SETTERS
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

    
    /**
     * Genera un string formateado según los parametros
     * @param horaParaFormatear Hora a la que aplicar el formato
     * @param doceHoras True si se quiere formato 12 horas AM/FM. False si se quiere formato 24h
     * @param mostrarSegundos True muestra segundos. False no los muestra
     * 
     * @return  Un String con la hora:minutos[:segundos] según los parametros elegidos.
     */
    public static String getHoraFormateada(Date horaParaFormatear, boolean doceHoras, boolean mostrarSegundos) {

        Calendar calendario = GregorianCalendar.getInstance();
        calendario.setTime(horaParaFormatear);
        int hora = (doceHoras) ? calendario.get(Calendar.HOUR) : calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        String minutosFormateados=((minutos<10)?"0":"")+ minutos ;
        String segundosFormateados=(mostrarSegundos) ? (":"+((segundos<10)?"0":"") + segundos) : "";
        String horaFormateada = "" + hora + ":" +minutosFormateados+ segundosFormateados;
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
