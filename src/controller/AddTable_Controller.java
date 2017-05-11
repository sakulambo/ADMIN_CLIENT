/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Add_Table;

/**
 *
 * @author sakulambo
 */
public class AddTable_Controller {
    
    private Controller controller;
    private Add_Table at;

    public AddTable_Controller() {
        this.at = new Add_Table();
        this.at.setAtc(this);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Add_Table getAt() {
        return at;
    }

    public void setAt(Add_Table at) {
        this.at = at;
    }
    
    
    
    
    
}
