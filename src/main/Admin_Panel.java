/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import model.dao.DrinksDAO;
import model.pojo.Drinks;

/**
 *
 * @author sakulambo
 */
public class Admin_Panel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {

//        DrinksDAO drinksDAO = new DrinksDAO();
//        List<Drinks> result = drinksDAO.getAllDrinks();
//
//        System.out.println("PRUEBA" + result.size());
//        
       controller.Controller controller = new Controller();//       
       controller.getMainPanel();
    }

}
