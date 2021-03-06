/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CiclosController;
import entity.Ciclo;
import viewmodel.CicloViewModel;

/**
 *
 * @author jonathan
 */
public class CiclosView extends javax.swing.JFrame  implements java.util.Observer{

    /**
     * Creates new form CiclosView
     */
    
    private CiclosController controller;
    private CicloViewModel model;
    
    
    public CiclosView() {
        initComponents();
    
    }

    public CiclosController getController() {
        return controller;
    }

    public void setController(CiclosController controller) {
        this.controller = controller;
    }

    public CicloViewModel getModel() {
        return model;
        
    }

    public void setModel(CicloViewModel model) {
        this.model = model;
          model.addObserver(this);
    }
    
    @Override
       public void update(java.util.Observable updatedModel,Object parametros){
           this.updateComboBoxes();
          
       }
      
       private Ciclo toCiclo(){
           return (Ciclo)this.ciclosComboBox.getSelectedItem();
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ciclosComboBox = new javax.swing.JComboBox();
        verButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione un Ciclo");
        jLabel1.setAlignmentX(0.5F);

        ciclosComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        verButton.setText("Ver");
        verButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(ciclosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(verButton)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(ciclosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(verButton)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verButtonActionPerformed
      this.controller.getGruposPorCiclo(this.toCiclo());
    }//GEN-LAST:event_verButtonActionPerformed

    /**
     * @param args the command line arguments
     */
  void updateComboBoxes(){
      
  //this.controller.setComboBox();
  //System.out.println("ADIOS");
  //System.out.println(this.controller.getModel().getCiclos());
  this.ciclosComboBox.setModel(this.controller.getModel().getCiclos());
  
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ciclosComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton verButton;
    // End of variables declaration//GEN-END:variables
}
