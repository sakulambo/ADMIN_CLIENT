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
@Table(name = "Zones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zones.findAll", query = "SELECT z FROM Zones z")
    , @NamedQuery(name = "Zones.findById", query = "SELECT z FROM Zones z WHERE z.id = :id")
    , @NamedQuery(name = "Zones.findByLocation", query = "SELECT z FROM Zones z WHERE z.location = :location")})
public class Zones implements Serializable {

    @JoinColumn(name = "Waiter_Id", referencedColumnName = "Id")
    @ManyToOne
    private Waiters waiterId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Location")
    private String location;
    @OneToMany(mappedBy = "zoneId")
    private Collection<Waiters> waitersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoneId")
    private Collection<Tables> tablesCollection;

    public Zones() {
    }

    public Zones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlTransient
    public Collection<Waiters> getWaitersCollection() {
        return waitersCollection;
    }

    public void setWaitersCollection(Collection<Waiters> waitersCollection) {
        this.waitersCollection = waitersCollection;
    }

    @XmlTransient
    public Collection<Tables> getTablesCollection() {
        return tablesCollection;
    }

    public void setTablesCollection(Collection<Tables> tablesCollection) {
        this.tablesCollection = tablesCollection;
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
        if (!(object instanceof Zones)) {
            return false;
        }
        Zones other = (Zones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Zones[ id=" + id + " ]";
    }

    public Waiters getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Waiters waiterId) {
        this.waiterId = waiterId;
    }
    
}
