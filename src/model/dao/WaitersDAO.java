/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Waiters;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class WaitersDAO {

    private Session sesion;
    private Transaction tx;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    
    private void startOperation() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Something's Wrong...\n", he);
    }

    public long saveWaiter(Waiters waiter) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(waiter);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateWaiter(Waiters waiter) throws HibernateException {
        try {
            startOperation();
            sesion.update(waiter);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteWaiter(Waiters waiter) throws HibernateException {
        try {
            startOperation();
            sesion.delete(waiter);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Waiters getWaiter(long idWaiter) throws HibernateException {
        Waiters waiter = null;
        try {
            startOperation();
            waiter = (Waiters) sesion.get(Waiters.class, idWaiter);
        } finally {
            sesion.close();
        }

        return waiter;
    }

    public List<Waiters> getWaiterList() throws HibernateException {
        List<Waiters> WaiterList = null;

        try {
            startOperation();
            WaiterList = sesion.createQuery("from Drink").list();
        } finally {
            sesion.close();
        }

        return WaiterList;
    }
    
    
    public List<Waiters> getAllWaiters() {
        try {
            if (!this.sessionFactory.getCurrentSession().getTransaction().isActive()) {
                this.sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession()
                    .createCriteria(Waiters.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }
}
