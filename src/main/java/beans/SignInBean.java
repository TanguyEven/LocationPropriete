/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistence.Utilisateur;

/**
 *
 * @author ssome
 */
@Named(value = "signInBean")
@RequestScoped
public class SignInBean {
    private String userId;
    private String firstname;
    private String lastname;
    private String birthDate;
    private String city;
    private String password;
    private String role;

    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    private String status;

    public SignInBean() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }
    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    public void addUser() {
        try {
            Utilisateur acc = new Utilisateur();
            acc.setUserId(userId);
            acc.setFirstname(firstname);
            acc.setLastname(lastname);
            acc.setCity(city);
            acc.setBirthDate(Date.valueOf(birthDate));
            acc.setRole(role);
            // randomly generate salt value
            final Random r = new SecureRandom();
            byte[] salt = new byte[32];
            r.nextBytes(salt);
            String saltString = new String(salt, "UTF-8");
            // hash password using SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String saltedPass = saltString+password;
            byte[] passhash = digest.digest(saltedPass.getBytes("UTF-8"));
            acc.setSalt(salt);
            acc.setPassword(passhash);
            persist(acc);
            status="New Account Created Fine";
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | RuntimeException ex ) {
            Logger.getLogger(SignInBean.class.getName()).log(Level.SEVERE, null, ex);
            status="Error While Creating New Account";
        }
    }
    
}
