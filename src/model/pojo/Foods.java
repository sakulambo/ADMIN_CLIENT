/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import com.sun.istack.internal.NotNull;
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
@Table(name = "Foods")
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f")})
public class Foods extends Products implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "Id")
//    private Integer id;
    @NotNull
    @Column(name = "FamilyDish")
    private String familyDish;
    @JoinTable(name = "MenuFoods", joinColumns = {
        @JoinColumn(name = "Food_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "Menu_Id", referencedColumnName = "Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Menus> menusCollection;
//    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.LAZY)
//    private Products products;

    public Foods() {
    }

    public Foods(String familyDish, String name, double price, String description) {
        super(name, price, description);
        this.familyDish = familyDish;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
    public String getFamilyDish() {
        return familyDish;
    }

    public void setFamilyDish(String familyDish) {
        this.familyDish = familyDish;
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
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Foods)) {
//            return false;
//        }
//        Foods other = (Foods) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
    @Override
    public String toString() {
        return "Foods{" + "familyDish=" + familyDish + '}';
    }

}
