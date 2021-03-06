/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ShowStaff_Controller;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.pojo.Staff;

/**
 *
 * @author sakulambo
 */
public class Show_Staff extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private ShowStaff_Controller ssc;
    private List<Staff> staff;

    public ShowStaff_Controller getSsc() {
        return ssc;
    }

    public void setSsc(ShowStaff_Controller ssc) {
        this.ssc = ssc;
    }

    public Show_Staff() {
        super("Mostrar Personal");
        initComponents();
    }

    public void jframVisible() {
        if (this.ssc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            staff = this.ssc.getController().getService().getStaffDAO().getStaffList();
            loadTable(staff);

            this.setVisible(true);
        }
    }

    private void loadTable(List<Staff> staff) {
        dtm = (DefaultTableModel) this.jtStaff.getModel();
        staff.forEach((personal) -> {
            dtm.addRow(new Object[]{personal.getId(), personal.getFirstName(), personal.getLastName(), personal.getAddress(), personal.getPhone(), personal.getLastConnection()});
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtStaff = new javax.swing.JTable();
        jbExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Personal", "Nombre", "Apellidos", "Dirección", "Telefono", "Ultima_Conexión"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtStaff);
        if (jtStaff.getColumnModel().getColumnCount() > 0) {
            jtStaff.getColumnModel().getColumn(0).setResizable(false);
            jtStaff.getColumnModel().getColumn(1).setResizable(false);
            jtStaff.getColumnModel().getColumn(2).setResizable(false);
            jtStaff.getColumnModel().getColumn(3).setResizable(false);
            jtStaff.getColumnModel().getColumn(4).setResizable(false);
            jtStaff.getColumnModel().getColumn(5).setResizable(false);
        }

        jbExit.setText("Salir");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Mostrando personal...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(466, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jbExit)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbExitActionPerformed

    private void reset() {
        dtm.setRowCount(0);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExit;
    private javax.swing.JTable jtStaff;
    // End of variables declaration//GEN-END:variables
}
