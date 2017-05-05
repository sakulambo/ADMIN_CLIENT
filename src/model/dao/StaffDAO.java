/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Staff;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class StaffDAO {
    private Session sesion;
    private Transaction tx;

   // private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private void startOperation() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Something's Wrong...\n", he);
    }

    public long saveStaff(Staff staff) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(staff);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateStaff(Staff staff) throws HibernateException {
        try {
            startOperation();
            sesion.update(staff);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteStaff(Staff staff) throws HibernateException {
        try {
            startOperation();
            sesion.delete(staff);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Staff getStaff(long idMenu) throws HibernateException {
        Staff menu = null;
        try {
            startOperation();
            menu = (Staff) sesion.get(Staff.class, idMenu);
        } finally {
            sesion.close();
        }

        return menu;
    }

    public List<Staff> getStaffList() throws HibernateException {
        List<Staff> staffList = null;

        try {
            startOperation();
            staffList = sesion.createQuery("from Staff").list();
        } finally {
            sesion.close();
        }

        return staffList;
    }
    
    public List<Staff> getAllStaff() {
        try {
            if (!HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
            }
            return HibernateUtil.getSessionFactory().getCurrentSession()
                    .createCriteria(Staff.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }
    
}
