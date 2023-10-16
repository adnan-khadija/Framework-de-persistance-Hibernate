/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.NamedNativeQueries;

/**
 *
 * @author lenovo
 */
@Entity
@Table (name="Tache" )
@NamedNativeQueries({
@org.hibernate.annotations.NamedNativeQuery(name = "tachesPrixSuperieur",query = "select * from tache where prix > 1000",resultClass = Tache.class),
@org.hibernate.annotations.NamedNativeQuery(name ="betweenDate",query ="SELECT * FROM `tache` WHERE dateDebut> :d1 AND dateFin<:d2",resultClass = Tache.class) })
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(TemporalType.DATE )
    @Column (name = " dateDebut")
    private Date datedebut;
    @Temporal(TemporalType.DATE )
    @Column (name =" dateFin")
    private Date dateFin;
    @Column(name="prix")
    private double prix;
     @ManyToOne
     @JoinColumn (name =" projet_id")
     private Projet prj;

    public Tache() {
    }

    public Tache(String nom, Date datedebut, Date dateFin, double prix, Projet prj) {
        this.nom = nom;
        this.datedebut = datedebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.prj = prj;
    }

    public Projet getPrj() {
        return prj;
    }

    public void setPrj(Projet prj) {
        this.prj = prj;
    }

 

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Tache{" + "id=" + id + ", nom=" + nom + ", datedebut=" + datedebut + ", dateFin=" + dateFin + ", prix=" + prix + ", prj=" + prj + '}';
    }

    
    
}
