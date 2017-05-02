/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Show_Menu;

/**
 *
 * @author sakulambo
 */
public class ShowMenu_Controller {
    
    private Controller controller;
    private Show_Menu showMenus;

    public ShowMenu_Controller() {
        this.showMenus = new Show_Menu();
        this.showMenus.setSmc(this);
        
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Show_Menu getShowMenus() {
        return showMenus;
    }

    public void setShowMenus(Show_Menu showMenus) {
        this.showMenus = showMenus;
    }
    
    
    
}
