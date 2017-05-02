/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import view.Modify_Product;

/**
 *
 * @author sakulambo
 */
public class ModifyProduct_Controller {

    private Modify_Product modifyProduct;
    private Controller controller;
    
    public ModifyProduct_Controller() throws NoSuchAlgorithmException{
        this.modifyProduct = new Modify_Product();
        this.modifyProduct.setDpc(this);
    }

    public Modify_Product getDeleteProduct() {
        return modifyProduct;
    }

    public void setDeleteProduct(Modify_Product deleteProduct) {
        this.modifyProduct = deleteProduct;
    }

    

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    


    
}
