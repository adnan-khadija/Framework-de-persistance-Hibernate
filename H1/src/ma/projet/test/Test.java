/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.service.ProduitService;
import ma.projet.entity.Produit;
import org.hibernate.Hibernate;
import ma.projet.util.HibernateUtil;
/**
 *
 * @author lenovo
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        ProduitService ps = new ProduitService();
        // Creation de cinq produits
    /*ps.create(new Produit("Samsung", "GA53",new Date ("2022/12/12"),3887 ,"Samsung Galaxy A53" ));
    ps.create(new Produit("Ford", "FR12",new Date (),250000 ,"FORD Focus" ));
    ps.create(new Produit("Ford", "FR92",new Date (),310000 ,"FORD Kuga" ));
    ps.create(new Produit("LG", "LG43",new Date (),15000 ,"Smart TV 2023 LG OLED evo C3 4K 65 pouces" ));
     ps.create(new Produit("Samsung", "GA53",new Date (),7500 ,"Samsung Galaxy S23" ));
     //L'affichage des cinq produits
     for (Produit p : ps.findAll()){
       System.out.println(p);
     }
     //Les informations du produit de l'id 2
       System.out.println(ps.findById(2));
       //La modification des informations du produit de l'id 3
    Produit p= ps.findById(3);
    p.setDesignation("aaa");
        ps.delete(ps.findById(3));
        
     // L'affichage des produits ont le prix >100
        for (Produit o: ps.findAll()){
            if(o.getPrix()> 100)
            System.out.println(p);
        }*/
        //L'affichage des produits comander entre deux dates
        Scanner sc =new Scanner(System.in);
        System.out.println("Donnez la première date:");
        String s1=sc.nextLine();
        System.out.println("Donnez la dexième date:");
        String s2 = sc.nextLine();
        
        for (Produit c : ps.findAll()){
           
            Date d1= new SimpleDateFormat("yyyy-MM-dd").parse(s1);
            Date d2= new SimpleDateFormat("yyyy-MM-dd").parse(s2);
            if (c.getDatAchat().compareTo(d1)>=0 && c.getDatAchat().compareTo(d2)<=0)
                System.out.println(c);
            
            
        }

    }
   
}
 