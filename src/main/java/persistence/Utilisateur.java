/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import basiques.Adresse;

@Entity
public class Utilisateur implements Serializable {
    private static long serialVersionUID = 1L;

    
    public Utilisateur(){
        
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    @Id
    private String userId;
    private String prenom;
    private String nom;
    private String date_naissance;
    private Adresse adresse;
    private String role;
    @Lob
    private byte[] password; // salted + hashed password
    @Lob
    private byte[] salt; // the salt used for this account

    public String getUserId() {
        return userId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getUserId() != null ? getUserId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.getUserId() == null && other.getUserId() != null) || (this.getUserId() != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Utilisateur[ id=" + userId + " ]";
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the firstname
     */
    public String getprenom() {
        return prenom;
    }

    /**
     * @param firstname the prenom to set
     */
    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the nom
     */
    public String getnom() {
        return nom;
    }

    /**
     * @param nom the lastname to set
     */
    public void setnom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the birthDate
     */
    public String getdate_naissance() {
        return date_naissance;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setdate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }
    
        /**
     * @return the role
     */
    public String getrole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setrole(String role) {
        this.role = role;
    }


    /**
     * @return the password
     */
    public byte[] getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }
    
        /**
     * @return the salt
     */
    public byte[] getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    
}
