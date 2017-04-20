/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sakulambo
 */
@Embeddable
public class FragmentsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Product_Id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "Order_Id")
    private int orderId;

    public FragmentsPK() {
    }

    public FragmentsPK(int productId, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productId;
        hash += (int) orderId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FragmentsPK)) {
            return false;
        }
        FragmentsPK other = (FragmentsPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.orderId != other.orderId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.FragmentsPK[ productId=" + productId + ", orderId=" + orderId + " ]";
    }
    
}
