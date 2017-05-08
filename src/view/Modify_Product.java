/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ModifyProduct_Controller;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.pojo.Products;

/**
 *
 * @author sakulambo
 */
public class Modify_Product extends javax.swing.JFrame {

    private List<Products> products;

    private DefaultTableModel dtm;
    private ModifyProduct_Controller dpc;

    public ModifyProduct_Controller getDpc() {
        return dpc;
    }

    public void setDpc(ModifyProduct_Controller dpc) {
        this.dpc = dpc;
    }

    /**
     * Creates new form Delete_Product
     */
    public Modify_Product() {
        super("Modificar Producto");
        initComponents();
    }

    public void jframeVisible() {
        if (this.dpc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            products = this.dpc.getController().getService().getProductsDAO().getProductList();
            loadTable(products);
            this.setVisible(true);
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbEliminar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jbReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Selecciona un producto...");

        jbEliminar.setText("Modificar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProductos);
        if (jtProductos.getColumnModel().getColumnCount() > 0) {
            jtProductos.getColumnModel().getColumn(0).setResizable(false);
            jtProductos.getColumnModel().getColumn(1).setResizable(false);
            jtProductos.getColumnModel().getColumn(2).setResizable(false);
            jtProductos.getColumnModel().getColumn(3).setResizable(false);
        }

        jbReport.setText("Generar Reporte");
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbCancelar)
                    .addComponent(jbReport))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.dispose();
         reset();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres modificar este producto? ", "Modificar Producto", JOptionPane.YES_NO_OPTION);
        if (reply == genericPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Producto modificada correctamente!");

        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada!");                    
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportActionPerformed
      
    }//GEN-LAST:event_jbReportActionPerformed

    private void loadTable(List<Products> productos) {
        dtm = (DefaultTableModel) this.jtProductos.getModel();
        productos.forEach((producto) -> {
            dtm.addRow(new Object[]{producto.getId(), producto.getName(), producto.getPrice(), producto.getDescription()});
            System.out.println(producto.getId() + " " + producto.getName() + " " + producto.getPrice() + " " + producto.getDescription());
        });

    }
     private void reset(){
        dtm.setRowCount(0);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbReport;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JOptionPane genericPane;
}
