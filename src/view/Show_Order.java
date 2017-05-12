/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import controller.ShowOrder_Controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.pojo.Menus;
import model.pojo.Orders;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sakulambo
 */
public class Show_Order extends javax.swing.JFrame {

    public ShowOrder_Controller getSoc() {
        return soc;
    }

    public void setSoc(ShowOrder_Controller soc) {
        this.soc = soc;
    }

    
    public Show_Order() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOrders = new javax.swing.JTable();
        jbExit = new javax.swing.JButton();
        jbReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mostrando comandas...");

        jtOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Comentarios", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtOrders);
        if (jtOrders.getColumnModel().getColumnCount() > 0) {
            jtOrders.getColumnModel().getColumn(0).setResizable(false);
            jtOrders.getColumnModel().getColumn(1).setResizable(false);
            jtOrders.getColumnModel().getColumn(2).setResizable(false);
            jtOrders.getColumnModel().getColumn(3).setResizable(false);
        }

        jbExit.setText("Salir");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jbReport.setText("Generar reporte");
        jbReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExit)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExit)
                    .addComponent(jbReport))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbExitActionPerformed

    private void jbReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportActionPerformed
       this.soc.getController().getService().getReportDAO().setOrdersList(this.soc.getController().getService().getOrdersDAO().getOrderList());
        try {
            JasperPrint jp = this.soc.getController().getService().getReportDAO().getReportOrders();
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (ColumnBuilderException | JRException | ClassNotFoundException ex) {
            Logger.getLogger(Show_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbReportActionPerformed

  
    
    
    private void reset(){
        dtm.setRowCount(0);
    }

    public void jframeVisible(){
        if (this.soc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            this.orders = this.soc.getController().getService().getOrdersDAO().getOrderList();
            loadTable(orders);
            this.setVisible(true);
        }
    }
    
      private void loadTable(List<Orders> orders) {
        dtm = (DefaultTableModel) this.jtOrders.getModel();
        orders.forEach((order) -> {
            dtm.addRow(new Object[]{order.getId(),order.getCommentary(),order.getTotal(),order.getDate()});
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbReport;
    private javax.swing.JTable jtOrders;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel dtm;
    private ShowOrder_Controller soc;
    private List<Orders> orders;
    
}
