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
@Table(name = "Foods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f")
    , @NamedQuery(name = "Foods.findById", query = "SELECT f FROM Foods f WHERE f.id = :id")
    , @NamedQuery(name = "Foods.findByName", query = "SELECT f FROM Foods f WHERE f.name = :name")
    , @NamedQuery(name = "Foods.findByPrice", query = "SELECT f FROM Foods f WHERE f.price = :price")
    , @NamedQuery(name = "Foods.findByPartOfMenu", query = "SELECT f FROM Foods f WHERE f.partOfMenu = :partOfMenu")
    , @NamedQuery(name = "Foods.findByFamilyDish", query = "SELECT f FROM Foods f WHERE f.familyDish = :familyDish")
    , @NamedQuery(name = "Foods.findByCommentary", query = "SELECT f FROM Foods f WHERE f.commentary = :commentary")})
public class Foods implements Serializable {

    @JoinTable(name = "MenuFoods", joinColumns = {
        @JoinColumn(name = "Food_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Menu_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Menus> menusCollection;
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
    @Column(name = "PartOfMenu")
    private String partOfMenu;
    @Column(name = "FamilyDish")
    private String familyDish;
    @Column(name = "Commentary")
    private String commentary;
    @JoinTable(name = "Orders_has_Foods", joinColumns = {
        @JoinColumn(name = "Food_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Order_Id", referencedColumnName = "Id")})
    @ManyToMany
    private Collection<Orders> ordersCollection;

    public Foods() {
    }

    public Foods(Integer id) {
        this.id = id;
    }

    public Foods(Integer id, String name, BigDecimal price) {
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

    public String getPartOfMenu() {
        return partOfMenu;
    }

    public void setPartOfMenu(String partOfMenu) {
        this.partOfMenu = partOfMenu;
    }

    public String getFamilyDish() {
        return familyDish;
    }

    public void setFamilyDish(String familyDish) {
        this.familyDish = familyDish;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Menus> getMenusCollection() {
        return menusCollection;
    }

    public void setMenusCollection(Collection<Menus> menusCollection) {
        this.menusCollection = menusCollection;
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
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Foods[ id=" + id + " ]";
    }

   

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
    
}
