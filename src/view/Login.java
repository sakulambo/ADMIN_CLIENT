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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
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
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
    private OkHttpClient client;
    private RequestBody body;
    private Request request;
    private MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
    private Response response;

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
            try {
                if (tf_Username.getText() == null || pf_Password.getText() == null) {
                    JOptionPane.showMessageDialog(errorContainer, "Usuario y/o contraseña vacíos!");
                } else {
                    if (connectionTest(tf_Username.getText(), pf_Password.getText())) {
                        this.dispose();
                        this.loginController.getController().getGapc().getGeneralAdmin_Panel().setVisible(true);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        );

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
                Logger.getLogger(Login.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (connectionTest(tf_Username.getText(), pf_Password.getText())) {
                    this.dispose();
                    this.loginController.getController().getGapc().getGeneralAdmin_Panel().setVisible(true);
                }
            } catch (IOException ex) {
                Logger.getLogger(Login.class
                        .getName()).log(Level.SEVERE, null, ex);
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

    //ACTUALMENTE TESTEANDO PARA CONNEXIÓN!
    private boolean connectionTest(String user, String pass) throws IOException {
        boolean permit = false;

        client = new OkHttpClient();
        String bodyOptions = "grant_type=password&username=" + user + "&password=" + pass;

        body = RequestBody.create(mediaType, bodyOptions);

        Call call = client.newCall(new Request.Builder()
                .post(body)
                .url("http://172.16.100.19/TPVParaTodos/token")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .build());
        Response res = call.execute();
        if (!res.isSuccessful()) {
            JOptionPane.showMessageDialog(errorContainer, "Usuario o contraseña erroneos!\nVuelva a intentarlo!",
                    "Login Error", JOptionPane.ERROR_MESSAGE);
            permit = false;
        } else {
            JOptionPane.showMessageDialog(errorContainer, "Bienvenido " + tf_Username.getText(),
                    "Succesfull", JOptionPane.INFORMATION_MESSAGE);
            permit = true;
        }

        return permit;
    }

}
