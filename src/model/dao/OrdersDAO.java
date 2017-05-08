/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class OrdersDAO {

    private Session sesion;
    private Transaction tx;

   

    private void startOperation() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Something's Wrong...\n", he);
    }

    public long saveOrder(Orders order) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(order);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateOrder(Orders order) throws HibernateException {
        try {
            startOperation();
            sesion.update(order);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteOrder(Orders order) throws HibernateException {
        try {
            startOperation();
            sesion.delete(order);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Orders getOrder(long idOrder) throws HibernateException {
        Orders menu = null;
        try {
            startOperation();
            menu = (Orders) sesion.get(Orders.class, idOrder);
        } finally {
            sesion.close();
        }

        return menu;
    }

    public List<Orders> getOrderList() throws HibernateException {
        List<Orders> OrderList = null;

        try {
            startOperation();
            OrderList = sesion.createQuery("from Drink").list();
        } finally {
            sesion.close();
        }

        return OrderList;
    }

    public List<Orders> getAllOrders() {
        try {
            if (!HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
            }
            return HibernateUtil.getSessionFactory().getCurrentSession()
                    .createCriteria(Orders.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }

}
