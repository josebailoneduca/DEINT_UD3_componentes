/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Bailon
 */
public class AppExecutionPlanner extends JPanel implements Serializable, ActionListener {

    private JPanel panelMedio;
    private JPanel panelInferior;

    private FechaHoraDigital fechaHoraDigital;
    private FechaPlanificada fechaPlanificada;
    private AplicacionEjecutable aplicacionEjecutable;

    private EtiquetaEstado estado;

    private boolean cargado = false;
    private boolean ejecutado = false;

    
    private JLabel lbInfoFecha;
    private JLabel lbInfoPrograma;
    private JLabel lbInfoRuta;
    
    
    private Timer timer;
    //propiedad fechaplanificada que tendra un propio support editor y tiene su propia clase

    public AppExecutionPlanner() {
        //setting general del panel
        this.setBounds(0, 0, 200, 100);
        BoxLayout bly = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(bly);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        //FECHAHORADIGITAL
        fechaHoraDigital = new FechaHoraDigital(true, false);
        fechaHoraDigital.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(fechaHoraDigital);

        //ESTADO Y BOTON CARGA
        panelMedio = new JPanel();
        panelMedio.setLayout(new BorderLayout(20, 0));
        panelMedio.setBorder(new EmptyBorder(10, 10, 10, 10));
        estado = new EtiquetaEstado();
        JButton btnCargar = new JButton("Cargar");
        btnCargar.setActionCommand("cargar");
        btnCargar.addActionListener(this);
        panelMedio.add(estado, BorderLayout.WEST);
        panelMedio.add(btnCargar, BorderLayout.EAST);
        this.add(panelMedio);

        
        //Etiquetas de informacion
 
        lbInfoFecha = new JLabel("Fecha de ejecución: Sin fecha");
        lbInfoFecha.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbInfoFecha.setOpaque(true);
        lbInfoFecha.setBackground(Color.MAGENTA);
        lbInfoPrograma = new JLabel("Programa: Sin programa");
        lbInfoPrograma.setAlignmentX(Component.LEFT_ALIGNMENT);
        lbInfoRuta = new JLabel("Ruta ejecutable:");
        lbInfoRuta.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(lbInfoFecha);
        this.add(lbInfoPrograma);
        this.add(lbInfoRuta);
        lbInfoFecha.getParent().setBackground(Color.pink);
        
        
        fechaPlanificada = null;
        aplicacionEjecutable = null;

        this.timer = new Timer(1000, this);
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
        fechaHoraDigital.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.fechaHoraDigital, 0);
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
        System.out.println(ac);
        switch (ac) {
            case "paso":
                pasoSegundo();
                break;
            case "cargar":
                cargar();
                break;
        }

    }

    private void pasoSegundo() {
        Date d = new Date();
        fechaHoraDigital.actualizahora(d);
        if (fechaPlanificada != null && aplicacionEjecutable != null && !ejecutado && esLaHora(d)) {
            try {
                ejecutado = true;
                Runtime.getRuntime().exec(aplicacionEjecutable.getAbsolutePath());
                estado.setEstado(EtiquetaEstado.EJECUTADO);
                new Mensaje(null, estado.getColorActual(), "Programa ejecutado correctamente", "El programa ha sido ejecutado \n" + aplicacionEjecutable.getAbsolutePath()).setVisible(true);
            } catch (IOException ex) {
                new Mensaje(null, Color.RED, "Error", "No se pudo ejecutar el programa \n" + aplicacionEjecutable.getAbsolutePath() + "\n" + ex.getMessage()).setVisible(true);
            }
            {
            }
        }

    }

    private void cargar() {
        if (fechaPlanificada == null || aplicacionEjecutable == null) {
            new Mensaje(null, estado.getColorActual(), "Cargar programa y seleccionar fecha", "Debe introducir la Fecha de Planificación y el Ejecutable").setVisible(true);
        } else {
            cargado = true;
            estado.setEstado(EtiquetaEstado.CARGADO);
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaPlanificada.getDate());
            String msg = String.format("Se va a ejecutar el programa %s a las %s %02d:%02d:%02d",
                    aplicacionEjecutable.getAbsolutePath(),
                    fecha,
                    fechaPlanificada.getHora(),
                    fechaPlanificada.getMinuto(),
                    fechaPlanificada.getSegundo());
            new Mensaje(null, estado.getColorActual(), "Programada ejecución", msg).setVisible(true);
        }
    }

    private boolean esLaHora(Date d) {
        //planificado
        String fPlan = new SimpleDateFormat("dd/MM/yyyy").format(fechaPlanificada.getDate());
        int hPlan = fechaPlanificada.getHora();
        int mPlan = fechaPlanificada.getMinuto();
        int sPlan = fechaPlanificada.getSegundo();

        //actual
        String fActu = new SimpleDateFormat("dd/MM/yyyy").format(d);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        int hAct = cal.get(Calendar.HOUR_OF_DAY);
        int mAct = cal.get(Calendar.MINUTE);
        int sAct = cal.get(Calendar.SECOND);

        if (fPlan.equals(fActu) && hPlan == hAct && mPlan == mAct && sPlan == sAct) {
            return true;
        } else {
            return false;
        }

    }

}
