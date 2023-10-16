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

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "Projet")
@NamedNativeQuery (name = "tacheProjet",query = "SELECT * from tache t inner join projet p on P.id=t.projet_id where p.id =:id",resultClass = Projet.class)
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="nom")
    private String nom;
    @Temporal(TemporalType.DATE )
    @Column (name="dateDebut")
    private Date dd;
    @Temporal(TemporalType.DATE )
    @Column (name="dateFin ")
    private Date df;
    @ManyToOne 
     @JoinColumn (name ="EmployeId")
    private Employe emp;

    public Projet() {
    }

    public Projet(String nom, Date dd, Date df, Employe emp) {
        this.nom = nom;
        this.dd = dd;
        this.df = df;
        this.emp = emp;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDd() {
        return dd;
    }

    public Date getDf() {
        return df;
    }

    public Employe getEmp() {
        return emp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDd(Date dd) {
        this.dd = dd;
    }

    public void setDf(Date df) {
        this.df = df;
    }

    public void setEmp(Employe emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", dd=" + dd + ", df=" + df + ", emp=" + emp + '}';
    }
    
    
    
    
}
