/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import view.Add_Product;

/**
 *
 * @author sakulambo
 */
public class AddProduct_Controller {

    private Add_Product addProduct;
    private Controller controller;

    public AddProduct_Controller() throws NoSuchAlgorithmException{
        this.addProduct = new Add_Product();
        this.addProduct.setAddProductController(this);
    }

    public Add_Product getAddProduct() {
        return addProduct;
    }

    public void setAddProduct(Add_Product addProduct) {
        this.addProduct = addProduct;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


    
}
