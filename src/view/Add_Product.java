/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AddProduct_Controller;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.dao.AbstractDAO;
import model.pojo.Drinks;
import model.pojo.Foods;
import model.pojo.Products;
import org.hibernate.HibernateException;

/**
 *
 * @author sakulambo
 */
public class Add_Product extends javax.swing.JFrame {

    public AddProduct_Controller getAddProductController() {
        return apc;
    }

    public void setAddProductController(AddProduct_Controller addProductController) {
        this.apc = addProductController;
    }

    public Add_Product() {
        initComponents();
        hideOptionalItems();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCategoria = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfProductName = new javax.swing.JTextField();
        jtfProductPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jlFoodImage = new javax.swing.JLabel();
        jbSearchImage = new javax.swing.JButton();
        jbAccept = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jrbComida = new javax.swing.JRadioButton();
        jrbBebida = new javax.swing.JRadioButton();
        jlCategoria = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jpFood = new javax.swing.JPanel();
        jcbFamilyDish = new javax.swing.JComboBox<>();
        jlFamilyDish = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        jpDrink = new javax.swing.JPanel();
        jlCapacity = new javax.swing.JLabel();
        jlTypeBottle = new javax.swing.JLabel();
        jlSoda = new javax.swing.JLabel();
        jlAlcohol = new javax.swing.JLabel();
        jtfCapacity = new javax.swing.JTextField();
        jtfTypeBottle = new javax.swing.JTextField();
        jcbSoda = new javax.swing.JComboBox<>();
        jcbAlcohol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setText("Comentarios");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMinimumSize(new java.awt.Dimension(4, 32));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio");

        jLabel7.setText("Selecciona una imagen...");

        jlFoodImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbSearchImage.setText("Buscar...");
        jbSearchImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchImageActionPerformed(evt);
            }
        });

        jbAccept.setText("Aceptar");
        jbAccept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAcceptMouseClicked(evt);
            }
        });

        jbCancel.setText("Cancelar");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");

        bgCategoria.add(jrbComida);
        jrbComida.setText("Comida");
        jrbComida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbComidaActionPerformed(evt);
            }
        });

        bgCategoria.add(jrbBebida);
        jrbBebida.setText("Bebida");
        jrbBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBebidaActionPerformed(evt);
            }
        });

        jlCategoria.setText("Categoria");

        jpFood.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de Comida"));

        jcbFamilyDish.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrante", "Primero", "Segundo", "Postre" }));

        jlFamilyDish.setText("Categoria principal");

        javax.swing.GroupLayout jpFoodLayout = new javax.swing.GroupLayout(jpFood);
        jpFood.setLayout(jpFoodLayout);
        jpFoodLayout.setHorizontalGroup(
            jpFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFoodLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlFamilyDish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbFamilyDish, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFoodLayout.setVerticalGroup(
            jpFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFoodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFamilyDish)
                    .addComponent(jcbFamilyDish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jpDrink.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de Bebida"));

        jlCapacity.setText("Capacidad(ml)");

        jlTypeBottle.setText("Tipo de envase");

        jlSoda.setText("Bebida azucarada");

        jlAlcohol.setText("Bebida alcoholica");

        jcbSoda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jcbAlcohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        javax.swing.GroupLayout jpDrinkLayout = new javax.swing.GroupLayout(jpDrink);
        jpDrink.setLayout(jpDrinkLayout);
        jpDrinkLayout.setHorizontalGroup(
            jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDrinkLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCapacity)
                    .addGroup(jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfTypeBottle)
                        .addComponent(jtfCapacity, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlTypeBottle, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(18, 18, 18)
                .addGroup(jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSoda)
                    .addGroup(jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jcbAlcohol, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbSoda, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlAlcohol, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jpDrinkLayout.setVerticalGroup(
            jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDrinkLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jpDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDrinkLayout.createSequentialGroup()
                        .addComponent(jlSoda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlAlcohol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpDrinkLayout.createSequentialGroup()
                        .addComponent(jlCapacity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlTypeBottle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTypeBottle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jlCategoria))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrbComida)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel2)))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfProductName)
                                    .addComponent(jtfProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(173, 173, 173)
                        .addComponent(jrbBebida)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSearchImage)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar))
                    .addComponent(jlFoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbAccept)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancel)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbComida)
                    .addComponent(jrbBebida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlFoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbSearchImage)
                            .addComponent(jbEliminar))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAccept)
                            .addComponent(jbCancel))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSearchImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png");
        chooser.addChoosableFileFilter(filter);
        int result = chooser.showSaveDialog(Add_Product.this);
        //if the user click on save in Jfilechooser
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jlFoodImage.setIcon(ResizeImage(path));
        } //if the user click on save in Jfilechooser
        else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No File Select");
        }

    }//GEN-LAST:event_jbSearchImageActionPerformed

    private void jbAcceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAcceptMouseClicked
        name = jtfProductName.getText();
        commentary = jTextArea1.getText();
        price = Double.valueOf(jtfProductPrice.getText()); 
        try {           
            if (jrbBebida.isSelected()) {
                capacity = Integer.valueOf(jtfCapacity.getText());
                soda = jcbSoda.getSelectedItem().equals("Si");
                alcohol = jcbAlcohol.getSelectedItem().equals("Si");
               AbstractDAO.almacenaEntidad(new Drinks(capacity, name, soda, alcohol, name, price, commentary));
               JOptionPane.showMessageDialog(rootPane, "Bebida añadida correctamente!");
            } else if (jrbComida.isSelected()) {
                familyDish = jcbFamilyDish.getSelectedItem().toString();
                 AbstractDAO.almacenaEntidad(new Foods(familyDish, name, price, commentary));
                 JOptionPane.showMessageDialog(rootPane, "Comida añadida correctamente!");
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(rootPane, e);
            System.out.println(e);
        }

    }//GEN-LAST:event_jbAcceptMouseClicked


    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        this.dispose();
        reset();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jrbComidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbComidaActionPerformed
        if (jrbComida.isSelected()) {
            hideOptionalItems();
            showFoodOptions();
        }
    }//GEN-LAST:event_jrbComidaActionPerformed

    private void jrbBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBebidaActionPerformed
        if (jrbBebida.isSelected()) {
            hideOptionalItems();
            showDrinkOptions();
        }
    }//GEN-LAST:event_jrbBebidaActionPerformed

    private void showDrinkOptions() {
        this.jpDrink.setVisible(true);
        this.jlAlcohol.setVisible(true);
        this.jcbAlcohol.setVisible(true);
        this.jlSoda.setVisible(true);
        this.jcbSoda.setVisible(true);
        this.jlTypeBottle.setVisible(true);
        this.jtfTypeBottle.setVisible(true);
        this.jlCapacity.setVisible(true);
        this.jtfCapacity.setVisible(true);
    }

    private void showFoodOptions() {
        this.jpFood.setVisible(true);
        this.jlFamilyDish.setVisible(true);
        this.jcbFamilyDish.setVisible(true);
    }

    private void hideOptionalItems() {
        this.jpFood.setVisible(false);
        this.jlFamilyDish.setVisible(false);
        this.jcbFamilyDish.setVisible(false);
        this.jpDrink.setVisible(false);
        this.jlAlcohol.setVisible(false);
        this.jcbAlcohol.setVisible(false);
        this.jlSoda.setVisible(false);
        this.jcbSoda.setVisible(false);
        this.jlTypeBottle.setVisible(false);
        this.jtfTypeBottle.setVisible(false);
        this.jlCapacity.setVisible(false);
        this.jtfCapacity.setVisible(false);
    }

    private void reset() {
        this.jtfCapacity.setText("");
        this.jtfTypeBottle.setText("");
        this.jtfProductName.setText("");
        this.jTextArea1.setText("");
        this.jtfProductPrice.setText("");
        hideOptionalItems();
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(jlFoodImage.getWidth(), jlFoodImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /* public void saveImage() throws IOException {
        File file = new File("src/model/images/" + jtfProductID.getText());
        ImageIcon imageI = (ImageIcon) jlFoodImage.getIcon();
        Image image = imageI.getImage();
        BufferedImage img = new BufferedImage(image.getWidth(null), image.getWidth(null), BufferedImage.TYPE_INT_RGB);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.canRead()) {
                file.setReadable(true);
                file.setExecutable(true);
                file.setWritable(true);
            }
            ImageIO.write(img, "bmp", file);

        } catch (FileNotFoundException e) {
        }

    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCategoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbAccept;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbSearchImage;
    private javax.swing.JComboBox<String> jcbAlcohol;
    private javax.swing.JComboBox<String> jcbFamilyDish;
    private javax.swing.JComboBox<String> jcbSoda;
    private javax.swing.JLabel jlAlcohol;
    private javax.swing.JLabel jlCapacity;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlFamilyDish;
    private javax.swing.JLabel jlFoodImage;
    private javax.swing.JLabel jlSoda;
    private javax.swing.JLabel jlTypeBottle;
    private javax.swing.JPanel jpDrink;
    private javax.swing.JPanel jpFood;
    private javax.swing.JRadioButton jrbBebida;
    private javax.swing.JRadioButton jrbComida;
    private javax.swing.JTextField jtfCapacity;
    private javax.swing.JTextField jtfProductName;
    private javax.swing.JTextField jtfProductPrice;
    private javax.swing.JTextField jtfTypeBottle;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
    private AddProduct_Controller apc;
    private boolean soda, alcohol;
    private int capacity;
    private double price;
    private String name, commentary, familyDish;
}
