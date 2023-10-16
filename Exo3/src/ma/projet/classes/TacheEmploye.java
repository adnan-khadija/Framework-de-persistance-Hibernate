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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name= "TacheEmployee")

public class TacheEmploye {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE )
    @Column (name=" dateDebuRelle")
    private Date dateDebutReelle;
    @Temporal(TemporalType.DATE )
    @Column (name="dateFinReelle")
    private Date dateFinReelle;
    @ManyToOne 
    @JoinColumn (name=" Tache_id")
    private Tache tache;
    @ManyToOne 
    @JoinColumn (name="Employe_id ")
    private Employe employe;

    public TacheEmploye() {
    }

    public TacheEmploye(Date dateDebutReelle, Date dateFinReelle, Tache tache, Employe employe) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.tache = tache;
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    @Override
    public String toString() {
        return "TacheEmploye{" + "dateDebutReelle=" + dateDebutReelle + ", dateFinReelle=" + dateFinReelle + ", tache=" + tache + ", employe=" + employe + '}';
    }
    
    
    
    
}
