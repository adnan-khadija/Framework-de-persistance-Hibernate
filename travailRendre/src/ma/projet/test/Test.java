/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.beans.Personne;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;

/**
 *
 * @author lenovo
 */
public class Test {
    public static void main(String[] args) {
        FemmeService fs=new FemmeService();
        HommeService hs=new HommeService();
        MariageService ms=new MariageService();
        
        //Definition des personne hommes et femmes
         Personne p1=new Homme("shohadi", "Ali", "0657983432", "Fés", new Date(89,03,12));
          Personne p2=new Femme("Jlili", "Mareim", "0662376623", "Casablanca", new Date(96,07,27));
          Personne p3=new Femme("dahi", "Soad", "0662296623", "Casablanca", new Date(90,04,27));
          Personne p4=new Femme("Razi", "Jamila", "0662372003", "Fés", new Date(94,07,2));
           Personne p5=new Femme("Dohab", "Fatima", "0662376773", "El Jadida", new Date(97,07,7));
          Personne p6=new Homme("shohad", "Mohammed", "0657123432", "Berrchid", new Date(90,03,12));
          Personne p7=new Femme("bada", "Mareim", "0628376623", "Casablanca", new Date(96,07,27));
          Personne p8=new Femme("dahmani", "Soad", "0662296623", "Casablanca", new Date(91,04,2));
          Personne p9=new Femme("Rami", "Jamila", "0662372003", "Settat", new Date(95,07,28));
           Personne p10=new Femme("Nori", "Majda", "0662376773", "El Jadida", new Date(97,9,17));
          Personne p11=new Homme("Morabit", "Ahmed", "0757122342", "Sali", new Date(90,03,3));
         Personne p12=new Homme("Massrar", "Mohammed", "0744123432", "Rabat", new Date(88,03,12));

        //Creation des objets Femme et Homme 
         fs.create((Femme) p2);
          fs.create((Femme) p3);
          fs.create((Femme) p4);
          fs.create((Femme) p5);
          fs.create((Femme) p7);
          fs.create((Femme) p8);
          fs.create((Femme) p9);
          fs.create((Femme) p10);
         hs.create((Homme) (p11));
          hs.create((Homme) (p12));
         hs.create((Homme) (p1));
        hs.create((Homme) (p6));
        //Definition des Mariages
         Mariage m1=new Mariage(new Date(115,3,3), new Date(), 2, hs.getById(9), fs.getById(1));
          Mariage m2=new Mariage(new Date(110,3,3), new Date(), 1, hs.getById(9), fs.getById(2));
           Mariage m3=new Mariage(new Date(117,3,3), new Date(), 3, hs.getById(9), fs.getById(3));
            Mariage m4=new Mariage(new Date(120,3,3),null, 0, hs.getById(9), fs.getById(4));
            Mariage m5=new Mariage(new Date(121,3,3), new Date(), 1, hs.getById(10), fs.getById(7));
          ms.create(m3);
          ms.create(m2);
          ms.create(m4);
          ms.create(m1);
          ms.create(m5);
        /*  
          //Affichage de la liste des femmes 
          for (Femme f: fs.getAll()){
              System.out.println(f);
          }
          //Affichade de la femme les plus agée
          
           for (Femme f: fs.getAll()){
             Date maxAge = fs.getAll().get(0).getDate();
             if(f.getDate().before(maxAge)){
               maxAge=f.getDate();
             }   
          } 
           
           //Affichage des epouses d'un homme
        for(Femme f :hs.getEpousesEntreDates(2, new Date (100-2-2), new Date(124-1-1))){
            System.out.println(f);
        }
        //Affichage de nombre des enfants d'une femme
        fs.nbrEnfantFemme(1, new Date (100-2-2),new Date(124-1-1));
    //Affichage de la liste des emmes mariées deux fois ou plus 
        for(Femme f: fs.nbrMariageFemme()){
            System.out.println(f);
            
        }
        //Affichage des hommes qui sont marié par 4 femme 
        
              hs.nbrHommeMarie4Femme(new Date (115,1,1), new Date());
           
              //Affichage des mariages d'un homme 
              ms.obtenirDetailsMariagesHomme(hs.getById(9));
   */
                }
    
}
