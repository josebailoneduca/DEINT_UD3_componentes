/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bailon
 */
public class AppExecutionPlanner extends JPanel implements Serializable,ActionListener {
    
    private JPanel panelMedio;
    private JPanel panelInferior;
//    
    
    private FechaHoraDigital fechaHoraDigital;
    private FechaPlanificada fechaPlanificada;
    private AplicacionEjecutable aplicacionEjecutable;
    
    
    
    private Timer timer;
    //propiedad fechaplanificada que tendra un propio support editor y tiene su propia clase
    
    public AppExecutionPlanner(){
        this.setBounds(0, 0, 200, 100);
        BoxLayout bly=new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(bly);
        

        fechaHoraDigital=new FechaHoraDigital(true, false);
        fechaHoraDigital.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(fechaHoraDigital);
//          
//        
//        panelMedio = new JPanel();
//        panelMedio.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
//        
        
        
        
        
        fechaPlanificada = null;
        aplicacionEjecutable=null;
        
        this.timer=new Timer(1000, this);
        this.timer.setActionCommand("paso");
        this.timer.start();
        
        
    }

    public AplicacionEjecutable getAplicacionEjecutable() {
        return aplicacionEjecutable;
    }

    public void setAplicacionEjecutable(AplicacionEjecutable aplicacionEjecutable) {
        this.aplicacionEjecutable = aplicacionEjecutable;
    }

    //GETTERS Y SETTERS
    public FechaHoraDigital getFechaHoraDigital() {
        return fechaHoraDigital;
    }

    public void setFechaHoraDigital(FechaHoraDigital fechaHoraDigital) {
        this.remove(this.fechaHoraDigital);
        this.fechaHoraDigital = fechaHoraDigital;
        this.add(this.fechaHoraDigital,0);
    }

    public FechaPlanificada getFechaPlanificada() {
        return fechaPlanificada;
    }

    public void setFechaPlanificada(FechaPlanificada fechaPlanificada) {
        this.fechaPlanificada = fechaPlanificada;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if (ac.equals("paso")){
             Date d = new Date();
            fechaHoraDigital.actualizahora(d);
        }
    }
    
}
