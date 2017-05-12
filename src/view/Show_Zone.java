package view;

import ar.com.fdvs.dj.domain.builders.ColumnBuilderException;
import controller.ShowZone_Controller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.pojo.Zones;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author sakulambo
 */
public class Show_Zone extends javax.swing.JFrame {

    public ShowZone_Controller getSzc() {
        return szc;
    }

    public void setSzc(ShowZone_Controller szc) {
        this.szc = szc;
    }

    
    public Show_Zone() {
        super("Mostrar Zonas");
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtZones = new javax.swing.JTable();
        jbExit = new javax.swing.JButton();
        jbReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mostrando zonas...");

        jtZones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Localización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtZones);
        if (jtZones.getColumnModel().getColumnCount() > 0) {
            jtZones.getColumnModel().getColumn(1).setResizable(false);
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
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbReport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbExit)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbReport)
                    .addComponent(jbExit))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbExitActionPerformed

    private void jbReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbReportActionPerformed
        this.szc.getController().getService().getReportDAO().setZonesList(this.szc.getController().getService().getZonesDAO().getZoneList());
        try {
            JasperPrint jp = this.szc.getController().getService().getReportDAO().getReportZones();
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (ColumnBuilderException | JRException | ClassNotFoundException ex) {
            Logger.getLogger(Show_Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbReportActionPerformed

    
    public void jframeVisible(){
         if (this.szc.getController().getGapc().getGeneralAdmin_Panel().isVisible()) {
            this.zones = this.szc.getController().getService().getZonesDAO().getZoneList();
            loadTable(zones);
            this.setVisible(true);
        }
    }
    
      private void loadTable(List<Zones> zones) {
        dtm = (DefaultTableModel) this.jtZones.getModel();
        zones.forEach((zone) -> {
            dtm.addRow(new Object[]{zone.getId(),zone.getLocation()});
        });
    }
    
    
    private void reset(){
        this.dtm.setRowCount(0);
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbReport;
    private javax.swing.JTable jtZones;
    // End of variables declaration//GEN-END:variables
private ShowZone_Controller szc;
private DefaultTableModel dtm;
private List<Zones> zones;
}
