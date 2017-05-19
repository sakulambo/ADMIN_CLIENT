/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import model.pojo.*;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Tables")
@NamedQueries({
    @NamedQuery(name = "Tables.findAll", query = "SELECT t FROM Tables t")})
public class Tables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "MaxPeople")
    private int maxPeople;
    @Basic(optional = false)
    @Column(name = "Empty")
    private boolean empty;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableId", fetch = FetchType.LAZY)
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "Zone_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Zones zoneId;

    public Tables() {
    }

    public Tables(Integer id) {
        this.id = id;
    }

    public Tables(int maxPeople, boolean empty) {
        this.maxPeople = maxPeople;
        this.empty = empty;
    }

    public Tables(int maxPeople, boolean empty, Zones zoneId) {
        this.maxPeople = maxPeople;
        this.empty = empty;
        this.zoneId = zoneId;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Zones getZoneId() {
        return zoneId;
    }

    public void setZoneId(Zones zoneId) {
        this.zoneId = zoneId;
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
        if (!(object instanceof Tables)) {
            return false;
        }
        Tables other = (Tables) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.Tables[ id=" + id + " ]";
    }
    
}