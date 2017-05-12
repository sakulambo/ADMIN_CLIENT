/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Show_Order;

/**
 *
 * @author sakulambo
 */
public class ShowOrder_Controller {
    
    private Controller controller;
    private Show_Order showOrders;

    public ShowOrder_Controller() {
        this.showOrders = new Show_Order();
        this.showOrders.setSoc(this);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Show_Order getShowOrders() {
        return showOrders;
    }

    public void setShowOrders(Show_Order showOrders) {
        this.showOrders = showOrders;
    }
    
    
    
    
}
