/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name ="Personne")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
/*@NamedQueries({
    @NamedQuery(name = "findBetweenDate", query = "SELECT m FROM Mariage m WHERE m.dateDebut >= :dateDebut AND m.dateFin <= :dateFin AND m.hommeId = :id"),
    @NamedQuery(name = "nbrEnfantBetweenDate", query = "SELECT COUNT (nbrEnfant ) FROM Mariage m WHERE m.dateDebut > :dateDebut AND m.dateFin < :dateFin AND m.femmeId = :id"),
    @NamedQuery(name = "femmeMariePlusDeux",query ="SELECT m.femmeId FROM Mariage m GROUP BY m.femme HAVING COUNT(m.hommeId) >= 2")
})*/
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @Column (name= "nom")
    protected String nom;
    @Column (name= "prnom")
    protected String prenom;  
    @Column (name= "telephone")
    protected String telephone;
    @Column (name= "adresse")
    protected String adresse;
    @Column (name= "date")
    protected Date date;

    public Personne() {
    }

    public Personne(String nom, String prenom, String telephone, String adresse, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.date = date;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDate() {
        return date;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", adresse=" + adresse + ", date=" + date + '}';
    }


     
    
}
