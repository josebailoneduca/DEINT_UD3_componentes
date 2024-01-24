/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.digitaltimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Bailon
 */
public class DigitalTimer extends JLabel implements Serializable, ActionListener {
    private Alarma alarma;
    private Timer timer;
    private SaltoDeAlarmaListener saltoDeAlarmaListener;
    private boolean alarmaYaSaltada=false;
    public DigitalTimer() {
        pasoReloj();
       timer=new Timer(1000, this);
       timer.setActionCommand("pasoReloj");
       timer.start();
       this.setText("");
       
    }

    
    
    
    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
    
    private void pasoReloj(){
        Date ahora = new Date();
        String ahoraFormateado ="";
        if (alarma!=null){
            ahoraFormateado=Alarma.getHoraFormateada(ahora, alarma.isDoceHoras(), alarma.isMostrarSegundos());
        }else{
            ahoraFormateado=Alarma.getHoraFormateada(ahora, false, true);
        }
        this.setText(ahoraFormateado);
        if (!alarmaYaSaltada &&saltoDeAlarmaListener!=null && alarma!=null){
            if (alarma.isAlarmaActiva()){
                String horaAlarma=alarma.getHora();
                System.out.println("Alarma activada:" + alarma.isAlarmaActiva()+" Hora de la alarma:"+ horaAlarma+"    Hora actual:"+ahoraFormateado);
                if (ahoraFormateado.equals(horaAlarma)){
                    alarmaYaSaltada=true;
                    saltoDeAlarmaListener.saltaAlarma();
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

 

    public void addSaltoDeAlarmaListener(SaltoDeAlarmaListener alarmaListener) {
        this.saltoDeAlarmaListener = alarmaListener;
    }
    
 
     public void removeSaltoDeAlarmaListener(){
        this.saltoDeAlarmaListener = null;
    }
    
}
