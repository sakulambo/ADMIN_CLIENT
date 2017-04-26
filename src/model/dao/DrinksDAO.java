/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Drinks;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class DrinksDAO {

    private Session sesion;
    private Transaction tx;
    //private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private void startOperation() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Something's Wrong...\n", he);
    }

    public long saveDrink(Drinks drink) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(drink);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateDrink(Drinks drink) throws HibernateException {
        try {
            startOperation();
            sesion.update(drink);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteDrink(Drinks drink) throws HibernateException {
        try {
            startOperation();
            sesion.delete(drink);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Drinks getDrink(long idDrink) throws HibernateException {
        Drinks drink = null;
        try {
            startOperation();
            drink = (Drinks) sesion.get(Drinks.class, idDrink);
        } finally {
            sesion.close();
        }

        return drink;
    }

    public List<Drinks> getDrinkList() throws HibernateException {
        List<Drinks> DrinkList = null;

        try {
            startOperation();
            DrinkList = sesion.createQuery("from Drink").list();
        } finally {
            sesion.close();
        }

        return DrinkList;
    }

    public List<Drinks> getAllDrinks() {
        try {
            if (!HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
            }
            return HibernateUtil.getSessionFactory().getCurrentSession()
                    .createCriteria(Drinks.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }
        

}
