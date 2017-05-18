/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import controller.ModifyDrink_Controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.pojo.Drinks;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sakulambo
 */
public class Modify_Drink extends javax.swing.JFrame {

    private ModifyDrink_Controller mdc;
    private List<Drinks> drinks;
    

    public ModifyDrink_Controller getMdc() {
        return mdc;
    }

    public void setMdc(ModifyDrink_Controller mdc) {
        this.mdc = mdc;
    }

    public Modify_Drink() {
        super("Modificar bebida");
        initComponents();
    }
    
    public void jframeVisible(){
         if (this.mdc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            drinks = this.mdc.getController().getService().getDrinksDAO().getDrinkList();            
            loadTableDrinks(drinks);
            this.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbReport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDrinks = new javax.swing.JTable();
        jbReportDrinks = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        jbReport.setText("Generar Reporte");
        jbReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecciona una bebida...");

        jtDrinks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Descripción", "Capacidad(ml)", "Tipo de envase", "Azucarada?", "Alcoholica?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtDrinks);
        if (jtDrinks.getColumnModel().getColumnCount() > 0) {
            jtDrinks.getColumnModel().getColumn(0).setResizable(false);
            jtDrinks.getColumnModel().getColumn(1).setResizable(false);
            jtDrinks.getColumnModel().getColumn(2).setResizable(false);
            jtDrinks.getColumnModel().getColumn(3).setResizable(false);
            jtDrinks.getColumnModel().getColumn(4).setResizable(false);
            jtDrinks.getColumnModel().getColumn(5).setResizable(false);
            jtDrinks.getColumnModel().getColumn(6).setResizable(false);
            jtDrinks.getColumnModel().getColumn(7).setResizable(false);
        }

        jbReportDrinks.setText("Generar Reporte");
        jbReportDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportDrinksActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jbReportDrinks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbReportDrinks)
                    .addComponent(jbCancelar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportActionPerformed
      
    }//GEN-LAST:event_jbReportActionPerformed

    private void jbReportDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportDrinksActionPerformed

        int result = JOptionPane.showConfirmDialog(genericPane, "Quieres generar un reporte?", "Generar reporte", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.mdc.getController().getService().getReportDAO().setDrinkList(this.mdc.getController().getService().getDrinksDAO().getDrinkList());
            try {
                JasperPrint jp = this.mdc.getController().getService().getReportDAO().getReportDrinks();
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (ColumnBuilderException | JRException | ClassNotFoundException ex) {
                Logger.getLogger(Show_Table.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showConfirmDialog(null, "Operación cancelada","Cancelar",1);
        }
    }//GEN-LAST:event_jbReportDrinksActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void reset() {
        dtm.setRowCount(0);
    }
    
     private void loadTableDrinks(List<Drinks> drinks) {
        dtm = (DefaultTableModel) this.jtDrinks.getModel();
        drinks.forEach((drink) -> {
            dtm.addRow(new Object[]{drink.getId(), drink.getName(), drink.getPrice(),
                drink.getDescription(), drink.getCapacity(), drink.getTypeBottle(),
                drink.getSoda(), drink.getAlcohol()});
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbReport;
    private javax.swing.JButton jbReportDrinks;
    private javax.swing.JTable jtDrinks;
    // End of variables declaration//GEN-END:variables
    private String[] options;
    private JOptionPane genericPane;
    private DefaultTableModel dtm;
}
