/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proves;

/**
 *
 * @author sakulambo
 */
public class Contacte {

    private int contacteId;
    private String nom;
    private String cognoms;

    public Contacte() {       

    }

    public int getContacteId() {
        return contacteId;
    }

    public void setContacteId(int contacteId) {
        this.contacteId = contacteId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    @Override
    public String toString() {
        return "Contacte{" + "contacteId=" + contacteId + ", nom=" + nom + ", cognoms=" + cognoms + '}';
    }

}
