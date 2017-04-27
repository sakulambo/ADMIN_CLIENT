/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import view.General_APanel;

/**
 *
 * @author sakulambo
 */
public class GeneralAPanelController {

    private General_APanel generalAdmin_Panel;
    private Controller controller;

    public GeneralAPanelController() throws NoSuchAlgorithmException {
        this.generalAdmin_Panel = new General_APanel();
        this.generalAdmin_Panel.setApc(this);
    }

    public General_APanel getGeneralAdmin_Panel() {
        return generalAdmin_Panel;
    }

    public void setGeneralAdmin_Panel(General_APanel generalAdmin_Panel) {
        this.generalAdmin_Panel = generalAdmin_Panel;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

}
