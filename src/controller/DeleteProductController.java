/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import view.Delete_Product;

/**
 *
 * @author sakulambo
 */
public class DeleteProductController {

    private Delete_Product deleteProduct;
    private Controller controller;
    
    public DeleteProductController() throws NoSuchAlgorithmException{
        this.deleteProduct = new Delete_Product();
        this.deleteProduct.setDeleteProductController(this);
    }

    public Delete_Product getDeleteProduct() {
        return deleteProduct;
    }

    public void setDeleteProduct(Delete_Product deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    


    
}
