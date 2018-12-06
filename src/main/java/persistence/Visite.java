/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author crina
 */
@Entity
public class Visite {
    
    private String lieu_rencontre;
    private String nom;
    private Date date;
    @Id
    private Long id;

    
    public Visite(){
        
    }
    public Visite(String lieu_de_rencontre, String nom, Date date) {
        this.lieu_rencontre = lieu_de_rencontre;
        this.nom = nom;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getLieu_rencontre() {
        return lieu_rencontre;
    }

    public String getNom() {
        return nom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLieu_rencontre(String lieu_rencontre) {
        this.lieu_rencontre = lieu_rencontre;
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
