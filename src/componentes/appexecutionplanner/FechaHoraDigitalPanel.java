/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes.appexecutionplanner;



/**
 * Panel de edicion del atributo FechaHoraDigital
 * @author Jose Javier BO
 */
public class FechaHoraDigitalPanel extends javax.swing.JPanel {

    
    
    /**
     * Constructor
     */
    public FechaHoraDigitalPanel() {
        initComponents();
    }

    
    public FechaHoraDigital getSelectedValue(){
        //recogr datos de la interfaz
        boolean ms=this.mostrarSegundos.isSelected();
        boolean doceHoras = this.inputTipo.getSelectedItem().toString().equals("12 Horas");
        //crear y retornar el objeto FechaHoraDigital
        return new FechaHoraDigital(doceHoras, ms);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputTipo = new javax.swing.JComboBox<>();
        mostrarSegundos = new javax.swing.JCheckBox();

        inputTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12 Horas", "24 Horas" }));
        inputTipo.setActionCommand("inputTipo");

        mostrarSegundos.setText("mostrarSegundos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mostrarSegundos)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostrarSegundos))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> inputTipo;
    private javax.swing.JCheckBox mostrarSegundos;
    // End of variables declaration//GEN-END:variables
}
