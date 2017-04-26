/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import controller.GeneralAPanelController;
import controller.LoginController;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 * @author TPVPARATODOS
 */
public final class Login extends JFrame {

    private Scanner teclat = new Scanner(System.in);

    private JFrame parent;
    private JPanel container;
    private JOptionPane errorContainer;
    private JLabel lbl_Username;
    private JLabel lbl_Password;
    protected JTextField tf_Username;
    protected JPasswordField pf_Password;
    protected JCheckBox cb_HidePassword;
    protected Button bt_Login;
    protected Button bt_Cancel;
    protected String generatedPassword = null;
    private LoginController loginController;
    private GeneralAPanelController gapc;

    public static String user = "Eduardo";
    public static String password = "Contrasenya123";

    public Login(JFrame parent) throws NoSuchAlgorithmException {
        this.parent = parent;
        initComponent();
        createItems2();
    }

    public Login() throws NoSuchAlgorithmException {
        initComponent();
        createItems();
        
        gapc = new GeneralAPanelController();
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) throws NoSuchAlgorithmException {
        this.loginController = loginController;

    }

    void initComponent() throws NoSuchAlgorithmException {
        container = new JPanel();
        errorContainer = new JOptionPane();
        lbl_Username = new JLabel("Nombre de Usuario:");
        lbl_Password = new JLabel("Contraseña:");
        tf_Username = new JTextField(15);
        pf_Password = new JPasswordField(15);
        cb_HidePassword = new JCheckBox("Mostrar contraseña");
        bt_Login = new Button("Ingresar");
        bt_Cancel = new Button("Cancelar");
    }

    void createItems() throws NoSuchAlgorithmException {
        setVisible(true);
        setBounds(100, 100, 425, 300);
        setTitle("Acceso a la Zona de administración");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(container);

        SpringLayout sp = new SpringLayout();

        container.setLayout(sp);

        container.add(lbl_Username);

        sp.putConstraint(SpringLayout.NORTH, lbl_Username, 50,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, lbl_Username, 50,
                SpringLayout.WEST, this);

        container.add(tf_Username);

        sp.putConstraint(SpringLayout.NORTH, tf_Username, 50,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, tf_Username, 175,
                SpringLayout.WEST, this);

        container.add(lbl_Password);

        sp.putConstraint(SpringLayout.NORTH, lbl_Password, 85,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, lbl_Password, 50,
                SpringLayout.WEST, this);

        container.add(pf_Password);

        sp.putConstraint(SpringLayout.NORTH, pf_Password, 85,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, pf_Password, 175,
                SpringLayout.WEST, this);

        container.add(cb_HidePassword);

        sp.putConstraint(SpringLayout.NORTH, cb_HidePassword, 110,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, cb_HidePassword, 250,
                SpringLayout.WEST, this);

        container.add(bt_Login);

        sp.putConstraint(SpringLayout.NORTH, bt_Login, 200,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, bt_Login, 250,
                SpringLayout.WEST, this);

        container.add(bt_Cancel);

        sp.putConstraint(SpringLayout.NORTH, bt_Cancel, 200,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, bt_Cancel, 100,
                SpringLayout.WEST, this);

        bt_Cancel.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        bt_Login.addActionListener((ActionEvent e) -> {
            boolean permit = false;
            try {
                //PRUEBA DE HASH
                String pass = "";
                System.out.println("Introduce password:");
                pass = teclat.next();

                if (comparePass(pass,gapc)) {
                    System.out.println("LOGIN!");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(errorContainer, "Usuario o contraseña erroneos!\nVuelva a intentarlo!",
                            "Login Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("USERNAME OR PASSWORD IS INCORRECT");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        cb_HidePassword.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() != ItemEvent.SELECTED) {
                pf_Password.setEchoChar('\u25cf');
            } else {
                pf_Password.setEchoChar((char) 0);
            }
        });

    }

    void createItems2() throws NoSuchAlgorithmException {
        setBounds(100, 100, 425, 300);
        setTitle("Acceso a la Zona de administración");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(container);

        SpringLayout sp = new SpringLayout();

        container.setLayout(sp);

        container.add(lbl_Username);

        sp.putConstraint(SpringLayout.NORTH, lbl_Username, 50,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, lbl_Username, 50,
                SpringLayout.WEST, this);

        container.add(tf_Username);

        sp.putConstraint(SpringLayout.NORTH, tf_Username, 50,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, tf_Username, 175,
                SpringLayout.WEST, this);

        container.add(lbl_Password);

        sp.putConstraint(SpringLayout.NORTH, lbl_Password, 85,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, lbl_Password, 50,
                SpringLayout.WEST, this);

        container.add(pf_Password);

        sp.putConstraint(SpringLayout.NORTH, pf_Password, 85,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, pf_Password, 175,
                SpringLayout.WEST, this);

        container.add(cb_HidePassword);

        sp.putConstraint(SpringLayout.NORTH, cb_HidePassword, 110,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, cb_HidePassword, 250,
                SpringLayout.WEST, this);

        container.add(bt_Login);

        sp.putConstraint(SpringLayout.NORTH, bt_Login, 200,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, bt_Login, 250,
                SpringLayout.WEST, this);

        container.add(bt_Cancel);

        sp.putConstraint(SpringLayout.NORTH, bt_Cancel, 200,
                SpringLayout.NORTH, this);
        sp.putConstraint(SpringLayout.WEST, bt_Cancel, 100,
                SpringLayout.WEST, this);

        bt_Cancel.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        bt_Login.addActionListener((ActionEvent e) -> {
            //ResultSet rs = Controller.getData(tf_Username.getText());
            boolean permit = false;

            try {
                if (comparePass(pf_Password.getText(), gapc)) {
                    System.out.println("LOGIN!");
                } else {
                    JOptionPane.showMessageDialog(errorContainer, "Usuario o contraseña erroneos!\nVuelva a intentarlo!",
                            "Login Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("USERNAME OR PASSWORD IS INCORRECT");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        cb_HidePassword.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() != ItemEvent.SELECTED) {
                pf_Password.setEchoChar('\u25cf');
            } else {
                pf_Password.setEchoChar((char) 0);
            }
        });

    }

    private boolean comparePass(String pass, GeneralAPanelController gapc) throws NoSuchAlgorithmException {
        boolean permit = false;

        // Create MessageDigest instance for MD5
        MessageDigest md2 = MessageDigest.getInstance("MD5");
        //Add password bytes to digest
        md2.update(pass.getBytes());
        //Get the hash's bytes 
        byte[] bytes2 = md2.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < bytes2.length; i++) {
            sb2.append(Integer.toString((bytes2[i] & 0xff) + 0x100, 16).substring(1));
        }

        String passHash = sb2.toString();

        String usrTF = tf_Username.getText();
        String pwdTF = pf_Password.getText();

        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Add password bytes to digest
        md.update(pwdTF.getBytes());
        //Get the hash's bytes 
        byte[] bytes = md.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        generatedPassword = sb.toString();

        System.out.println(generatedPassword);
        System.out.println(passHash);

        if (generatedPassword.equals(passHash)) {
            System.out.println(permit);
            this.setVisible(false);
            gapc.getGeneralAdmin_Panel().setVisible(true);
            permit = true;

        }
        return permit;
    }

}
