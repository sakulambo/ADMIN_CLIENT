/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Foods;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class FoodsDAO {

    private Session sesion;
    private Transaction tx;

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private void startOperation() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Something's Wrong...\n", he);
    }

    public long saveFood(Foods food) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(food);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateFood(Foods food) throws HibernateException {
        try {
            startOperation();
            sesion.update(food);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteFood(Foods food) throws HibernateException {
        try {
            startOperation();
            sesion.delete(food);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Foods getFood(long idFood) throws HibernateException {
        Foods drink = null;
        try {
            startOperation();
            drink = (Foods) sesion.get(Foods.class, idFood);
        } finally {
            sesion.close();
        }

        return drink;
    }

    public List<Foods> getFoodList() throws HibernateException {
        List<Foods> FoodList = null;

        try {
            startOperation();
            FoodList = sesion.createQuery("from Food").list();
        } finally {
            sesion.close();
        }

        return FoodList;
    }

    public List<Foods> getAllFoods() {
        try {
            if (!this.sessionFactory.getCurrentSession().getTransaction().isActive()) {
                this.sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession()
                    .createCriteria(Foods.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }

}
