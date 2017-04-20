/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author sakulambo
 */
public class General_APanel extends JFrame {

    private Login lg;
    private JMenu jMenu1;
    private JMenu jmExit;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JMenu jMenu7;
    private JMenu jMenu8;
    private JMenuBar jmbMainBar;
    private JMenuItem showTablesMenuItem;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem aboutUsOption;
    private JMenuItem exitOption;
    private JMenuItem jMenuItem15;
    private JMenuItem jMenuItem16;
    private JMenuItem jMenuItem17;
    private JMenuItem jMenuItem9;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem10;
    private JMenuItem addFood;
    private JMenuItem jMenuItem12;
    private JMenuItem jMenuItem13;
    private JMenuItem jMenuItem14;
    private JOptionPane alertPane;
  

    public General_APanel() throws NoSuchAlgorithmException {
        initComponents();
    }

    private void initComponents() throws NoSuchAlgorithmException {
        jmbMainBar = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        showTablesMenuItem = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        addFood = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jmExit = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        aboutUsOption = new javax.swing.JMenuItem();
        exitOption = new javax.swing.JMenuItem();
        alertPane = new JOptionPane();
        lg = new Login(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu4.setText("Facturación");

        jMenuItem3.setText("Facturar mes...");
        jMenu4.add(jMenuItem3);

        jMenuItem8.setText("Facturar año");
        jMenu4.add(jMenuItem8);

        jmbMainBar.add(jMenu4);

        jMenu8.setText("Personal");

        jMenuItem16.setText("Alta personal");
        jMenu8.add(jMenuItem16);

        jMenuItem15.setText("Ver personal");
        jMenu8.add(jMenuItem15);

        jMenuItem17.setText("Baja Personal");
        jMenu8.add(jMenuItem17);

        jmbMainBar.add(jMenu8);

        jMenu5.setText("Mesas");

        jMenuItem4.setText("Asignar mesa");
        jMenu5.add(jMenuItem4);

        showTablesMenuItem.setText("Mostrar mesas");
        showTablesMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

            }
        });
        jMenu5.add(showTablesMenuItem);

        jmbMainBar.add(jMenu5);

        jMenu1.setText("Menu");

        jMenuItem9.setText("Mostrar menus");
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Añadir producto a menu");
        jMenu1.add(jMenuItem10);

        jmbMainBar.add(jMenu1);

        jMenu7.setText("Alimentos");

        addFood.setText("Añadir comida");
        addFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_Food af = new Add_Food();
                af.setVisible(true);
            }
        });
        jMenu7.add(addFood);

        jMenuItem13.setText("Eliminar comida");
        jMenu7.add(jMenuItem13);

        jMenuItem12.setText("Añadir bebida");
        jMenu7.add(jMenuItem12);

        jMenuItem14.setText("Eliminar bebida");
        jMenu7.add(jMenuItem14);

        jmbMainBar.add(jMenu7);

        jmExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jmExit.setLabel("Opciones");
        jmExit.setRolloverEnabled(false);
        jmExit.setVerifyInputWhenFocusTarget(false);

        jMenuItem5.setText("Ayuda");
        jmExit.add(jMenuItem5);

        aboutUsOption.setText("Sobre TPV...");
        jmExit.add(aboutUsOption);
        aboutUsOption.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(alertPane, "Un producto de TPVParaTodos ®\n"
                    + "Creado por: \n"
                    + "Joshua Orellana, Gerson Ramirez,\n"
                    + "Roberto Navarro y Kevin Garcia",
                    "Login Error", JOptionPane.INFORMATION_MESSAGE);
        });

        exitOption.setText("Salir");
        jmExit.add(exitOption);
        exitOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitClicked(evt);
            }
        });

        jmbMainBar.add(jmExit);

        setJMenuBar(jmbMainBar);

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
    }

    private void exitClicked(java.awt.event.MouseEvent evt) {
        try {
            this.setVisible(false);
            lg.setVisible(true);

        } catch (Throwable ex) {
            Logger.getLogger(General_APanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
