/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lenovo
 */
@Entity
@Table (name = "produits")
public class Produit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "marque")
    private String marque;
    @Column(name = " reference")
    private String reference ;
    @Temporal(TemporalType.DATE)
    private Date datAchat ;
    @Column (name = "prix")
    private double prix;
    @Column (name = "desigantion")
    private String designation ;

    public Produit() {
    }

    public Produit( String marque, String reference, Date datAchat, double prix, String designation) {
        this.marque = marque;
        this.reference = reference;
        this.datAchat = datAchat;
        this.prix = prix;
        this.designation = designation;
    }
    

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getReference() {
        return reference;
    }

    public Date getDatAchat() {
        return datAchat;
    }

    public double getPrix() {
        return prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDatAchat(Date datAchat) {
        this.datAchat = datAchat;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", marque=" + marque + ", reference=" + reference + ", datAchat=" + datAchat + ", prix=" + prix + ", designation=" + designation + '}';
    }
    
    
}
