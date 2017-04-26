package controller;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import model.service.Service;

/**
 * @author sakulambo
 */
public class Controller {

    private LoginController lc;
    private GeneralAPanelController gapc;
    private AddProductController apc;
    private DeleteProductController dpc;
    private Service service;

    public Controller() throws NoSuchAlgorithmException {
        this.lc = new LoginController();
        this.lc.setController(this);
        this.gapc = new GeneralAPanelController();
        this.gapc.setController(this);
        this.apc = new AddProductController();
        this.apc.setController(this);
        this.dpc = new DeleteProductController();
        this.dpc.setController(this);
        this.service = new Service();
        
    }

    public LoginController getLc() {
        return lc;
    }

    public void setLc(LoginController lc) {
        this.lc = lc;
    }

    public GeneralAPanelController getGapc() {
        return gapc;
    }

    public void setGapc(GeneralAPanelController gapc) {
        this.gapc = gapc;
    }

    public AddProductController getApc() {
        return apc;
    }

    public void setApc(AddProductController apc) {
        this.apc = apc;
    }

    public DeleteProductController getDpc() {
        return dpc;
    }

    public void setDpc(DeleteProductController dpc) {
        this.dpc = dpc;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    
    

    private static ResultSet RESULT;
}
