/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import view.Login;

public class Login_Controller {

    
    private Login login;
    private Controller controller;

    public Login_Controller() throws NoSuchAlgorithmException {
     
        this.login = new Login();
        this.login.setLoginController(this);
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    

}
