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
@Table(name = "Drinks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drinks.findAll", query = "SELECT d FROM Drinks d")
    , @NamedQuery(name = "Drinks.findById", query = "SELECT d FROM Drinks d WHERE d.id = :id")
    , @NamedQuery(name = "Drinks.findByName", query = "SELECT d FROM Drinks d WHERE d.name = :name")
    , @NamedQuery(name = "Drinks.findByPrice", query = "SELECT d FROM Drinks d WHERE d.price = :price")
    , @NamedQuery(name = "Drinks.findByCommentary", query = "SELECT d FROM Drinks d WHERE d.commentary = :commentary")
    , @NamedQuery(name = "Drinks.findByCapacity", query = "SELECT d FROM Drinks d WHERE d.capacity = :capacity")
    , @NamedQuery(name = "Drinks.findByTypeBottle", query = "SELECT d FROM Drinks d WHERE d.typeBottle = :typeBottle")
    , @NamedQuery(name = "Drinks.findBySoda", query = "SELECT d FROM Drinks d WHERE d.soda = :soda")
    , @NamedQuery(name = "Drinks.findByAlcohol", query = "SELECT d FROM Drinks d WHERE d.alcohol = :alcohol")})
public class Drinks implements Serializable {

    @Basic(optional = false)
    @Column(name = "Capacity")
    private int capacity;
    @Basic(optional = false)
    @Column(name = "Soda")
    private boolean soda;
    @Basic(optional = false)
    @Column(name = "Alcohol")
    private boolean alcohol;
    @JoinTable(name = "MenuDrinks", joinColumns = {
        @JoinColumn(name = "Drink_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Menu_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Menus> menusCollection;
    @JoinColumn(name = "Id", referencedColumnName = "Id")
    @OneToOne(optional = false)
    private Products products;

    @JoinTable(name = "Orders_has_Drinks", joinColumns = {
        @JoinColumn(name = "Drink_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Order_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Orders> ordersCollection;

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
    @Column(name = "Commentary")
    private String commentary;
    @Column(name = "TypeBottle")
    private String typeBottle;

    public Drinks() {
    }

    public Drinks(Integer id) {
        this.id = id;
    }

    public Drinks(Integer id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }


    public String getTypeBottle() {
        return typeBottle;
    }

    public void setTypeBottle(String typeBottle) {
        this.typeBottle = typeBottle;
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
        if (!(object instanceof Drinks)) {
            return false;
        }
        Drinks other = (Drinks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Drinks[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Menus> getMenusCollection() {
        return menusCollection;
    }

    public void setMenusCollection(Collection<Menus> menusCollection) {
        this.menusCollection = menusCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
    
}
