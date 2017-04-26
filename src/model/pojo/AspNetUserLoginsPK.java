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
public class AspNetUserLoginsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "LoginProvider")
    private String loginProvider;
    @Basic(optional = false)
    @Column(name = "ProviderKey")
    private String providerKey;
    @Basic(optional = false)
    @Column(name = "UserId")
    private String userId;

    public AspNetUserLoginsPK() {
    }

    public AspNetUserLoginsPK(String loginProvider, String providerKey, String userId) {
        this.loginProvider = loginProvider;
        this.providerKey = providerKey;
        this.userId = userId;
    }

    public String getLoginProvider() {
        return loginProvider;
    }

    public void setLoginProvider(String loginProvider) {
        this.loginProvider = loginProvider;
    }

    public String getProviderKey() {
        return providerKey;
    }

    public void setProviderKey(String providerKey) {
        this.providerKey = providerKey;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loginProvider != null ? loginProvider.hashCode() : 0);
        hash += (providerKey != null ? providerKey.hashCode() : 0);
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AspNetUserLoginsPK)) {
            return false;
        }
        AspNetUserLoginsPK other = (AspNetUserLoginsPK) object;
        if ((this.loginProvider == null && other.loginProvider != null) || (this.loginProvider != null && !this.loginProvider.equals(other.loginProvider))) {
            return false;
        }
        if ((this.providerKey == null && other.providerKey != null) || (this.providerKey != null && !this.providerKey.equals(other.providerKey))) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.AspNetUserLoginsPK[ loginProvider=" + loginProvider + ", providerKey=" + providerKey + ", userId=" + userId + " ]";
    }
    
}
