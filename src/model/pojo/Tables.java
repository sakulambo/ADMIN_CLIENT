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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Tables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tables.findAll", query = "SELECT t FROM Tables t")
    , @NamedQuery(name = "Tables.findById", query = "SELECT t FROM Tables t WHERE t.id = :id")
    , @NamedQuery(name = "Tables.findByMaxPeople", query = "SELECT t FROM Tables t WHERE t.maxPeople = :maxPeople")
    , @NamedQuery(name = "Tables.findByEmpty", query = "SELECT t FROM Tables t WHERE t.empty = :empty")})
public class Tables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "MaxPeople")
    private int maxPeople;
    @Basic(optional = false)
    @Column(name = "Empty")
    private boolean empty;
    @OneToMany(mappedBy = "tableId")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "Zone_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Zones zoneId;

    public Tables() {
    }

    public Tables(Integer id) {
        this.id = id;
    }

    public Tables(Integer id, int maxPeople, boolean empty) {
        this.id = id;
        this.maxPeople = maxPeople;
        this.empty = empty;
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

    @XmlTransient
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
        return "model.Tables[ id=" + id + " ]";
    }
    
}
