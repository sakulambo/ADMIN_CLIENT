/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m")
    , @NamedQuery(name = "Menus.findById", query = "SELECT m FROM Menus m WHERE m.id = :id")
    , @NamedQuery(name = "Menus.findByName", query = "SELECT m FROM Menus m WHERE m.name = :name")
    , @NamedQuery(name = "Menus.findByPrice", query = "SELECT m FROM Menus m WHERE m.price = :price")
    , @NamedQuery(name = "Menus.findByPeopleNumber", query = "SELECT m FROM Menus m WHERE m.peopleNumber = :peopleNumber")
    , @NamedQuery(name = "Menus.findByDescription", query = "SELECT m FROM Menus m WHERE m.description = :description")})
public class Menus implements Serializable {

    @JoinColumn(name = "Id", referencedColumnName = "Id")
    @OneToOne(optional = false)
    private Products products;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "PeopleNumber")
    private short peopleNumber;
    @Column(name = "Description")
    private String description;
    @ManyToMany(mappedBy = "menusCollection")
    private Collection<Drinks> drinksCollection;
    @JoinTable(name = "Orders_has_Menus", joinColumns = {
        @JoinColumn(name = "Menu_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Order_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Orders> ordersCollection;
    @ManyToMany(mappedBy = "menusCollection")
    private Collection<Foods> foodsCollection;

    public Menus() {
    }

    public Menus(Integer id) {
        this.id = id;
    }

    public Menus(Integer id, String name, BigDecimal price, short peopleNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.peopleNumber = peopleNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public short getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(short peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Drinks> getDrinksCollection() {
        return drinksCollection;
    }

    public void setDrinksCollection(Collection<Drinks> drinksCollection) {
        this.drinksCollection = drinksCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
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
        return "model.Menus[ id=" + id + " ]";
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
    
}
