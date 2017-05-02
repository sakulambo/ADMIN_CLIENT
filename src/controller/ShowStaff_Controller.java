/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Show_Staff;

/**
 *
 * @author sakulambo
 */
public class ShowStaff_Controller {
    
    private Show_Staff showStaff;
    private Controller controller;

    public ShowStaff_Controller() {
        this.showStaff = new Show_Staff();
        this.showStaff.setSsc(this);
    }
    

    public Show_Staff getShowStaff() {
        return showStaff;
    }

    public void setShowStaff(Show_Staff showStaff) {
        this.showStaff = showStaff;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    
    
    
}
