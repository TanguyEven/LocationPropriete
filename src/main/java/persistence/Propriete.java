/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import basiques.Adresse;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author crina
 */
@Entity
@Table(name="PROPRIETE")
public class Propriete implements Serializable{
    
    @Id
    private String id_propriete;
    private int loyer;
    public Adresse adresse;
    private static long serialVersionUID = 1L;

    //private PhotoPropriete photo; Comment implementer une photo?
    
    private enum TypePropriete {maison,appartement};
    private int nb_chambre;
    private int nb_sdb;
    private int nb_autres_salles;
    //PAS SUR ?? private ?...? location; voir diagramme UML pour comprendre
    
    private String description;
    
        /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }
    

    public Propriete(int loyer, Adresse adresse, int nb_chambre, int nb_sdb, int nb_autres_salles, String description) {
        this.loyer = loyer;
        this.adresse = adresse;
        this.nb_chambre = nb_chambre;
        this.nb_sdb = nb_sdb;
        this.nb_autres_salles = nb_autres_salles;
        this.description = description;
    }

    public Propriete(String id_propriete, int loyer, Adresse adresse, int nb_chambre, int nb_sdb, int nb_autres_salles, String description) {
        this.id_propriete = id_propriete;
        this.loyer = loyer;
        this.adresse = adresse;
        this.nb_chambre = nb_chambre;
        this.nb_sdb = nb_sdb;
        this.nb_autres_salles = nb_autres_salles;
        this.description = description;
    }

    public String getId_propriete() {
        return id_propriete;
    }

    public void setId_propriete(String id_propriete) {
        this.id_propriete = id_propriete;
    }

   @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId_propriete() != null ? getId_propriete().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propriete)) {
            return false;
        }
        Propriete other = (Propriete) object;
        if ((this.getId_propriete() == null && other.getId_propriete() != null) || (this.getId_propriete() != null && !this.id_propriete.equals(other.id_propriete))) {
            return false;
        }
        return true;
    }
 
    
    public int getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getNb_chambre() {
        return nb_chambre;
    }

    public void setNb_chambre(int nb_chambre) {
        this.nb_chambre = nb_chambre;
    }

    public int getNb_sdb() {
        return nb_sdb;
    }

    public void setNb_sdb(int nb_sdb) {
        this.nb_sdb = nb_sdb;
    }

    public int getNb_autres_salles() {
        return nb_autres_salles;
    }

    public void setNb_autres_salles(int nb_autres_salles) {
        this.nb_autres_salles = nb_autres_salles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
