/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AddStaff_Controller;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.dao.AbstractDAO;
import model.pojo.Staff;
import model.pojo.Waiters;

/**
 *
 * @author sakulambo
 */
public class Add_Staff extends javax.swing.JFrame {
    
    public Add_Staff() {
        super("Añadir Personal");
        initComponents();
    }

    public AddStaff_Controller getAsc() {
        return asc;
    }

    public void setAsc(AddStaff_Controller asc) {
        this.asc = asc;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfAddress = new javax.swing.JTextField();
        jtfPhone = new javax.swing.JTextField();
        jrbYes = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jbAccept = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellidos");

        jLabel3.setText("Dirección");

        jLabel4.setText("Telefono");

        jrbYes.setText("Si");

        jrbNo.setText("No");

        jLabel5.setText("Camarero");

        jbAccept.setText("Aceptar");
        jbAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcceptActionPerformed(evt);
            }
        });

        jbCancel.setText("Cancelar");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbYes)
                                .addGap(18, 18, 18)
                                .addComponent(jrbNo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(jtfName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPhone)))
                        .addGap(82, 82, 82))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAccept)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCancel)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbYes)
                    .addComponent(jrbNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAccept)
                    .addComponent(jbCancel))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcceptActionPerformed
       
        name = this.jtfName.getText();
        surname = this.jtfLastName.getText();
        phone = this.jtfPhone.getText();
        address = this.jtfAddress.getText();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
        Date d = new Date();
        String date = dateFormat.format(d);        
        
        if(jrbYes.isSelected()){           
            AbstractDAO.almacenaEntidad(new Staff(name, surname, address, phone, d));
        }
        
        
    }//GEN-LAST:event_jbAcceptActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbCancelActionPerformed

   private void reset(){
       this.jtfName.setText("");
       this.jtfLastName.setText("");
       this.jtfAddress.setText("");
       this.jtfPhone.setText("");
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbAccept;
    private javax.swing.JButton jbCancel;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbYes;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfPhone;
    // End of variables declaration//GEN-END:variables
    private String name,surname,phone,address;
    private AddStaff_Controller asc;
}
