/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;

/**
 *
 * @author crina
 */
@Entity
public class Proprietaire extends Utilisateur {
    
    private Collection<Propriete> liste_propiete;
    
    public Proprietaire(){
    }
    
}
