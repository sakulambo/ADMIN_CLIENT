/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Show_Table;

/**
 *
 * @author sakulambo
 */
public class ShowTable_Controller {
    
    private Show_Table showTables;
    private Controller controller;

    public ShowTable_Controller() {
        this.showTables = new Show_Table();
        this.showTables.setStc(this);
    }

    public Show_Table getShowTables() {
        return showTables;
    }

    public void setShowTables(Show_Table showTables) {
        this.showTables = showTables;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    
     
    
    
    
}
