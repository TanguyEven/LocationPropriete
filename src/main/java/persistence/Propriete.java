/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import basiques.Adresse;

/**
 *
 * @author crina
 */
public class Propriete {
    
    private int loyer;
    public Adresse adresse;
    //private PhotoPropriete photo; Comment implementer une photo?
    
    private enum TypePropriete {maison,appartement};
    private int nb_chambre;
    private int nb_sdb;
    private int nb_autres_salles;
    //PAS SUR ?? private ?...? location; voir diagramme UML pour comprendre
    
    private String description;

    public Propriete(int loyer, Adresse adresse, int nb_chambre, int nb_sdb, int nb_autres_salles, String description) {
        this.loyer = loyer;
        this.adresse = adresse;
        this.nb_chambre = nb_chambre;
        this.nb_sdb = nb_sdb;
        this.nb_autres_salles = nb_autres_salles;
        this.description = description;
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
