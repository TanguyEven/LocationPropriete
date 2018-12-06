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

/**
 *
 * @author Tanguy
 */
@Entity
public class Agent extends Utilisateur{
    
    private Agence agence;

    public Agent() {
    }
    

     
}
