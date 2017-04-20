/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Tables;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class TablesDAO {

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

    public long saveTable(Tables table) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(table);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateTable(Tables table) throws HibernateException {
        try {
            startOperation();
            sesion.update(table);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteTable(Tables table) throws HibernateException {
        try {
            startOperation();
            sesion.delete(table);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Tables getTable(long idTable) throws HibernateException {
        Tables table = null;
        try {
            startOperation();
            table = (Tables) sesion.get(Tables.class, idTable);
        } finally {
            sesion.close();
        }

        return table;
    }

    public List<Tables> getTableList() throws HibernateException {
        List<Tables> TableList = null;

        try {
            startOperation();
            TableList = sesion.createQuery("from Table").list();
        } finally {
            sesion.close();
        }

        return TableList;
    }

    public List<Tables> getAllTables() {
        try {
            if (!this.sessionFactory.getCurrentSession().getTransaction().isActive()) {
                this.sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession()
                    .createCriteria(Tables.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }

}
