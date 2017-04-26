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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "AspNetRoles")
@NamedQueries({
    @NamedQuery(name = "AspNetRoles.findAll", query = "SELECT a FROM AspNetRoles a")})
public class AspNetRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @JoinTable(name = "AspNetUserRoles", joinColumns = {
        @JoinColumn(name = "RoleId", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "UserId", referencedColumnName = "Id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<AspNetUsers> aspNetUsersCollection;

    public AspNetRoles() {
    }

    public AspNetRoles(String id) {
        this.id = id;
    }

    public AspNetRoles(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<AspNetUsers> getAspNetUsersCollection() {
        return aspNetUsersCollection;
    }

    public void setAspNetUsersCollection(Collection<AspNetUsers> aspNetUsersCollection) {
        this.aspNetUsersCollection = aspNetUsersCollection;
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
        if (!(object instanceof AspNetRoles)) {
            return false;
        }
        AspNetRoles other = (AspNetRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.AspNetRoles[ id=" + id + " ]";
    }
    
}
