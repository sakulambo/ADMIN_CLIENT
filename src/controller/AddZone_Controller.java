/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Add_Zone;

/**
 *
 * @author sakulambo
 */
public class AddZone_Controller {
    
    private Controller controller;
    private Add_Zone addZone;

    public AddZone_Controller() {
    this.addZone = new Add_Zone();
    this.addZone.setAzc(this);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Add_Zone getAddZone() {
        return addZone;
    }

    public void setAddZone(Add_Zone addZone) {
        this.addZone = addZone;
    }
    
    
    
    
}
