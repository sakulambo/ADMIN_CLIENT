/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "Products")
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")})
public abstract class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Name")
    protected String name;    
    @Basic(optional = false)
    @Column(name = "Price")
    protected double price;
    @Column(name = "Description")
    protected String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products", fetch = FetchType.LAZY)
    private Collection<Fragments> fragmentsCollection;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "products", fetch = FetchType.LAZY)
//    private Menus menus;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "products", fetch = FetchType.LAZY)
//    private Drinks drinks;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "products", fetch = FetchType.LAZY)
//    private Foods foods;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }

    public Products(Integer id, double price) {
        this.id = id;
        this.price = price;
    }

    public Products(String name, double price, String description) {        
        this.name = name;
        this.price = price;
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Fragments> getFragmentsCollection() {
        return fragmentsCollection;
    }

    public void setFragmentsCollection(Collection<Fragments> fragmentsCollection) {
        this.fragmentsCollection = fragmentsCollection;
    }

//    public Menus getMenus() {
//        return menus;
//    }
//
//    public void setMenus(Menus menus) {
//        this.menus = menus;
//    }
////
//    public Drinks getDrinks() {
//        return drinks;
//    }
//
//    public void setDrinks(Drinks drinks) {
//        this.drinks = drinks;
//    }
//
//    public Foods getFoods() {
//        return foods;
//    }
//
//    public void setFoods(Foods foods) {
//        this.foods = foods;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.Products[ id=" + id + " ]";
    }
    
}
