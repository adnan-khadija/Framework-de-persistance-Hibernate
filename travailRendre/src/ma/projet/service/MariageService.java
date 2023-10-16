/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.List;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lenovo
 */
public class MariageService implements IDao<Mariage>{

    @Override
    public boolean create(Mariage o) {
   Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;    }

    @Override
    public Mariage getById(int id) {
    Mariage mariage = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            mariage = (Mariage) session.get(Mariage.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return mariage;        }

    @Override
    public List<Mariage> getAll() {
    List<Mariage> mariages = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            mariages = session.createQuery("from Mariage").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return mariages;    }
    
    
    
    
    public void obtenirDetailsMariagesHomme(Homme h) {
    
        if (h == null) {
            System.out.println("Homme non trouvé.");
        }

        System.out.println("Nom:              "+h.getNom());
        System.out.println("Mariage En Cours: ");

        List<Mariage> mariagesEnCours = new ArrayList<>();
        List<Mariage> mariagesEchoues = new ArrayList<>();

        for (Mariage mariage  : this.getAll() ) {
            
            if (mariage.getDateFin() == null && mariage == this.getById(h.getId())) {
                mariagesEnCours.add(mariage);
            } else if(mariage.getDateFin() != null && mariage == this.getById(h.getId())) {
                mariagesEchoues.add(mariage);
            }else
                System.out.println(" ");
            
        }

         System.out.println("Mariages En Cours :");
        for (Mariage mariage : mariagesEnCours) {
            for(int i =0 ; i<mariagesEnCours.size();i++){
              System.out.println(i+".Femme:"+ mariage.getF().getPrenom()+" "+mariage.getF().getNom()+"      Date Début:"+mariage.getDataDebut()+"       Nombre d'Enfants:"+mariage.getNbrEnfant());  
                
            }
              System.out.println("Mariages échoues :");
        for (Mariage mariage : mariagesEchoues ) {
            for(int i =0 ; i<mariagesEchoues.size();i++){
              System.out.println(i+".Femme:"+ mariage.getF().getPrenom()+" "+mariage.getF().getNom()+"      Date Début:"+mariage.getDataDebut()+"                       Date Fin:"+mariage.getDateFin()+"       Nombre d'Enfants:"+mariage.getNbrEnfant());  
                
            }
            
    }
}
}

