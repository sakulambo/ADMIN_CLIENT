
package controller;

import view.Login;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import model.pojo.UsersDB;
import view.Add_Food;
import view.General_APanel;

/**
 * @author sakulambo
 */
public class Controller {
    
    private Login login;
    private Add_Food addFood_Window;
    private General_APanel mainPanel;

    public Controller() throws NoSuchAlgorithmException {
        this.login = new Login();
        this.addFood_Window = new Add_Food();
        this.mainPanel = new General_APanel();
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Add_Food getAddFood_Window() {
        return addFood_Window;
    }

    public void setAddFood_Window(Add_Food addFood_Window) {
        this.addFood_Window = addFood_Window;
    }

    public General_APanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(General_APanel mainPanel) {
        this.mainPanel = mainPanel;
    }    
     
    public static ResultSet getData(String user) {
        
        UsersDB db = new UsersDB();
        Connection con = null;
        
        con = db.getConn();
        
        try {
            
            RESULT = con.createStatement().executeQuery("SELECT * FROM Login");

        } catch (Exception err) {
            System.out.println(err);
        }

        return RESULT;

    }
    
    private static ResultSet RESULT;
}
