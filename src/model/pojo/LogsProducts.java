/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "LogsProducts")
@NamedQueries({
    @NamedQuery(name = "LogsProducts.findAll", query = "SELECT l FROM LogsProducts l")
    , @NamedQuery(name = "LogsProducts.findById", query = "SELECT l FROM LogsProducts l WHERE l.id = :id")
    , @NamedQuery(name = "LogsProducts.findByAction", query = "SELECT l FROM LogsProducts l WHERE l.action = :action")})
public class LogsProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Action")
    private String action;
    @JoinColumn(name = "Product_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Products productId;

    public LogsProducts() {
    }

    public LogsProducts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
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
        if (!(object instanceof LogsProducts)) {
            return false;
        }
        LogsProducts other = (LogsProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo2.LogsProducts[ id=" + id + " ]";
    }
    
}
