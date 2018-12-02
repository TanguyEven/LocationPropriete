/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.Date;

/**
 *
 * @author crina
 */
public class Interview {
    
    private Date date;
    private enum preference {positif, nul, negatif};
    private String rapport; //ici faudrait importer un pdf ou quoi?? 

    public Interview(Date date, String rapport) {
        this.date = date;
        this.rapport = rapport;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    
    
}
