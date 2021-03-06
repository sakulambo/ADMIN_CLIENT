/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.dao.*;
import model.pojo.*;

/**
 *
 * @author sakulambo
 */
public class Service {

    private DrinksDAO drinksDAO;
    private FoodsDAO foodsDAO;
    private MenusDAO menusDAO;
    private OrdersDAO ordersDAO;
    private TablesDAO tablesDAO;
    private WaitersDAO waitersDAO;
    private ZonesDAO zonesDAO;
    private ProductsDAO productsDAO;
    private StaffDAO staffDAO;
    private AbstractDAO abstractDAO;
    private ReportDAO reportDAO;

    public Service() {
        this.drinksDAO = new DrinksDAO();
        this.foodsDAO = new FoodsDAO();
        this.menusDAO = new MenusDAO();
        this.ordersDAO = new OrdersDAO();
        this.tablesDAO = new TablesDAO();
        this.waitersDAO = new WaitersDAO();
        this.zonesDAO = new ZonesDAO();
        this.productsDAO = new ProductsDAO();
        this.staffDAO = new StaffDAO();
        this.abstractDAO = new AbstractDAO();
        this.reportDAO = new ReportDAO();
    }

    public DrinksDAO getDrinksDAO() {
        return drinksDAO;
    }

    public void setDrinksDAO(DrinksDAO drinksDAO) {
        this.drinksDAO = drinksDAO;
    }

    public FoodsDAO getFoodsDAO() {
        return foodsDAO;
    }

    public void setFoodsDAO(FoodsDAO foodsDAO) {
        this.foodsDAO = foodsDAO;
    }

    public MenusDAO getMenusDAO() {
        return menusDAO;
    }

    public void setMenusDAO(MenusDAO menusDAO) {
        this.menusDAO = menusDAO;
    }

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public TablesDAO getTablesDAO() {
        return tablesDAO;
    }

    public void setTablesDAO(TablesDAO tablesDAO) {
        this.tablesDAO = tablesDAO;
    }

    public WaitersDAO getWaitersDAO() {
        return waitersDAO;
    }

    public void setWaitersDAO(WaitersDAO waitersDAO) {
        this.waitersDAO = waitersDAO;
    }

    public ZonesDAO getZonesDAO() {
        return zonesDAO;
    }

    public void setZonesDAO(ZonesDAO zonesDAO) {
        this.zonesDAO = zonesDAO;
    }

    public void saveDrink(Drinks d) {
        drinksDAO.saveDrink(d);
    }

    public ProductsDAO getProductsDAO() {
        return productsDAO;
    }

    public void setProductsDAO(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public StaffDAO getStaffDAO() {
        return staffDAO;
    }

    public void setStaffDAO(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public AbstractDAO getAbstractDAO() {
        return abstractDAO;
    }

    public void setAbstractDAO(AbstractDAO abstractDAO) {
        this.abstractDAO = abstractDAO;
    }

    public ReportDAO getReportDAO() {
        return reportDAO;
    }

    public void setReportDAO(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }
    
    

}
