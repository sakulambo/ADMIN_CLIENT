/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Add_Staff;

/**
 *
 * @author sakulambo
 */
public class AddStaff_Controller {
    
    private Controller controller;
    private Add_Staff addStaff;

    public AddStaff_Controller() {
        this.addStaff = new Add_Staff();
        this.addStaff.setAsc(this);
    }

    public Add_Staff getAddStaff() {
        return addStaff;
    }

    public void setAddStaff(Add_Staff addStaff) {
        this.addStaff = addStaff;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    
    
    
    
}
