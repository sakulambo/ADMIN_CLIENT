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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author sakulambo
 */
public class Delete_Product extends javax.swing.JFrame {

    public DeleteProductController getDeleteProductController() {
        return deleteProductController;
    }

    public void setDeleteProductController(DeleteProductController deleteProductController) {
        this.deleteProductController = deleteProductController;
    }
    
    
    /**
     * Creates new form Delete_Product
     */
    public Delete_Product() {
        super("Eliminar Producto");
        initComponents();        
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
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecciona un producto...");

        jbAceptar.setText("Aceptar");

        jbCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(365, 365, 365)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAceptar)
                    .addComponent(jbCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startOperation() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        sesion = sessionFactory.openSession();
        sesion.getTransaction().begin();
    }

    private void endOperation() {
        sesion.getTransaction().commit();
        sesion.close();
    }

    private List<Products> getData() {
        startOperation();

        Query query = (Query) sesion.createQuery("FROM Productos");

        List<Products> listaResultados = query.list();

        endOperation();

        return listaResultados;
    }

    private void loadTable(List<Products> productos) {

        String[] columns = {"ID", "Nombre", "Precio", "Descripción"};
        dtm = new DefaultTableModel(columns, 0);
        jtProducts = new JTable();

        productos.forEach((producto) -> {
            dtm.addRow(new Object[]{producto.getId(), producto.getName(), producto.getPrice(), producto.getDescription()});
        });

        jtProducts.setModel(dtm);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    // End of variables declaration//GEN-END:variables
    private Session sesion;
    private DefaultTableModel dtm;
    private JTable jtProducts;
    private List<Products> productos;
    private Service service;
    private DeleteProductController deleteProductController;

}
