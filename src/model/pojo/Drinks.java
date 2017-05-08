/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Drinks")
@NamedQueries({
    @NamedQuery(name = "Drinks.findAll", query = "SELECT d FROM Drinks d")})
public class Drinks extends Products implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "Id")
//    private Integer id;
    @Basic(optional = false)
    @Column(name = "Capacity")
    protected int capacity;
    @Column(name = "TypeBottle")
    protected String typeBottle;
    @Basic(optional = false)
    @Column(name = "Soda")
    protected boolean soda;
    @Basic(optional = false)
    @Column(name = "Alcohol")
    protected boolean alcohol;
    @JoinTable(name = "MenuDrinks", joinColumns = {
        @JoinColumn(name = "Drink_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Menu_Id", referencedColumnName = "Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Menus> menusCollection;
//    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.LAZY)
//    private Products products;

    public Drinks() {
    }

    public Drinks(int capacity, String typeBottle, boolean soda, boolean alcohol, String name, double price, String description) {
        super(name, price, description);
        this.capacity = capacity;
        this.typeBottle = typeBottle;
        this.soda = soda;
        this.alcohol = alcohol;
    }

//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getTypeBottle() {
        return typeBottle;
    }

    public void setTypeBottle(String typeBottle) {
        this.typeBottle = typeBottle;
    }

    public boolean getSoda() {
        return soda;
    }

    public void setSoda(boolean soda) {
        this.soda = soda;
    }

    public boolean getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public Collection<Menus> getMenusCollection() {
        return menusCollection;
    }

    public void setMenusCollection(Collection<Menus> menusCollection) {
        this.menusCollection = menusCollection;
    }

//    public Products getProducts() {
//        return products;
//    }
//
//    public void setProducts(Products products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "Drinks{" + "capacity=" + capacity + ", typeBottle=" + typeBottle + ", soda=" + soda + ", alcohol=" + alcohol + '}';
    }

}
