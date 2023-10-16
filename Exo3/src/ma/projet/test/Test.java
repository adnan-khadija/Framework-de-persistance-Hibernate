/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.classes.TacheEmploye;
import ma.projet.service.EmployeService;
import ma.projet.service.EmployeTacheService;
import ma.projet.service.ProjetService;
import ma.projet.service.TacheService;

/**
 *
 * @author lenovo
 */
public class Test {
    
    public static void main(String[] args) {
        
       EmployeService es =new EmployeService();
       TacheService tc =new TacheService();
       EmployeTacheService ets =new EmployeTacheService();
       ProjetService ps =new ProjetService();
       //Creation des employes
     /*  es.create(new Employe("Jadouali", "Mohammed", "0668453433"));
       es.create(new Employe("Hassimi", "Sara", "0668583420"));
       
       // Creation des projets 
       ps.create(new Projet("Application IOT", new Date(122,1,1), new Date(), es.getById(1)));
       ps.create(new Projet("Apps AI", new Date(122,2,3), new Date(), es.getById(2)));

       
       // Cration des Taches
       tc.create(new Tache("Conseption", new Date(122,7,12), new Date(), 30244, ps.getById(1)));
       tc.create(new Tache("Mise en place", new Date(122,5,6), new Date(), 504444, ps.getById(2)));
       
       //Creation des objets Employes par tache
       ets.create(new TacheEmploye(new Date(122,8,1), new Date(), tc.getById(1), es.getById(1)));
       ets.create(new TacheEmploye(new Date(122,6,4), new Date(), tc.getById(2), es.getById(2)));

*/
     /*for (Tache t:  es.listerTachesRealiseesParEmploye(es.getById(1))){
         System.out.println(t);
     }*/
    }
}
