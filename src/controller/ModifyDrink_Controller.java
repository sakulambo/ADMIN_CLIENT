/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Modify_Drink;

/**
 *
 * @author sakulambo
 */
public class ModifyDrink_Controller {
    
    private Controller controller;
    private Modify_Drink md;

    public ModifyDrink_Controller() {
        this.md = new Modify_Drink();
        this.md.setMdc(this);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Modify_Drink getMd() {
        return md;
    }

    public void setMd(Modify_Drink md) {
        this.md = md;
    }
    
    
    
    
    
}
