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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Waiters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Waiters.findAll", query = "SELECT w FROM Waiters w")
    , @NamedQuery(name = "Waiters.findById", query = "SELECT w FROM Waiters w WHERE w.id = :id")})
public class Waiters implements Serializable {

    @OneToMany(mappedBy = "waiterId")
    private Collection<Zones> zonesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AspNetUsers aspNetUsers;
    @JoinColumn(name = "Zone_Id", referencedColumnName = "Id")
    @ManyToOne
    private Zones zoneId;

    public Waiters() {
    }

    public Waiters(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AspNetUsers getAspNetUsers() {
        return aspNetUsers;
    }

    public void setAspNetUsers(AspNetUsers aspNetUsers) {
        this.aspNetUsers = aspNetUsers;
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
        if (!(object instanceof Waiters)) {
            return false;
        }
        Waiters other = (Waiters) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Waiters[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Zones> getZonesCollection() {
        return zonesCollection;
    }

    public void setZonesCollection(Collection<Zones> zonesCollection) {
        this.zonesCollection = zonesCollection;
    }

}
