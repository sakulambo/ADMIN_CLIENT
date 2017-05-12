/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Show_Zone;

/**
 *
 * @author sakulambo
 */
public class ShowZone_Controller {
    
    private Controller controller;
    private Show_Zone showZone;

    public ShowZone_Controller() {
        this.showZone = new Show_Zone();
        this.showZone.setSzc(this);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Show_Zone getShowZone() {
        return showZone;
    }

    public void setShowZone(Show_Zone showZone) {
        this.showZone = showZone;
    }
    
    
    
    
    
}
