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
@Table(name = "Menus")
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PeopleNumber")
    private short peopleNumber;
    @ManyToMany(mappedBy = "menusCollection", fetch = FetchType.LAZY)
    private Collection<Drinks> drinksCollection;
    @ManyToMany(mappedBy = "menusCollection", fetch = FetchType.LAZY)
    private Collection<Foods> foodsCollection;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Products products;

    public Menus() {
    }

    public Menus(Integer id) {
        this.id = id;
    }

    public Menus(Integer id, short peopleNumber) {
        this.id = id;
        this.peopleNumber = peopleNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(short peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Collection<Drinks> getDrinksCollection() {
        return drinksCollection;
    }

    public void setDrinksCollection(Collection<Drinks> drinksCollection) {
        this.drinksCollection = drinksCollection;
    }

    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.Menus[ id=" + id + " ]";
    }
    
}
