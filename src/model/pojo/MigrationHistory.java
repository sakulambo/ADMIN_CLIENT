/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import model.pojo.*;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "__MigrationHistory")
@NamedQueries({
    @NamedQuery(name = "MigrationHistory.findAll", query = "SELECT m FROM MigrationHistory m")})
public class MigrationHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MigrationHistoryPK migrationHistoryPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "Model")
    private byte[] model;
    @Basic(optional = false)
    @Column(name = "ProductVersion")
    private String productVersion;

    public MigrationHistory() {
    }

    public MigrationHistory(MigrationHistoryPK migrationHistoryPK) {
        this.migrationHistoryPK = migrationHistoryPK;
    }

    public MigrationHistory(MigrationHistoryPK migrationHistoryPK, byte[] model, String productVersion) {
        this.migrationHistoryPK = migrationHistoryPK;
        this.model = model;
        this.productVersion = productVersion;
    }

    public MigrationHistory(String migrationId, String contextKey) {
        this.migrationHistoryPK = new MigrationHistoryPK(migrationId, contextKey);
    }

    public MigrationHistoryPK getMigrationHistoryPK() {
        return migrationHistoryPK;
    }

    public void setMigrationHistoryPK(MigrationHistoryPK migrationHistoryPK) {
        this.migrationHistoryPK = migrationHistoryPK;
    }

    public byte[] getModel() {
        return model;
    }

    public void setModel(byte[] model) {
        this.model = model;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (migrationHistoryPK != null ? migrationHistoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MigrationHistory)) {
            return false;
        }
        MigrationHistory other = (MigrationHistory) object;
        if ((this.migrationHistoryPK == null && other.migrationHistoryPK != null) || (this.migrationHistoryPK != null && !this.migrationHistoryPK.equals(other.migrationHistoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.pojo.MigrationHistory[ migrationHistoryPK=" + migrationHistoryPK + " ]";
    }
    
}
