/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author crina
 */
@Entity
public class Newspaper {
    
    private String nom;
    @Id
    private Long id;

    
    public Newspaper(){
        
    }
    public Newspaper(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
