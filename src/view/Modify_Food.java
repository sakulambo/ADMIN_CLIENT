/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import controller.ModifyFood_Controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.pojo.Foods;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sakulambo
 */
public class Modify_Food extends javax.swing.JFrame {

    
    private List<Foods> foods;

    private DefaultTableModel dtm;
    private ModifyFood_Controller mfc;

    public ModifyFood_Controller getDpc() {
        return mfc;
    }

    public void setDpc(ModifyFood_Controller dpc) {
        this.mfc = dpc;
    }

    /**
     * Creates new form Delete_Product
     */
    public Modify_Food() {
        super("Modificar comida");
        initComponents();
    }

    public void jframeVisible() {
        if (this.mfc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            foods = this.mfc.getController().getService().getFoodsDAO().getFoodList();            
            loadTableFoods(foods);
            this.setVisible(true);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbModify = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbReportFood = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtFoods = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbModify.setText("Modificar");
        jbModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModifyActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbReportFood.setText("Generar Reporte");
        jbReportFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportFoodActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecciona una comida...");

        jtFoods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tipo de plato", "Nombre", "Precio", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtFoods);
        if (jtFoods.getColumnModel().getColumnCount() > 0) {
            jtFoods.getColumnModel().getColumn(0).setResizable(false);
            jtFoods.getColumnModel().getColumn(1).setResizable(false);
            jtFoods.getColumnModel().getColumn(2).setResizable(false);
            jtFoods.getColumnModel().getColumn(3).setResizable(false);
            jtFoods.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jbReportFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCancelar)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 629, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModify)
                    .addComponent(jbCancelar)
                    .addComponent(jbReportFood))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModifyActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres modificar este producto? ", "Modificar Producto", JOptionPane.YES_NO_OPTION);
        if (reply == genericPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Producto modificada correctamente!");

        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada!");
        }
    }//GEN-LAST:event_jbModifyActionPerformed

    private void jbReportFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportFoodActionPerformed
          int result = JOptionPane.showConfirmDialog(genericPane, "Quieres generar un reporte?", "Generar reporte", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            this.mfc.getController().getService().getReportDAO().setFoodList(this.mfc.getController().getService().getFoodsDAO().getFoodList());
            try {
                JasperPrint jp = this.mfc.getController().getService().getReportDAO().getReportFoods();
                JasperViewer jv = new JasperViewer(jp, false);
                jv.setVisible(true);
            } catch (ColumnBuilderException | JRException | ClassNotFoundException ex) {
                Logger.getLogger(Show_Table.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           JOptionPane.showMessageDialog(null, "Operación cancelada", "Cancelar", result);
        }
    }//GEN-LAST:event_jbReportFoodActionPerformed

   

    private void loadTableFoods(List<Foods> foods) {
        dtm = (DefaultTableModel) this.jtFoods.getModel();
        foods.forEach((food) -> {
            dtm.addRow(new Object[]{food.getId(), food.getFamilyDish(), food.getName(), food.getPrice(),
                food.getDescription()});
        });
    }

    private void reset() {
        dtm.setRowCount(0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbModify;
    private javax.swing.JButton jbReportFood;
    private javax.swing.JTable jtFoods;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JOptionPane genericPane;
    private String[] options;
}
