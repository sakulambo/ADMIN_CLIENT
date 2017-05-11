/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import view.Modify_Food;

/**
 *
 * @author sakulambo
 */
public class ModifyFood_Controller {

    private Modify_Food mf;
    private Controller controller;
    
    public ModifyFood_Controller() throws NoSuchAlgorithmException{
        this.mf = new Modify_Food();
        this.mf.setDpc(this);
    }

    public void setMf(Modify_Food mf) {
        this.mf = mf;
    }

    public Modify_Food getMf() {
        return mf;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    


    
}
