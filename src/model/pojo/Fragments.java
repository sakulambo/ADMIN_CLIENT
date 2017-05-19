/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import model.pojo.*;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Fragments")
@NamedQueries({
    @NamedQuery(name = "Fragments.findAll", query = "SELECT f FROM Fragments f")})
public class Fragments implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FragmentsPK fragmentsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "Order_Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Orders orders;
    @JoinColumn(name = "Product_Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Products products;

    public Fragments() {
    }

    public Fragments(FragmentsPK fragmentsPK) {
        this.fragmentsPK = fragmentsPK;
    }

    public Fragments(FragmentsPK fragmentsPK, BigDecimal price, int quantity) {
        this.fragmentsPK = fragmentsPK;
        this.price = price;
        this.quantity = quantity;
    }

    public Fragments(int productId, int orderId) {
        this.fragmentsPK = new FragmentsPK(productId, orderId);
    }

    public FragmentsPK getFragmentsPK() {
        return fragmentsPK;
    }

    public void setFragmentsPK(FragmentsPK fragmentsPK) {
        this.fragmentsPK = fragmentsPK;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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
        hash += (fragmentsPK != null ? fragmentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fragments)) {
            return false;
        }
        Fragments other = (Fragments) object;
        if ((this.fragmentsPK == null && other.fragmentsPK != null) || (this.fragmentsPK != null && !this.fragmentsPK.equals(other.fragmentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.Fragments[ fragmentsPK=" + fragmentsPK + " ]";
    }
    
}
