/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.gson.Gson;
import controller.AddProductController;
import controller.DeleteProductController;
import controller.GeneralAPanelController;
import controller.LoginController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sakulambo
 */
public class General_APanel extends JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmFacturacion;
    private javax.swing.JMenu jmMenus;
    private javax.swing.JMenu jmMesas;
    private javax.swing.JMenu jmOpciones;
    private javax.swing.JMenu jmPersonal;
    private javax.swing.JMenu jmProductos;
    private javax.swing.JMenuItem jmiAboutUs;
    private javax.swing.JMenuItem jmiAltaPersonal;
    private javax.swing.JMenuItem jmiAnadirProducto;
    private javax.swing.JMenuItem jmiAnadirProductoMenu;
    private javax.swing.JMenuItem jmiAyuda;
    private javax.swing.JMenuItem jmiBajaPersonal;
    private javax.swing.JMenuItem jmiCrearMesa;
    private javax.swing.JMenuItem jmiEliminarMesa;
    private javax.swing.JMenuItem jmiEliminarProducto;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiFacturarAno;
    private javax.swing.JMenuItem jmiFacturarMes;
    private javax.swing.JMenuItem jmiMostrarMenu;
    private javax.swing.JMenuItem jmiMostrarMesas;
    private javax.swing.JMenuItem jmiVerPersonal;
    private javax.swing.JOptionPane genericpane;
    private LoginController lc;
    private GeneralAPanelController apc;

    public General_APanel() throws NoSuchAlgorithmException {
        initComponents();

    }

    public GeneralAPanelController getApc() {
        return apc;
    }

    public void setApc(GeneralAPanelController apc) {
        this.apc = apc;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFacturacion = new javax.swing.JMenu();
        jmiFacturarMes = new javax.swing.JMenuItem();
        jmiFacturarAno = new javax.swing.JMenuItem();
        jmPersonal = new javax.swing.JMenu();
        jmiAltaPersonal = new javax.swing.JMenuItem();
        jmiVerPersonal = new javax.swing.JMenuItem();
        jmiBajaPersonal = new javax.swing.JMenuItem();
        jmMesas = new javax.swing.JMenu();
        jmiCrearMesa = new javax.swing.JMenuItem();
        jmiMostrarMesas = new javax.swing.JMenuItem();
        jmiEliminarMesa = new javax.swing.JMenuItem();
        jmMenus = new javax.swing.JMenu();
        jmiMostrarMenu = new javax.swing.JMenuItem();
        jmiAnadirProductoMenu = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenu();
        jmiAnadirProducto = new javax.swing.JMenuItem();
        jmiEliminarProducto = new javax.swing.JMenuItem();
        jmOpciones = new javax.swing.JMenu();
        jmiAyuda = new javax.swing.JMenuItem();
        jmiAboutUs = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jmFacturacion.setText("Facturación");

        jmiFacturarMes.setText("Facturar mes");
        jmiFacturarMes.addActionListener(this::jmiFacturarMesActionPerformed);
        jmFacturacion.add(jmiFacturarMes);

        jmiFacturarAno.setText("Facturar año");
        jmFacturacion.add(jmiFacturarAno);

        jMenuBar1.add(jmFacturacion);

        jmPersonal.setText("Personal");

        jmiAltaPersonal.setText("Alta personal");
        jmPersonal.add(jmiAltaPersonal);

        jmiVerPersonal.setText("Ver personal");
        jmPersonal.add(jmiVerPersonal);

        jmiBajaPersonal.setText("Baja Personal");
        jmPersonal.add(jmiBajaPersonal);

        jMenuBar1.add(jmPersonal);

        jmMesas.setText("Mesas");

        jmiCrearMesa.setText("Crear mesa");
        jmMesas.add(jmiCrearMesa);

        jmiMostrarMesas.setText("Mostrar mesas");
        jmiMostrarMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmiMostrarMesasMouseClicked(evt);
            }
        });
        jmMesas.add(jmiMostrarMesas);

        jmiEliminarMesa.setText("Eliminar mesa");
        jmMesas.add(jmiEliminarMesa);

        jMenuBar1.add(jmMesas);

        jmMenus.setText("Menu");

        jmiMostrarMenu.setText("Mostrar menus");
        jmMenus.add(jmiMostrarMenu);

        jmiAnadirProductoMenu.setText("Añadir producto a menu");
        jmMenus.add(jmiAnadirProductoMenu);

        jMenuBar1.add(jmMenus);

        jmProductos.setText("Productos");

        jmiAnadirProducto.setText("Añadir producto");
        jmiAnadirProducto.addActionListener((ActionEvent e) -> {
           this.apc.getController().getApc().getAddProduct().setVisible(true);
        });
        jmProductos.add(jmiAnadirProducto);

        jmiEliminarProducto.setText("Eliminar producto");
        jmiEliminarProducto.addActionListener((ActionEvent e) -> {
           this.apc.getController().getDpc().getDeleteProduct().setVisible(true);
        });
        jmProductos.add(jmiEliminarProducto);

        jMenuBar1.add(jmProductos);

        jmOpciones.setText("Opciones");
        jmOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jmOpciones.setRolloverEnabled(false);
        jmOpciones.setVerifyInputWhenFocusTarget(false);

        jmiAyuda.setText("Ayuda");
        jmOpciones.add(jmiAyuda);

        jmiAboutUs.setText("Sobre TPV...");
        jmiAboutUs.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(genericpane, "Un producto de TPVParaTodos ®\n"
                    + "Creado por: \n"
                    + "Joshua Orellana, Gerson Ramirez,\n"
                    + "Roberto Navarro y Kevin Garcia",
                    "Login Error", JOptionPane.INFORMATION_MESSAGE);
        });        
        jmOpciones.add(jmiAboutUs);

        jmiExit.setText("Salir");
        jmiExit.addActionListener((ActionEvent e) -> {
           this.exitClicked(e);
        });
        jmOpciones.add(jmiExit);

        jMenuBar1.add(jmOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 472, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 284, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jmiMostrarMesasMouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jmiFacturarMesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }   

    public static void connection() throws SQLException, ClassNotFoundException, IOException {
        Gson gson = new Gson();
        Connection con = null;
        String URL = "jdbc:sqlserver://tpvparatodos.database.windows.net;databaseName=TPVParaTodos";
        String user = "Eduardo";
        String pwd = "Contrasenya123";
        String query = "SELECT * FROM Tables";
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(URL, user, pwd);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);

//
//        String aux = " ";
//        String output;
//        System.out.println("Output from Server .... \n");
//        while ((output = rs.readLine()) != null) {
//            aux += output;
//
//        }
//        ArrayList<Table> tables = TableDAO2.getTableList();
//
//        tables = gson.fromJson(" ", new TypeToken<ArrayList<Contacte>>() {
//        }.getType());
//        DefaultTableModel model = (DefaultTableModel) jtContacte.getModel();
//        Object[] row = new Object[4];
//        for (int i = 0; i < tables.size(); i++) {
//            row[0] = tables.get(i).getId();
//            row[1] = tables.get(i).getMaxPeople();
//            row[2] = tables.get(i).getZone_Id();
//            if (tables.isEmpty()) {
//                row[3] = "1";
//            } else {
//                row[3] = "0";
//            }
//            model.addRow(row);
//        }
        con.close();

    }

    private void exitClicked(ActionEvent e) {
        try {
            this.dispose();
            this.apc.getController().getLc().getLogin().setVisible(true);

        } catch (Throwable ex) {
            Logger.getLogger(General_APanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
