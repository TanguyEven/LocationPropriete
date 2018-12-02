/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import basiques.Adresse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import persistence.Propriete;

/**
 *
 * @author lamur
 */
public class Catalog {
    
     public Catalog(){
         
    }
     
    
        public void persist(EntityManager em, UserTransaction utx, Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Find an Item based on Id
     * @param em
     * @param itemId
     * @return 
     */
    public Propriete findItem(EntityManager em, String itemId) {
                Propriete u = em.find(Propriete.class, itemId);
             return u ;
    }

    /**
     * Find all items (books) for a given category
     * @param em
     * @param KIDS
     * @return 
     */
    public List<Propriete> findByCategory(EntityManager em, String Category) {
       ArrayList<Propriete> livres = new ArrayList<>();
        Query query = em.createQuery(
                        "SELECT c FROM PROPRIETE p " +
                        " WHERE c.category = '"+Category+"'");
                
               livres =  (ArrayList)performQuery(query);
                
       
       return livres;
    }
    
    /**
     * Persists an Item
     * @param em
     * @param utx
     * @param id
     * @param shortDescription
     * @param longDescription
     * @param cost
     * @param category
     * @return 
     */
    public boolean addItem(EntityManager em, UserTransaction utx, String id, int loyer, int nb_chambre, int nb_sdb, int nb_salle, String description, Adresse adresse) {
    
        Propriete _prop = new Propriete(id,loyer,adresse,nb_chambre,nb_sdb,nb_salle,description);
        try {
            utx.begin();
            em.persist(_prop);
            utx.commit();
            return true;
        } catch (IllegalArgumentException | NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
            ex.printStackTrace();
        }
         return false; 
    }
    
    
       private static List performQuery(final Query query) {
        List resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        } 
        ArrayList<Propriete> results = new ArrayList<>();
        results.addAll(resultList);
        return results;
    }
}
