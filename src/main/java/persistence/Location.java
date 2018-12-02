/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author crina
 */
public class Location {
    
    private int id_contrat;
    private int duree_mois;

    public Location(int id_contrat, int duree_mois) {
        this.id_contrat = id_contrat;
        this.duree_mois = duree_mois;
    }

    public int getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(int id_contrat) {
        this.id_contrat = id_contrat;
    }

    public int getDuree_mois() {
        return duree_mois;
    }

    public void setDuree_mois(int duree_mois) {
        this.duree_mois = duree_mois;
    }
    
    
    
}
