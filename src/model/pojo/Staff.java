/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sakulambo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Staff")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue

    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "FirstName")
    protected String firstName;
    @Column(name = "LastName")
    protected String lastName;
    @Column(name = "Address")
    protected String address;
    @Column(name = "Phone")
    protected String phone;
    @Basic(optional = false)
    @Column(name = "LastConnection")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastConnection;
//    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
//    @OneToOne(optional = false, fetch = FetchType.LAZY)
//    private AspNetUsers aspNetUsers;
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "staff", fetch = FetchType.LAZY)
//    private Waiters waiters;

    public Staff() {
    }

    public Staff(String id) {
        this.id = id;
    }

    public Staff(String id, Date lastConnection) {
        this.id = id;
        this.lastConnection = lastConnection;
    }

    public Staff(String firstName, String lastName, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public Staff(String firstName, String lastName, String address, String phone, Date lastConnection) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.lastConnection = lastConnection;
    }

    public Staff(String id, String firstName, String lastName, String address, String phone, Date lastConnection) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.lastConnection = lastConnection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }

//    public AspNetUsers getAspNetUsers() {
//        return aspNetUsers;
//    }
//
//    public void setAspNetUsers(AspNetUsers aspNetUsers) {
//        this.aspNetUsers = aspNetUsers;
//    }
//    public Waiters getWaiters() {
//        return waiters;
//    }
//
//    public void setWaiters(Waiters waiters) {
//        this.waiters = waiters;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.Staff[ id=" + id + " ]";
    }

}
