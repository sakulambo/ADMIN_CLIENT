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
    private ModifyFood_Controller mfc;
    private ShowTable_Controller stc;
    private ShowMenu_Controller smc;
    private ShowStaff_Controller ssc;
    private AddStaff_Controller asc;
    private ModifyDrink_Controller mdc;
    private AddTable_Controller atc;
    private ShowOrder_Controller soc;
    private ShowZone_Controller szc;
    private AddZone_Controller azc;
    private Service service;

    public Controller() throws NoSuchAlgorithmException {
        this.service = new Service();
        this.lc = new Login_Controller();
        this.gapc = new GeneralAPanel_Controller();
        this.apc = new AddProduct_Controller();
        this.mfc = new ModifyFood_Controller();
        this.stc = new ShowTable_Controller();
        this.smc = new ShowMenu_Controller();
        this.ssc = new ShowStaff_Controller();
        this.asc = new AddStaff_Controller();
        this.mdc = new ModifyDrink_Controller();
        this.atc = new AddTable_Controller();
        this.soc = new ShowOrder_Controller();
        this.szc = new ShowZone_Controller();
        this.azc = new AddZone_Controller();

        this.azc.setController(this);
        this.szc.setController(this);
        this.soc.setController(this);
        this.atc.setController(this);
        this.mdc.setController(this);
        this.asc.setController(this);
        this.ssc.setController(this);
        this.smc.setController(this);
        this.lc.setController(this);
        this.gapc.setController(this);
        this.apc.setController(this);
        this.stc.setController(this);
        this.mfc.setController(this);

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

    public ModifyFood_Controller getDpc() {
        return mfc;
    }

    public void setDpc(ModifyFood_Controller dpc) {
        this.mfc = dpc;
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

    public ShowStaff_Controller getSsc() {
        return ssc;
    }

    public void setSsc(ShowStaff_Controller ssc) {
        this.ssc = ssc;
    }

    public AddStaff_Controller getAsc() {
        return asc;
    }

    public void setAsc(AddStaff_Controller asc) {
        this.asc = asc;
    }

    public ModifyFood_Controller getMfc() {
        return mfc;
    }

    public void setMfc(ModifyFood_Controller mfc) {
        this.mfc = mfc;
    }

    public ModifyDrink_Controller getMdc() {
        return mdc;
    }

    public void setMdc(ModifyDrink_Controller mdc) {
        this.mdc = mdc;
    }

    public AddTable_Controller getAtc() {
        return atc;
    }

    public void setAtc(AddTable_Controller atc) {
        this.atc = atc;
    }

    public ShowOrder_Controller getSoc() {
        return soc;
    }

    public void setSoc(ShowOrder_Controller soc) {
        this.soc = soc;
    }

    public ShowZone_Controller getSzc() {
        return szc;
    }

    public void setSzc(ShowZone_Controller szc) {
        this.szc = szc;
    }

    public AddZone_Controller getAzc() {
        return azc;
    }

    public void setAzc(AddZone_Controller azc) {
        this.azc = azc;
    }
    

    
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    private static ResultSet RESULT;
}
