/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opr_classes_de_base;

import basiques.Adresse;

/**
 *
 * @author crina
 */
public class Agence {
    
    private int id;
    private String nom;
    private Adresse adresse;

    public Agence(int id, String nom, Adresse adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    

    
}