/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Waiters;
import model.pojo.Zones;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class ZonesDAO {

    private Session sesion;
    private Transaction tx;
   // private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    private void startOperation() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Something's Wrong...\n", he);
    }

    public long saveZone(Zones zone) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(zone);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateZone(Zones zone) throws HibernateException {
        try {
            startOperation();
            sesion.update(zone);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteZone(Zones zone) throws HibernateException {
        try {
            startOperation();
            sesion.delete(zone);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Zones getZone(long idZone) throws HibernateException {
        Zones zone = null;
        try {
            startOperation();
            zone = (Zones) sesion.get(Zones.class, idZone);
        } finally {
            sesion.close();
        }

        return zone;
    }

    public List<Zones> getZoneList() throws HibernateException {
        List<Zones> ZoneList = null;

        try {
            startOperation();
            ZoneList = sesion.createQuery("from Drink").list();
        } finally {
            sesion.close();
        }

        return ZoneList;
    }

    public List<Zones> getAllZones() {
        try {
            if (!HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
            }
            return HibernateUtil.getSessionFactory().getCurrentSession()
                    .createCriteria(Zones.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }
}
