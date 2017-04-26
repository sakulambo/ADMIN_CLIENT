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
public class MigrationHistoryPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "MigrationId")
    private String migrationId;
    @Basic(optional = false)
    @Column(name = "ContextKey")
    private String contextKey;

    public MigrationHistoryPK() {
    }

    public MigrationHistoryPK(String migrationId, String contextKey) {
        this.migrationId = migrationId;
        this.contextKey = contextKey;
    }

    public String getMigrationId() {
        return migrationId;
    }

    public void setMigrationId(String migrationId) {
        this.migrationId = migrationId;
    }

    public String getContextKey() {
        return contextKey;
    }

    public void setContextKey(String contextKey) {
        this.contextKey = contextKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (migrationId != null ? migrationId.hashCode() : 0);
        hash += (contextKey != null ? contextKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MigrationHistoryPK)) {
            return false;
        }
        MigrationHistoryPK other = (MigrationHistoryPK) object;
        if ((this.migrationId == null && other.migrationId != null) || (this.migrationId != null && !this.migrationId.equals(other.migrationId))) {
            return false;
        }
        if ((this.contextKey == null && other.contextKey != null) || (this.contextKey != null && !this.contextKey.equals(other.contextKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.MigrationHistoryPK[ migrationId=" + migrationId + ", contextKey=" + contextKey + " ]";
    }
    
}
