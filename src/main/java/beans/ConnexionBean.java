/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import persistence.UserAccount;

/**
 *
 * @author lamur
 */
@Named(value = "connexionBean")
@RequestScoped
public class ConnexionBean {

     private String name;
    private String mdp;
    private String status;
     @PersistenceContext(unitName = "persistence")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    /**
     * Creates a new instance of ConnexionBean
     */
    public ConnexionBean() {
    }

    public ConnexionBean(String name, String mdp) {
        this.name = name;
        this.mdp = mdp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
        public void login() {
         UserAccount acc = em.find(UserAccount.class, name);
         if (acc != null) {
             try {
                 // check password
                 byte[] salt = acc.getSalt();
                 String saltString = new String(salt, "UTF-8");
                 String checkPass = saltString+mdp;
                 MessageDigest digest = MessageDigest.getInstance("SHA-256");
                 byte[] checkPassHash = digest.digest(checkPass.getBytes("UTF-8"));
                 if (Arrays.equals(checkPassHash, acc.getPassword())) {
                     //login ok - set user in session context
                     HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                     session.setAttribute("User", acc);
                     status="Login Successful - " + "Welcome " + acc.getFirstname(); 
                      ExternalContext ec = FacesContext.getCurrentInstance()
                                .getExternalContext();
                      if(acc.getRole() == "Client")
                          
                      else if(acc.getRole()== "Agent")
                              
                      else if(acc.getRole() == "Proprietaire")
                              
                              else if(acc.getRole() == "Admin")
                       
                          
                          
                          
                          
                          
                        try {
                            ec.redirect(ec.getRequestContextPath()
                                    + "/faces/protected/admin.xhtml");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                 } else {
                    status="Invalid Login, Please Try again"; 
                 }
             } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
                 Logger.getLogger(ConnexionBean.class.getName()).log(Level.SEVERE, null, ex);
             }
         } else {
             status="Invalid Login, Please Try again";
         }
    }
    
    public String logout() {
        // invalidate session to remove User
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        // navigate to index - see faces-config.xml for navigation rules
        return "logout";
    }
    
    
}
