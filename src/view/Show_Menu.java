package view;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import controller.ShowMenu_Controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.pojo.Menus;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sakulambo
 */
public class Show_Menu extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private ShowMenu_Controller smc;
    private List<Menus> menus;

    public ShowMenu_Controller getSmc() {
        return smc;
    }

    public void setSmc(ShowMenu_Controller stc) {
        this.smc = stc;
    }

    public void jframVisible() {
        if (this.smc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            this.menus = this.smc.getController().getService().getMenusDAO().getMenuList();
            loadTable(menus);
            this.setVisible(true);
        }
    }

    private void loadTable(List<Menus> menus) {
        dtm = (DefaultTableModel) this.jtMenus.getModel();
        menus.forEach((menu) -> {
            dtm.addRow(new Object[]{menu.getId(), menu.getPeopleNumber()});
        });
    }

    private void reset() {
        dtm.setRowCount(0);
    }

    public Show_Menu() {
        super("Mostrar Menus");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtMenus = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbReports = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtMenus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Menu", "Max_Personas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtMenus);
        if (jtMenus.getColumnModel().getColumnCount() > 0) {
            jtMenus.getColumnModel().getColumn(0).setResizable(false);
            jtMenus.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mostrando menus...");

        jbReports.setText("Generar Reporte");
        jbReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbReports)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbReports))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
       reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportsActionPerformed
         this.smc.getController().getService().getReportDAO().setMenusList(this.smc.getController().getService().getMenusDAO().getMenuList());
        try {
            JasperPrint jp = this.smc.getController().getService().getReportDAO().getReportMenus();
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (ColumnBuilderException | JRException | ClassNotFoundException ex) {
            Logger.getLogger(Show_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbReportsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbReports;
    private javax.swing.JTable jtMenus;
    // End of variables declaration//GEN-END:variables
}
