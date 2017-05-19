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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Zones")
@NamedQueries({
    @NamedQuery(name = "Zones.findAll", query = "SELECT z FROM Zones z")})
public class Zones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Location")
    private String location;
    @JoinColumn(name = "Waiter_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Waiters waiterId;
    @OneToMany(mappedBy = "zoneId", fetch = FetchType.LAZY)
    private Collection<Tables> tablesCollection;

    public Zones() {
    }

    public Zones(String location) {
        this.location = location;
    }

    public Zones(Integer id) {
        this.id = id;
    }

    public Zones(Integer id, String location) {
        this.id = id;
        this.location = location;
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

    public Waiters getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Waiters waiterId) {
        this.waiterId = waiterId;
    }

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
        return "model.pojo.Zones[ id=" + id + " ]";
    }

}
