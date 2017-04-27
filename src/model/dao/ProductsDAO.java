/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Products;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sakulambo
 */
public class ProductsDAO {
    
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

    public long saveProduct(Products product) throws HibernateException {
        long id = 0;

        try {
            startOperation();
            id = (Long) sesion.save(product);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }

        return id;
    }

    public void updateProduct(Products product) throws HibernateException {
        try {
            startOperation();
            sesion.update(product);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public void deleteProduct(Products product) throws HibernateException {
        try {
            startOperation();
            sesion.delete(product);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public Products getProduct(long idDrink) throws HibernateException {
        Products drink = null;
        try {
            startOperation();
            drink = (Products) sesion.get(Products.class, idDrink);
        } finally {
            sesion.close();
        }

        return drink;
    }

    public List<Products> getProductList() throws HibernateException {
        List<Products> ProductList = null;

        try {
            startOperation();
            ProductList = sesion.createQuery("from Products").list();
        } finally {
            sesion.close();
        }

        return ProductList;
    }

    public List<Products> getAllProducts() {
        try {
            if (!HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().isActive()) {
                HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
            }
            return HibernateUtil.getSessionFactory().getCurrentSession()
                    .createCriteria(Products.class)
                    .list();

        } catch (Exception e) {
            return null;
        }
    }
    
}
