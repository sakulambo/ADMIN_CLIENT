/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Menus;
import model.pojo.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class MenusDAO {

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

    public long saveMenu(Menus menu) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(menu);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateMenu(Menus menu) throws HibernateException {
        try {
            startOperation();
            sesion.update(menu);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteMenu(Menus menu) throws HibernateException {
        try {
            startOperation();
            sesion.delete(menu);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Menus getMenu(long idMenu) throws HibernateException {
        Menus menu = null;
        try {
            startOperation();
            menu = (Menus) sesion.get(Menus.class, idMenu);
        } finally {
            sesion.close();
        }

        return menu;
    }

    public List<Menus> getMenuList() throws HibernateException {
        List<Menus> MenuList = null;

        try {
            startOperation();
            MenuList = sesion.createQuery("from Drink").list();
        } finally {
            sesion.close();
        }

        return MenuList;
    }
    
    public List<Menus> getAllMenus() {
        try {
            if (!this.sessionFactory.getCurrentSession().getTransaction().isActive()) {
                this.sessionFactory.getCurrentSession().getTransaction().begin();
            }
            return sessionFactory.getCurrentSession()
                    .createCriteria(Menus.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }

}
