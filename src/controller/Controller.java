package controller;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import model.service.Service;

/**
 * @author sakulambo
 */
public class Controller {

    private Login_Controller lc;
    private GeneralAPanel_Controller gapc;
    private AddProduct_Controller apc;
    private ModifyProduct_Controller dpc;
    private ShowTable_Controller stc;
    private ShowMenu_Controller smc;

    private Service service;

    public Controller() throws NoSuchAlgorithmException {
        this.service = new Service();
        this.lc = new Login_Controller();
        this.gapc = new GeneralAPanel_Controller();
        this.apc = new AddProduct_Controller();
        this.dpc = new ModifyProduct_Controller();
        this.stc = new ShowTable_Controller();
        this.smc = new ShowMenu_Controller();

        this.smc.setController(this);
        this.lc.setController(this);
        this.gapc.setController(this);
        this.apc.setController(this);
        this.stc.setController(this);
        this.dpc.setController(this);

    }

    public Login_Controller getLc() {
        return lc;
    }

    public void setLc(Login_Controller lc) {
        this.lc = lc;
    }

    public GeneralAPanel_Controller getGapc() {
        return gapc;
    }

    public void setGapc(GeneralAPanel_Controller gapc) {
        this.gapc = gapc;
    }

    public AddProduct_Controller getApc() {
        return apc;
    }

    public void setApc(AddProduct_Controller apc) {
        this.apc = apc;
    }

    public ModifyProduct_Controller getDpc() {
        return dpc;
    }

    public void setDpc(ModifyProduct_Controller dpc) {
        this.dpc = dpc;
    }

    public ShowTable_Controller getStc() {
        return stc;
    }

    public void setStc(ShowTable_Controller stc) {
        this.stc = stc;
    }

    public ShowMenu_Controller getSmc() {
        return smc;
    }

    public void setSmc(ShowMenu_Controller smc) {
        this.smc = smc;
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    private static ResultSet RESULT;
}
