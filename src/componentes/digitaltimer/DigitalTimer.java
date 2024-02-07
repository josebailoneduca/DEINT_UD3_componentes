/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
Lista de paquetes:
 */
package componentes.digitaltimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Clase principal del componente DigitalTimer.
 * 
 * Tiene una propiedad editable llamada alarma. En esta propiedad se configura
 * si se quiere o no mostrar los segundos, si se usa formato de 12 o 24 horas,
 * a qué hora saltaría la alarma y si está activa o no.
 * 
 * Usa un javax.swing.Timer para controlar el paso del tiempo. A cada paso del tiempo
 * se formatea la hora según el formato definido por la propiedad Alarma y se muestra
 * en una etiqueta. Además a cada paso del tiempo se comprueba si la alarma está
 * activa y si es la hora de lanzarla. En caso de lanzarla ejecuta el método "saltaAlarma"
 * de un SaltoDeAlarmaListener que debe definir el usuario.
 * 
 * 
* @author Jose Javier BO
*/
public class DigitalTimer extends JLabel implements Serializable, ActionListener {
    
    //propiedad configurable
    private Alarma alarma;
    
    //Timer que se encarga de ejecutar la actualizacion 
    private Timer timer;
    
    //Listener de la alarma
    private SaltoDeAlarmaListener saltoDeAlarmaListener;
    
    //guarda si la alarma ya ha saltado para evitar que salte varias veces durante
    //un mismo minuto mientras se está en modo de no mostrar segundos.
    private boolean alarmaYaSaltada=false;
    
    
    
    /**
     * Constructor
     */
    public DigitalTimer() {
       
        //lanzar el timer que se encarga de ejecutar el paso de reloj
       timer=new Timer(1000, this);
       timer.setActionCommand("pasoReloj");
       timer.start();
       //vaciar el texto
       this.setText("DigitalTimer");
       
    }

    
    
    //GETTERS Y SETTERS
    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
    
    /**
     * Accion ejetuada a cada paso del reloj. Actualiza la hora visible en pantalla
     * y comprueba si hay que lanzar la alarma comparando la hora actual con la hora 
     * de alarma y su estado activo.
     */
    private void pasoReloj(){
        
        //recoger la hora actual
        Date ahora = new Date();
        String ahoraFormateado ="";
        //si hay parametros configurados los usa
        if (alarma!=null){
            ahoraFormateado=Alarma.getHoraFormateada(ahora, alarma.isDoceHoras(), alarma.isMostrarSegundos());
            
        //si no hay parametros configurados usa unos por defecto de 12 horas y mostrar los segundos.
        }else{
            ahoraFormateado=Alarma.getHoraFormateada(ahora, false, true);
        }
        
        //Actualizar la hora en pantalla
        this.setText(ahoraFormateado);
        
        //Comprobar si hay que hacer saltar la alarma
        //Si aun no esta saltada, hay listener del salto de alarma y hay parametros de alarma
        if (!alarmaYaSaltada &&saltoDeAlarmaListener!=null && alarma!=null){
            //si la alarma esta activa
            if (alarma.isAlarmaActiva()){
                //coger hora de alarma
                String horaAlarma=alarma.getHora();
                System.out.println("Alarma activada:" + alarma.isAlarmaActiva()+" Hora de la alarma:"+ horaAlarma+"    Hora actual:"+ahoraFormateado);
                //si es la hora marcar que ya ha saltado y ejecutar
                //el listener de alarma
                if (ahoraFormateado.equals(horaAlarma)){
                    alarmaYaSaltada=true;
                    saltoDeAlarmaListener.saltaAlarma();
                //si no coincide la alarma con la hora reseteamos el estado de ya saltada
                }else{
                    alarmaYaSaltada=false;
                }
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if (ac.equals("pasoReloj"))
            pasoReloj();
    }

 
    /**
     * Asignar listner de alarma
     * @param alarmaListener 
     */
    public void addSaltoDeAlarmaListener(SaltoDeAlarmaListener alarmaListener) {
        this.saltoDeAlarmaListener = alarmaListener;
    }
    
 
    /**
     * Quitar listener de alarma
     */
     public void removeSaltoDeAlarmaListener(){
        this.saltoDeAlarmaListener = null;
    }
    
}
