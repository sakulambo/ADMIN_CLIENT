/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.gson.Gson;
import controller.GeneralAPanel_Controller;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import static org.hsqldb.HsqlDateTime.e;

/**
 *
 * @author sakulambo
 */
public class General_APanel extends JFrame {

    // Variables declaration - do not modify  
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jmMainBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jmFacturacion;
    private javax.swing.JMenu jmMenus;
    private javax.swing.JMenu jmComandas;
    private javax.swing.JMenu jmMesas;
    private javax.swing.JMenu jmOpciones;
    private javax.swing.JMenu jmPersonal;
    private javax.swing.JMenu jmProductos;
    private javax.swing.JMenu jmZones;
    private javax.swing.JMenuItem jmiAboutUs;
    private javax.swing.JMenuItem jmiAnadirProducto;
    private javax.swing.JMenuItem jmiAnadirProductoMenu;
    private javax.swing.JMenuItem jmiAyuda;
    private javax.swing.JMenuItem jmiCrearMesa;
    private javax.swing.JMenuItem jmiModificarComida;
    private javax.swing.JMenuItem jmiModificarBebida;
    private javax.swing.JMenuItem jmiEliminarProducto;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiFacturarAno;
    private javax.swing.JMenuItem jmiFacturarMes;
    private javax.swing.JMenuItem jmiMostrarMenu;
    private javax.swing.JMenuItem jmiMostrarMesas;
    private javax.swing.JMenuItem jmiVerPersonal;
    private javax.swing.JMenuItem jmiSeeOrders;
    private javax.swing.JMenuItem jmiSeeZones;
    private javax.swing.JMenuItem jmiAddZones;
    private javax.swing.JOptionPane genericpane;
    private GeneralAPanel_Controller apc;

    public General_APanel() throws NoSuchAlgorithmException {
        initComponents();

    }

    public GeneralAPanel_Controller getApc() {
        return apc;
    }

    public void setApc(GeneralAPanel_Controller apc) {
        this.apc = apc;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir? ", "Salir", JOptionPane.YES_NO_OPTION);
                if(reply == genericpane.YES_OPTION){
                    System.exit(0);
                }
               
            }

        });

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jmMainBar = new javax.swing.JMenuBar();
        jmFacturacion = new javax.swing.JMenu();
        jmiFacturarMes = new javax.swing.JMenuItem();
        jmiFacturarAno = new javax.swing.JMenuItem();
        jmPersonal = new javax.swing.JMenu();
        jmiVerPersonal = new javax.swing.JMenuItem();
        jmMesas = new javax.swing.JMenu();
        jmiCrearMesa = new javax.swing.JMenuItem();
        jmiMostrarMesas = new javax.swing.JMenuItem();
        jmMenus = new javax.swing.JMenu();
        jmiMostrarMenu = new javax.swing.JMenuItem();
        jmiAnadirProductoMenu = new javax.swing.JMenuItem();
        jmComandas = new javax.swing.JMenu();
        jmiSeeOrders = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenu();
        jmiAnadirProducto = new javax.swing.JMenuItem();
        jmiModificarComida = new javax.swing.JMenuItem();
        jmiModificarBebida = new javax.swing.JMenuItem();
        jmiEliminarProducto = new javax.swing.JMenuItem();
        jmZones = new javax.swing.JMenu();
        jmiSeeZones = new javax.swing.JMenuItem();
        jmiAddZones = new javax.swing.JMenuItem();
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

        jmMainBar.add(jmFacturacion);

        jmPersonal.setText("Personal");

        jmiVerPersonal.setText("Ver personal");
        jmiVerPersonal.addActionListener((ActionEvent ae) -> {
            this.apc.getController().getSsc().getShowStaff().jframVisible();
        });
        jmPersonal.add(jmiVerPersonal);

        jmMainBar.add(jmPersonal);

        jmMesas.setText("Mesas");

        jmiCrearMesa.setText("Crear mesa");
        jmiCrearMesa.addActionListener((ActionEvent ae) -> {
            this.apc.getController().getAtc().getAt().setVisible(true);
        });
        jmMesas.add(jmiCrearMesa);

        jmiMostrarMesas.setText("Mostrar mesas");
        jmiMostrarMesas.addActionListener((ActionEvent ae) -> {
            this.apc.getController().getStc().getShowTables().jframeVisible();
        });

        jmMesas.add(jmiMostrarMesas);

        jmMainBar.add(jmMesas);

        jmMenus.setText("Menu");
        jmiMostrarMenu.setText("Mostrar menus");
        jmiMostrarMenu.addActionListener((ActionEvent ae) -> {
            this.apc.getController().getSmc().getShowMenus().jframVisible();
        });
        jmMenus.add(jmiMostrarMenu);
        jmiAnadirProductoMenu.setText("Añadir producto a menu");
        jmMenus.add(jmiAnadirProductoMenu);
        jmMainBar.add(jmMenus);

        //Orders
        jmComandas.setText("Comandas");
        jmiSeeOrders.setText("Ver Comandas");
        jmiSeeOrders.addActionListener((ActionEvent ae) -> {
            this.apc.getController().getSoc().getShowOrders().jframeVisible();
        });
        jmComandas.add(jmiSeeOrders);
        jmMainBar.add(jmComandas);

        jmProductos.setText("Productos");

        jmiAnadirProducto.setText("Añadir producto");
        jmiAnadirProducto.addActionListener((ActionEvent ap) -> {
            this.apc.getController().getApc().getAddProduct().setVisible(true);
        });
        jmProductos.add(jmiAnadirProducto);

        jmiModificarComida.setText("Ver comida");
        jmiModificarComida.addActionListener((ActionEvent ep) -> {
            this.apc.getController().getDpc().getMf().jframeVisible();
        });
        jmProductos.add(jmiModificarComida);

        jmiModificarBebida.setText("Ver bebida");
        jmiModificarBebida.addActionListener((ActionEvent ep) -> {
            this.apc.getController().getMdc().getMd().jframeVisible();
        });
        jmProductos.add(jmiModificarBebida);

        jmiEliminarProducto.setText("Eliminar producto");
        jmiEliminarProducto.addActionListener((ActionEvent ep) -> {
            this.apc.getController().getMdc().getMd().jframeVisible();
        });
        jmProductos.add(jmiModificarBebida);

        jmMainBar.add(jmProductos);

        jmZones.setText("Zonas");
        jmiSeeZones.setText("Mostrar Zonas");
        jmiSeeZones.addActionListener((ActionEvent ep) -> {
            this.apc.getController().getSzc().getShowZone().jframeVisible();
        });

        jmZones.add(jmiSeeZones);
        jmiAddZones.setText("Añadir nueva zona");
        jmiAddZones.addActionListener((ActionEvent ep) -> {
            this.apc.getController().getAzc().getAddZone().setVisible(true);
        });
        jmZones.add(jmiAddZones);

        jmMainBar.add(jmZones);

        jmOpciones.setText("Opciones");
        jmOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jmOpciones.setRolloverEnabled(false);
        jmOpciones.setVerifyInputWhenFocusTarget(false);

        jmiAyuda.setText("Ayuda");
        jmiAyuda.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(genericpane, "Para obtener ayuda, contacte con\n"
                    + "su administrador o pague la tarifa Premium!",
                    "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        });

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

        jmMainBar.add(jmOpciones);

        setJMenuBar(jmMainBar);

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
