/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ShowTable_Controller;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.pojo.Tables;

/**
 *
 * @author sakulambo
 */
public class Show_Table extends javax.swing.JFrame {

    private ShowTable_Controller stc;
    private DefaultTableModel dtm;
    private List<Tables> tables;

    public Show_Table() {
        super("Mostrar Mesas");       
            initComponents();           
    }

    public ShowTable_Controller getStc() {
        return stc;
    }

    public void setStc(ShowTable_Controller stc) {
        this.stc = stc;
    }
    
    public void jframeVisible() {
        if (this.stc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            tables = this.stc.getController().getService().getTablesDAO().getTableList();
            loadTable(tables);
            this.setVisible(true);
        }

    }

    private void loadTable(List<Tables> tables) {
        dtm = (DefaultTableModel) this.jtMesas.getModel();
        tables.forEach((table) -> {
            dtm.addRow(new Object[]{table.getId(), table.getMaxPeople(), table.getEmpty()});
            System.out.println(table.getId() + "-" + table.getMaxPeople() + "-" + table.getEmpty());
        });
    }

    private void reset(){
        dtm.setRowCount(0);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtMesas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jbExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Mesa", "Max_Personas", "Vacia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtMesas);
        if (jtMesas.getColumnModel().getColumnCount() > 0) {
            jtMesas.getColumnModel().getColumn(0).setResizable(false);
            jtMesas.getColumnModel().getColumn(1).setResizable(false);
            jtMesas.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Mesas disponibles...");

        jbExit.setText("Salir");
        jbExit.setPreferredSize(new java.awt.Dimension(69, 23));
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExit;
    private javax.swing.JTable jtMesas;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JOptionPane genericPane;
}
