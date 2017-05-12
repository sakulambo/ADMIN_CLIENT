/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Login_Controller;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
    private Login_Controller loginController;
    private String urlParameters;

//    public static String user = "Eduardo";
//    public static String password = "Contrasenya123";
    public Login(JFrame parent) throws NoSuchAlgorithmException {
        super("Login");
        this.parent = parent;
        initComponent();
        createItems2();
    }

    public Login() throws NoSuchAlgorithmException {
        super("Login");
        initComponent();
        createItems();
    }

    public Login_Controller getLoginController() {
        return loginController;
    }

    public void setLoginController(Login_Controller loginController) throws NoSuchAlgorithmException {
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
//            try {
//                urlParameters = "grant_type=password&username=" + URLEncoder.encode(tf_Username.getText(), "UTF-8") + "&password=" + URLEncoder.encode(pf_Password.getText(), "UTF-8");
//            } catch (UnsupportedEncodingException ex) {
//                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (connectionTest(urlParameters)) {
//                System.out.println("LOGIN!");
            this.dispose();
            this.loginController.getController().getGapc().getGeneralAdmin_Panel().setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(errorContainer, "Usuario o contraseña erroneos!\nVuelva a intentarlo!",
//                        "Login Error", JOptionPane.ERROR_MESSAGE);
//                System.out.println("USERNAME OR PASSWORD IS INCORRECT");
//            }

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

            //VERSIO x-www-form-urlencoded
            try {
                urlParameters = "grant_type=password&username=" + URLEncoder.encode(tf_Username.getText(), "UTF-8") + "&password=" + URLEncoder.encode(pf_Password.getText(), "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (connectionTest(urlParameters)) {
                System.out.println("LOGIN!");
                this.dispose();
                this.loginController.getController().getGapc().getGeneralAdmin_Panel().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(errorContainer, "Usuario o contraseña erroneos!\nVuelva a intentarlo!",
                        "Login Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("USERNAME OR PASSWORD IS INCORRECT");
            }

            /*try {
                if (comparePass(pf_Password.getText())) {
                    System.out.println("LOGIN!");
                } else {
                    JOptionPane.showMessageDialog(errorContainer, "Usuario o contraseña erroneos!\nVuelva a intentarlo!",
                            "Login Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("USERNAME OR PASSWORD IS INCORRECT");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        });

        cb_HidePassword.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() != ItemEvent.SELECTED) {
                pf_Password.setEchoChar('\u25cf');
            } else {
                pf_Password.setEchoChar((char) 0);
            }
        });

    }

    /* private boolean comparePass(String pass) throws NoSuchAlgorithmException {
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

        // String usrTF = tf_Username.getText();
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
            permit = true;
            System.out.println(permit);
            this.setVisible(false);
        }
        return permit;
    }
     */
    private boolean connectionTest(String urlParameters) {
        boolean permit = false;
        try {
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            String request = "http://172.16.100.19/TPVParaTodos";
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);

                if (conn.getResponseCode() == 200) {
                    permit = true;
                    this.setVisible(false);
                }

            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        return permit;
    }
}
