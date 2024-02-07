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
 * COMPONENTE PRINCIPAL 
 * Está compuesto por los atributos fechaHoraDigital, fechaPlanificada, aplicacionEjecutable, estado(EtiquetaEstado).
 * 
 * Ademas lleva control de si se ha cargado y/o ejecutado ya el programa.
 * 
 * Un Timer comprueba cada segundo la fecha/hora y actualiza la fechaHoraDigital. 
 * Además si se han cargado programa a ejecutar y se ha definido fecha comprueba
 * si es el momento de ejecutar la aplicacion elegida.
 * 
 * Los JLabel lbInfoFecha,lbInfoPrograma y lbInforuta son para propositos informativos
 * de la versión mejorada y muestra qué programa de qué ruta se ha elegido y a qué hora 
 * se ejecutará.
 * 
 * 
 * Atributos editables en el editor de netbeans:
 * - aplicacionEjecutable: Para seleccionar qué aplicacion se ejecutará
 * - fechaHoraDigital: Formato para la etiqueta de fecha/hora actual
 * - fechaPlanificada: Selector de fecha y hora del momento de ejecucion de la aplicacion.
 * 
 * Cada vez que se modifica el estado de alguna de esas propiedades el estado pasa
 * a NO_CARGADO y establece que no se ha ejecutado la aplicación aún.
 * 
 * @author Jose Javier BO
 */
public class AppExecutionPlanner extends JPanel implements Serializable, ActionListener {

    
    //Fecha y hora actuales 
    private FechaHoraDigital fechaHoraDigital;
    
    //Fecha planificada para ejecución
    private FechaPlanificada fechaPlanificada;
    
    //Aplicacion a ejecutar
    private AplicacionEjecutable aplicacionEjecutable;

    //Etiqueta de estado muestra la etiqueta roja,amarilla,verde segun el estado
    private EtiquetaEstado estado;

    //True si se ha pulsado el boton cargar, False si no se ha hecho
    private boolean cargado = false;
    
    //True una vez que se haya ejecutado la aplicacion
    private boolean ejecutado = false;

    //Etiquetas informativas
    private JLabel lbInfoFecha;
    private JLabel lbInfoPrograma;
    private JLabel lbInfoRuta;
    
    //Timer encargado de hacer comprobaciones cada segundo
    private Timer timer;


    /**
     * Constructor. Establece los parametros iniciales visuales y de estado.
     */
    public AppExecutionPlanner() {
        //Propiedades generales del panel
        this.setBounds(0, 0, 200, 100);
        BoxLayout bly = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(bly);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        //FECHAHORADIGITAL
        fechaHoraDigital = new FechaHoraDigital(true, false);
        this.add(fechaHoraDigital);
        fechaHoraDigital.setAlignmentX(Component.CENTER_ALIGNMENT);

        //ESTADO Y BOTON CARGA
        JPanel panelMedio = new JPanel();
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
        lbInfoFecha.setOpaque(true);
        lbInfoFecha.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lbInfoFecha);
        lbInfoPrograma = new JLabel("Programa: Sin programa");
        this.add(lbInfoPrograma);
        lbInfoPrograma.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbInfoRuta = new JLabel("Ruta ejecutable:");
        this.add(lbInfoRuta);
        lbInfoRuta.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //inicializacion de atributos fechaplanificada y apllicacion ejecutable
        //A null hasta que el usuario elija algo en el editor.
        fechaPlanificada = null;
        aplicacionEjecutable = null;

