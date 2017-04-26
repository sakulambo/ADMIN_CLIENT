/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.Controller;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author sakulambo
 */
public class Admin_Panel {

    private static Controller controller;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        controller = new Controller();
        controller.getLc();

//        DrinksDAO drinksDAO = new DrinksDAO();
//        List<Drinks> result = drinksDAO.getAllDrinks();
//
//        for(Drinks d: result){
//            System.out.println(d.toString());
//        }
//        System.out.println("PRUEBA" + result.size());
        
    

    }

}
