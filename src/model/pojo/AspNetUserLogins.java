/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import model.pojo.*;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "AspNetUserLogins")
@NamedQueries({
    @NamedQuery(name = "AspNetUserLogins.findAll", query = "SELECT a FROM AspNetUserLogins a")})
public class AspNetUserLogins implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AspNetUserLoginsPK aspNetUserLoginsPK;
    @JoinColumn(name = "UserId", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AspNetUsers aspNetUsers;

    public AspNetUserLogins() {
    }

    public AspNetUserLogins(AspNetUserLoginsPK aspNetUserLoginsPK) {
        this.aspNetUserLoginsPK = aspNetUserLoginsPK;
    }

    public AspNetUserLogins(String loginProvider, String providerKey, String userId) {
        this.aspNetUserLoginsPK = new AspNetUserLoginsPK(loginProvider, providerKey, userId);
    }

    public AspNetUserLoginsPK getAspNetUserLoginsPK() {
        return aspNetUserLoginsPK;
    }

    public void setAspNetUserLoginsPK(AspNetUserLoginsPK aspNetUserLoginsPK) {
        this.aspNetUserLoginsPK = aspNetUserLoginsPK;
    }

    public AspNetUsers getAspNetUsers() {
        return aspNetUsers;
    }

    public void setAspNetUsers(AspNetUsers aspNetUsers) {
        this.aspNetUsers = aspNetUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aspNetUserLoginsPK != null ? aspNetUserLoginsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspNetUserLogins)) {
            return false;
        }
        AspNetUserLogins other = (AspNetUserLogins) object;
        if ((this.aspNetUserLoginsPK == null && other.aspNetUserLoginsPK != null) || (this.aspNetUserLoginsPK != null && !this.aspNetUserLoginsPK.equals(other.aspNetUserLoginsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.AspNetUserLogins[ aspNetUserLoginsPK=" + aspNetUserLoginsPK + " ]";
    }
    
}
