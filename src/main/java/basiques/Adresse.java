/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basiques;

/**
 *
 * @author crina
 */
public class Adresse {
    
    private int numero;
    private String rue;
    private String ville;
    private String etat;
    private String code_postal;

    public Adresse(int numero, String rue, String ville, String etat, String code_postal) {
        this.numero = numero;
        this.rue = rue;
        this.ville = ville;
        this.etat = etat;
        this.code_postal = code_postal;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public String getEtat() {
        return etat;
    }

    public int getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
}
