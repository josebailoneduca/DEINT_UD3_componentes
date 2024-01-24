/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package componentes.limitedjtextfield;
/*
 * LICENCIA JOSE JAVIER BO
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Lista de paquetes:
 */
import java.awt.Color;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Clase principal del componente
 * @author Jose Javier BO
 */
public class LimitedJTextField extends JTextField implements Serializable, DocumentListener {

    //colores a usar para mostrar cuando se alcance
    private Colores colores = null;
    
    //Limite que define cuando se empiezan a usaro los colores
    private int limiteCaracteres = 25;

    public LimitedJTextField() {
        setText("Edita prop.:'Colores'");
        this.getDocument().addDocumentListener(this);
    }

    //GETTERS Y SETTERS
    public Colores getColores() {
        return colores;
    }

    public void setColores(Colores colores) {
        this.colores = colores;
    }

    public int getLimiteCaracteres() {
        return limiteCaracteres;
    }

    public void setLimiteCaracteres(int limiteCaracteres) {
        this.limiteCaracteres = limiteCaracteres;
    }

    
    //Actualiza el estado de los colores
    private void actualizaEstado() {
        //si es null avisar de que se debe definir la propiedad colores
        if (colores==null)
            avisarPonerColores();
        else{
            //si se ha llegado o sobrepasado el limite se ponen los colores elegidos
            if (this.getText().length()>=limiteCaracteres){
                setForeground(colores.getColorTexto());
                setBackground(colores.getColorFondo());
            }else{
                //en caso contrario se ponen los colores blanco para fondo y negro para texto
                setForeground(Color.BLACK);
                setBackground(Color.WHITE);
            }
        }
    }
    
    /**
     * Avisa con un joptionpane de que se deben configurar los colores de la propiedad colores
     */
    private void avisarPonerColores(){
        JOptionPane.showMessageDialog(this, "Debe configurar los colores en la propiedad 'Colores'","Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    
    
    //LISTENERS del document
    @Override
    public void insertUpdate(DocumentEvent e) {
        actualizaEstado();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        actualizaEstado();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        actualizaEstado();
    }

    
}
