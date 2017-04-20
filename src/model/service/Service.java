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

    public Service() {
        this.drinksDAO = new DrinksDAO();
        this.foodsDAO = new FoodsDAO();
        this.menusDAO = new MenusDAO();
        this.ordersDAO = new OrdersDAO();
        this.tablesDAO = new TablesDAO();
        this.waitersDAO = new WaitersDAO();
        this.zonesDAO = new ZonesDAO();
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
    
    public void saveDrink(Drinks d){
        drinksDAO.saveDrink(d);
    }
    
    
    
    

}