        //Arrancar el timmer
        this.timer = new Timer(1000, this);
        this.timer.setActionCommand("paso");
        this.timer.start();   
    }

    //GETTER Y SETTER del parametro AplicacionEjecutable.
    public AplicacionEjecutable getAplicacionEjecutable() {
        return aplicacionEjecutable;
    }

    public void setAplicacionEjecutable(AplicacionEjecutable aplicacionEjecutable) {
        this.aplicacionEjecutable = aplicacionEjecutable;
        //actualizar etiquetas de informacion
        lbInfoPrograma.setText("Programa: "+aplicacionEjecutable.getName());
        lbInfoRuta.setText("Ruta ejecutable: "+aplicacionEjecutable.getAbsolutePath());
        resetEstado();
    }

    //GETTER Y SETTER del parametro FechaHoraDigital.
    public FechaHoraDigital getFechaHoraDigital() {
        return fechaHoraDigital;
    }

    public void setFechaHoraDigital(FechaHoraDigital fechaHoraDigital) {
        //quitar el elemento angiguo
        this.remove(this.fechaHoraDigital);
        this.fechaHoraDigital = fechaHoraDigital;
        //poner en pantalla el elemento nuevo
        fechaHoraDigital.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.fechaHoraDigital, 0);
        resetEstado();
    }

    //GETTER Y SETTER del parametro FechaPlanificada.
    public FechaPlanificada getFechaPlanificada() {
        return fechaPlanificada;
    }
    
    public void setFechaPlanificada(FechaPlanificada fechaPlanificada) {
        this.fechaPlanificada = fechaPlanificada;
        //actualizar etiqueta informativa
        lbInfoFecha.setText("Fecha de ejecución: "+fechaPlanificada.getTextoHoraFecha());
        resetEstado();
    }

    
    /**
     * Escucha de timer y boton
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        switch (ac) {
            case "paso":
                pasoSegundo();
                break;
            case "cargar":
                cargar();
                break;
        }

    }

    /**
     * Acciones ejecutadas cada tic del timer.
     * Actualiza la etiqueta de hora actual y comprueba si es el momento de ejecutar el programa
     */
    private void pasoSegundo() {
        //fecha/hora actual
        Date d = new Date();
        //actualizar fechaHoraDigital
        fechaHoraDigital.actualizahora(d);
        
        //si hay fecha planificada, aplicacion ejecutable, no se ha ejecutado aún y es la hora entonces se ejecuta el programa.
        if (fechaPlanificada != null && aplicacionEjecutable != null && !ejecutado && esLaHora(d)) {
            try {
                ejecutado = true;
                Runtime.getRuntime().exec(aplicacionEjecutable.getAbsolutePath());
                estado.setEstado(EtiquetaEstado.EJECUTADO);
                new Mensaje(null, estado.getColorActual(), "Programa ejecutado correctamente", "El programa ha sido ejecutado \n" + aplicacionEjecutable.getAbsolutePath()).setVisible(true);
            } catch (IOException ex) {
                new Mensaje(null, Color.RED, "Error", "No se pudo ejecutar el programa \n" + aplicacionEjecutable.getAbsolutePath() + "\n" + ex.getMessage()).setVisible(true);
            }
        }

    }

    /**
     * Accion de cargar.
     * Si no hay fechaPlanificada o aplicacionEjecutable muestra
     * un mensaje avisando de ello.
     * Si los hay establece el estado a cargado y muestra un mensaje con los datos
     * de ejecución. Además actualiza la etiqueta de estado
     */
    private void cargar() {
        if (fechaPlanificada == null || aplicacionEjecutable == null) {
            new Mensaje(null, estado.getColorActual(), "Cargar programa y seleccionar fecha", "Debe introducir la Fecha de Planificación y el Ejecutable").setVisible(true);
        } else {
            cargado = true;
            estado.setEstado(EtiquetaEstado.CARGADO);
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaPlanificada.getDate());
            String msg = String.format("Se va a ejecutar el programa el %s",
                    aplicacionEjecutable.getAbsolutePath(),
                    fechaPlanificada.getTextoHoraFecha());
            new Mensaje(null, estado.getColorActual(), "Programada ejecución", msg).setVisible(true);
        }
    }

    /**
     * True si es la hora de ejecutar. False si no lo es
     * @param d Fecha/hora a comprobar
     * @return  True si hay que ejecutar, false si no.
     */
    private boolean esLaHora(Date d) {
        //momento planificado
        String fPlan = new SimpleDateFormat("dd/MM/yyyy").format(fechaPlanificada.getDate());
        int hPlan = fechaPlanificada.getHora();
        int mPlan = fechaPlanificada.getMinuto();
        int sPlan = fechaPlanificada.getSegundo();

        //momento actual
        String fActu = new SimpleDateFormat("dd/MM/yyyy").format(d);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        int hAct = cal.get(Calendar.HOUR_OF_DAY);
        int mAct = cal.get(Calendar.MINUTE);
        int sAct = cal.get(Calendar.SECOND);

        //comprobacion
        return fPlan.equals(fActu) && hPlan == hAct && mPlan == mAct && sPlan == sAct;
    }

    /**
     * Resetea el estado de ejecucion y carga
     */
    private void resetEstado(){
        ejecutado=false;
        cargado=false;
        estado.setEstado(EtiquetaEstado.NO_CARGADO);
    }
}
