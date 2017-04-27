/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DeleteProductController;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.pojo.Products;
import model.service.Service;
import org.hibernate.Session;

/**
 *
 * @author sakulambo
 */
public class Delete_Product extends javax.swing.JFrame {
    
    private List<Products> products;
    private DefaultTableModel dtm;
    private DeleteProductController dpc;

    public DeleteProductController getDeleteProductController() {
        return dpc;
    }

    public void setDeleteProductController(DeleteProductController deleteProductController) {
        this.dpc = deleteProductController;
    }
    
    
    /**
     * Creates new form Delete_Product
     */
    public Delete_Product() {
        super("Eliminar Producto");  
        initComponents(); 
        if(this.dpc == null){
            System.out.println("hola");
        }
        
        this.products = this.dpc.getController().getService().getProductsDAO().getProductList();
        loadTable(products);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Selecciona un producto...");

        jbAceptar.setText("Aceptar");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jbAceptar))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar)
                    .addComponent(jbCancelar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

//    private void startOperation() {
//        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//        sesion = sessionFactory.openSession();
//        sesion.getTransaction().begin();
//    }
//
//    private void endOperation() {
//        sesion.getTransaction().commit();
//        sesion.close();
//    }


    private void loadTable(List<Products> productos) {
        jtProductos = new JTable();
        dtm = (DefaultTableModel) this.jtProductos.getModel();   
        productos.forEach((producto) -> {
            dtm.addRow(new Object[]{producto.getId(), producto.getName(), producto.getPrice(), producto.getDescription()});
            System.out.println(producto.getId()+" "+producto.getName()+" "+producto.getPrice()+" "+producto.getDescription());
        });

        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables
    

}
