/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import org.hibernate.annotations.NamedNativeQueries;

/**
 *
 * @author lenovo
 */
@Entity
@Table (name ="Employees")
@NamedNativeQueries({
    @org.hibernate.annotations.NamedNativeQuery(
        name = "tacheEmploye",
        query = "SELECT * FROM tache t " +
                "INNER JOIN tacheemployee te ON t.id = te.Tache_id " +
                "INNER JOIN employees e ON e.id = te.Employe_id " +
                "WHERE te.Employe_id = :id",
        resultClass = Employe.class
    ),
    @org.hibernate.annotations.NamedNativeQuery(
        name = "projetEmploye",
        query = "SELECT * FROM employees e " +
                "INNER JOIN produit p ON p.EmployeId = e.id " +
                "WHERE e.id = :id",
        resultClass = Employe.class
    )
})
public class Employe {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(name ="nom")
   private String nom;
   @Column (name = "prenom")
   private String prenom;
   @Column (name = "Telephone")
   private String telephone;

    public Employe() {
    }

    public Employe(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + '}';
    }
   
   
   
    
    
    
}
