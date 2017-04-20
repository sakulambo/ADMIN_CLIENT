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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sakulambo
 */
@Entity
@Table(name = "AspNetUsers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AspNetUsers.findAll", query = "SELECT a FROM AspNetUsers a")
    , @NamedQuery(name = "AspNetUsers.findById", query = "SELECT a FROM AspNetUsers a WHERE a.id = :id")
    , @NamedQuery(name = "AspNetUsers.findByEmail", query = "SELECT a FROM AspNetUsers a WHERE a.email = :email")
    , @NamedQuery(name = "AspNetUsers.findByEmailConfirmed", query = "SELECT a FROM AspNetUsers a WHERE a.emailConfirmed = :emailConfirmed")
    , @NamedQuery(name = "AspNetUsers.findByPasswordHash", query = "SELECT a FROM AspNetUsers a WHERE a.passwordHash = :passwordHash")
    , @NamedQuery(name = "AspNetUsers.findBySecurityStamp", query = "SELECT a FROM AspNetUsers a WHERE a.securityStamp = :securityStamp")
    , @NamedQuery(name = "AspNetUsers.findByPhoneNumber", query = "SELECT a FROM AspNetUsers a WHERE a.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "AspNetUsers.findByPhoneNumberConfirmed", query = "SELECT a FROM AspNetUsers a WHERE a.phoneNumberConfirmed = :phoneNumberConfirmed")
    , @NamedQuery(name = "AspNetUsers.findByTwoFactorEnabled", query = "SELECT a FROM AspNetUsers a WHERE a.twoFactorEnabled = :twoFactorEnabled")
    , @NamedQuery(name = "AspNetUsers.findByLockoutEndDateUtc", query = "SELECT a FROM AspNetUsers a WHERE a.lockoutEndDateUtc = :lockoutEndDateUtc")
    , @NamedQuery(name = "AspNetUsers.findByLockoutEnabled", query = "SELECT a FROM AspNetUsers a WHERE a.lockoutEnabled = :lockoutEnabled")
    , @NamedQuery(name = "AspNetUsers.findByAccessFailedCount", query = "SELECT a FROM AspNetUsers a WHERE a.accessFailedCount = :accessFailedCount")
    , @NamedQuery(name = "AspNetUsers.findByUserName", query = "SELECT a FROM AspNetUsers a WHERE a.userName = :userName")})
public class AspNetUsers implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aspNetUsers")
    private Staff staff;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "EmailConfirmed")
    private boolean emailConfirmed;
    @Column(name = "PasswordHash")
    private String passwordHash;
    @Column(name = "SecurityStamp")
    private String securityStamp;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "PhoneNumberConfirmed")
    private boolean phoneNumberConfirmed;
    @Basic(optional = false)
    @Column(name = "TwoFactorEnabled")
    private boolean twoFactorEnabled;
    @Column(name = "LockoutEndDateUtc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockoutEndDateUtc;
    @Basic(optional = false)
    @Column(name = "LockoutEnabled")
    private boolean lockoutEnabled;
    @Basic(optional = false)
    @Column(name = "AccessFailedCount")
    private int accessFailedCount;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @ManyToMany(mappedBy = "aspNetUsersCollection")
    private Collection<AspNetRoles> aspNetRolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aspNetUsers")
    private Collection<AspNetUserLogins> aspNetUserLoginsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "aspNetUsers")
    private Waiters waiters;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<AspNetUserClaims> aspNetUserClaimsCollection;

    public AspNetUsers() {
    }

    public AspNetUsers(String id) {
        this.id = id;
    }

    public AspNetUsers(String id, boolean emailConfirmed, boolean phoneNumberConfirmed, boolean twoFactorEnabled, boolean lockoutEnabled, int accessFailedCount, String userName) {
        this.id = id;
        this.emailConfirmed = emailConfirmed;
        this.phoneNumberConfirmed = phoneNumberConfirmed;
        this.twoFactorEnabled = twoFactorEnabled;
        this.lockoutEnabled = lockoutEnabled;
        this.accessFailedCount = accessFailedCount;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    public boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Date getLockoutEndDateUtc() {
        return lockoutEndDateUtc;
    }

    public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
        this.lockoutEndDateUtc = lockoutEndDateUtc;
    }

    public boolean getLockoutEnabled() {
        return lockoutEnabled;
    }

    public void setLockoutEnabled(boolean lockoutEnabled) {
        this.lockoutEnabled = lockoutEnabled;
    }

    public int getAccessFailedCount() {
        return accessFailedCount;
    }

    public void setAccessFailedCount(int accessFailedCount) {
        this.accessFailedCount = accessFailedCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlTransient
    public Collection<AspNetRoles> getAspNetRolesCollection() {
        return aspNetRolesCollection;
    }

    public void setAspNetRolesCollection(Collection<AspNetRoles> aspNetRolesCollection) {
        this.aspNetRolesCollection = aspNetRolesCollection;
    }

    @XmlTransient
    public Collection<AspNetUserLogins> getAspNetUserLoginsCollection() {
        return aspNetUserLoginsCollection;
    }

    public void setAspNetUserLoginsCollection(Collection<AspNetUserLogins> aspNetUserLoginsCollection) {
        this.aspNetUserLoginsCollection = aspNetUserLoginsCollection;
    }

    public Waiters getWaiters() {
        return waiters;
    }

    public void setWaiters(Waiters waiters) {
        this.waiters = waiters;
    }

    @XmlTransient
    public Collection<AspNetUserClaims> getAspNetUserClaimsCollection() {
        return aspNetUserClaimsCollection;
    }

    public void setAspNetUserClaimsCollection(Collection<AspNetUserClaims> aspNetUserClaimsCollection) {
        this.aspNetUserClaimsCollection = aspNetUserClaimsCollection;
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
        if (!(object instanceof AspNetUsers)) {
            return false;
        }
        AspNetUsers other = (AspNetUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AspNetUsers[ id=" + id + " ]";
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}
