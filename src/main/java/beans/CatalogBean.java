/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import basiques.Adresse;
import items.Catalog;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Propriete;

/**
 *
 * @author lamur
 */
@Named(value = "catalogBean")
@SessionScoped
public class CatalogBean implements Serializable {

    /**
     * Creates a new instance of CatalagBean
     */
     
    private Catalog catalog_;
    private String catalogTitle; 
    private List<Propriete> items;
    private String id_propriete;
    private int loyer;
    private Adresse adresse;
    private String status;
   
    private enum TypePropriete {maison,appartement};
    private int nb_chambre;
    private int nb_sdb;
    private int nb_autres_salles;
    //PAS SUR ?? private ?...? location; voir diagramme UML pour comprendre
    
    private String description;
    @PersistenceContext
    EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    /**
     * Creates a new instance of CatalogBean
     */
    public CatalogBean() {
       catalog_ = new Catalog();
    }
    

    
   
    
    public void addPropriete() {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        if (catalog_.addItem(em, utx,id_propriete,loyer,nb_chambre,nb_sdb,nb_autres_salles,description,adresse )) {
           status = bundle.getString("addOk");
        } else {
           status = bundle.getString("addFail");
        }
    }
}
