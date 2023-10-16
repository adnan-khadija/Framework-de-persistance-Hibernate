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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "Mariage")
public class Mariage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    @Column (name=" dateDebut")
    private Date dateDebut;
    @Temporal (TemporalType.DATE)
    @Column (name="dateFin")
    private Date dateFin;
    @Column (name="nbrEnfant")
    private int nbrEnfant;
    @ManyToOne
    @JoinColumn (name=" hommeId")
    private Homme h;
    @ManyToOne
    @JoinColumn (name=" femmeId")
    private Femme f;

    public Mariage(Date dataDebut, Date dateFin, int nbrEnfant, Homme h, Femme f) {
        this.dateDebut = dataDebut;
        this.dateFin = dateFin;
        this.nbrEnfant = nbrEnfant;
        this.h = h;
        this.f = f;
    }

    public Homme getH() {
        return h;
    }

    public Femme getF() {
        return f;
    }

    public void setH(Homme h) {
        this.h = h;
    }

    public void setF(Femme f) {
        this.f = f;
    }
    
   

    public Mariage() {
    }

    public int getId() {
        return id;
    }

    public Date getDataDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setDataDebut(Date dataDebut) {
        this.dateDebut = dataDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    @Override
    public String toString() {
        return "Mariage{" + "id=" + id + ", dataDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbrEnfant=" + nbrEnfant + ", h=" + h + ", f=" + f + '}';
    }

   
    
    
    
    
}
