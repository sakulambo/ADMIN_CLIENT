/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "Waiters")
@NamedQueries({
    @NamedQuery(name = "Waiters.findAll", query = "SELECT w FROM Waiters w")})
public class Waiters extends Staff implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue
//    @Basic(optional = false)
//    @Column(name = "Id")
//    private String id;
    @OneToMany(mappedBy = "waiterId", fetch = FetchType.LAZY)
    private Collection<Zones> zonesCollection;
//    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.LAZY)
//    private Staff staff;

    public Waiters() {
    }

    public Waiters(String id,String firstName, String lastName, String address, String phone, Date lastConnection) {
        super(id,firstName, lastName, address, phone, lastConnection);
    }

    
    

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public Collection<Zones> getZonesCollection() {
        return zonesCollection;
    }

    public void setZonesCollection(Collection<Zones> zonesCollection) {
        this.zonesCollection = zonesCollection;
    }

//    public Staff getStaff() {
//        return staff;
//    }
//
//    public void setStaff(Staff staff) {
//        this.staff = staff;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Waiters)) {
//            return false;
//        }
//        Waiters other = (Waiters) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

  
    
    
}
