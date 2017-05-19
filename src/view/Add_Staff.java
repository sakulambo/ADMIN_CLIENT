/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AddStaff_Controller;
import java.awt.event.ItemEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import sun.net.www.http.HttpClient;

/**
 *
 * @author sakulambo
 */
public class Add_Staff extends javax.swing.JFrame {

    public Add_Staff() {
        super("Añadir Personal");
        initComponents();
    }

    public AddStaff_Controller getAsc() {
        return asc;
    }

    public void setAsc(AddStaff_Controller asc) {
        this.asc = asc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUser = new javax.swing.JTextField();
        jbAccept = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfPhone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfAddres = new javax.swing.JTextField();
        jtfSurname = new javax.swing.JTextField();
        jtfName = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        jtfPassword2 = new javax.swing.JPasswordField();
        cb_Password = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel3.setText("Contraseña");

        jbAccept.setText("Aceptar");
        jbAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcceptActionPerformed(evt);
            }
        });

        jbCancel.setText("Cancelar");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Confirmar contraseña");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PERSONALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel4.setText("Telefono");

        jLabel7.setText("Apellido");

        jLabel8.setText("Dirección");

        jLabel6.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jtfPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfSurname)
                                    .addComponent(jtfName)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtfAddres)))
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtfAddres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setText("Email");

        cb_Password.setText("Mostrar contraseñas");
        cb_Password.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_PasswordItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jtfUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfPassword)
                            .addComponent(jtfPassword2)))
                    .addComponent(cb_Password)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAccept)
                .addGap(34, 34, 34)
                .addComponent(jbCancel)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(cb_Password)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancel)
                    .addComponent(jbAccept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcceptActionPerformed

        user = this.jtfUser.getText();
        password = this.jtfPassword.getText();
        password2 = this.jtfPassword2.getText();
        email = this.jtfEmail.getText();
        name = this.jtfName.getText();
        surname = this.jtfSurname.getText();
        address = this.jtfAddres.getText();
        phone = this.jtfPhone.getText();
       
        if (!password.equals(password2)) {
            JOptionPane.showMessageDialog(genericPane, "Las dos contraseñas deben coincidir!");
        } else {
            try {
                postStaff(user, password, password2, email, name, surname, address, phone);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jbAcceptActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void cb_PasswordItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_PasswordItemStateChanged
        if (evt.getStateChange() != ItemEvent.SELECTED) {
            jtfPassword.setEchoChar('\u25cf');
            jtfPassword2.setEchoChar('\u25cf');
        } else {
            jtfPassword.setEchoChar((char) 0);
            jtfPassword2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_cb_PasswordItemStateChanged

    private void reset() {
        this.jtfUser.setText("");
        this.jtfPassword.setText("");
        this.jtfPassword2.setText("");
        this.jtfEmail.setText("");
        this.jtfName.setText("");
        this.jtfSurname.setText("");
        this.jtfAddres.setText("");
        this.jtfPhone.setText("");

    }

    private void postStaff(String user, String pass1, String pass2, String email, String name, String surname, String address, String phone) throws IOException, JSONException {

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("Username", user);
        jsonParam.put("Email", email);
        jsonParam.put("Password", pass1);
        jsonParam.put("ConfirmPassword", pass2);
        jsonParam.put("FirstName", name);
        jsonParam.put("LastName", surname);
        jsonParam.put("Address", address);
        jsonParam.put("Phone", phone);

        String jsonString = jsonParam.toString();
        RequestBody body = RequestBody.create(JSON, jsonString);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .post(body)
                .url("http://172.16.100.19/TPVParaTodos/api/Account/Register")
                .addHeader("content-type", "application/json; charset=utf-8")
                .build();

        Response res = client.newCall(request).execute();

        System.out.println();

        if (!res.isSuccessful()) {
            JOptionPane.showMessageDialog(genericPane, "Error:\n" + res.body().string(),
                    "Login Error", JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(genericPane, "Usuario añadido correctamente");

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cb_Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAccept;
    private javax.swing.JButton jbCancel;
    private javax.swing.JTextField jtfAddres;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfName;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JPasswordField jtfPassword2;
    private javax.swing.JTextField jtfPhone;
    private javax.swing.JTextField jtfSurname;
    private javax.swing.JTextField jtfUser;
    // End of variables declaration//GEN-END:variables
    private String user, password, password2, email, name, surname, phone, address;
    private AddStaff_Controller asc;
    private JOptionPane genericPane;
    private static final MediaType JSON = MediaType.parse("application/json");
}
