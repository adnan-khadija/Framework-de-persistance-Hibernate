/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.text.SimpleDateFormat;
import java.util.List;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lenovo
 */
public class ProjetService implements IDao<Projet>{

    @Override
    public boolean create(Projet o) {
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
        return false;
    }

    @Override
    public Projet getById(int id) {
        Projet projet = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return projet;    }


    @Override
    public List<Projet> getAll() {
      List<Projet> projets = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return projets;     }
    
    public List<Tache> listerTachesPlanifieesPourProjet(Projet projet) {
              List<Tache> taches=null;
        Session session = null;
        Transaction tx = null;
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches =session.getNamedQuery("tacheProjet").setParameter("id",projet.getId() ).list();
           
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return taches; 
    }
    
     public void afficherTachesRealiseesDansProjet(Projet p){
     
         System.out.println("Projet :"+p.getId()+"          Nom:"+p.getNom()+" Date debut: "+p.getDd());
         System.out.println("Liste des taches :");
         System.out.println("num                Nom                  Date Début Reélle             Date Fin Réelle");
          Session session = null;
        Transaction tx = null;
        try {
            session =HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            for (Tache t: this.listerTachesPlanifieesPourProjet(p)){
             System.out.println(t.getId()+"                "+t.getNom()+"                  "+t.getDatedebut()+"             "+t.getDateFin());
         }
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        
       
        
      
    }
    
}
