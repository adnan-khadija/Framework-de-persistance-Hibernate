/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
import ma.projet.beans.Personne;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;

/**
 *
 * @author lenovo
 */
public class HommeService implements IDao<Homme>{

    @Override
    public boolean create(Homme o) {
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
    public Homme getById(int id) {
     Homme homme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return homme;        }

    @Override
    public List<Homme> getAll() {
List<Homme> hommes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return hommes;    }
 
    
    public int nbrHommeMarie4Femme(Date d1, Date d2) {
    int nbr = 0;
    Session session = null;
    Transaction tx = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Homme.class, "h");
        DetachedCriteria subquery = DetachedCriteria.forClass(Mariage.class, "m")
            .add(Restrictions.eqProperty("m.hommeId", "h.id"))
            .setProjection(Projections.count("m.femmeId"));
        criteria.add(Subqueries.gt(4, subquery));

        criteria.add(Restrictions.ge("dateDebut", d1));
        criteria.add(Restrictions.le("dateFin", d2));

        nbr = ((Long) criteria.uniqueResult()).intValue(); // Récupérez le résultat de la requête

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null)
            tx.rollback();
        e.printStackTrace();
    } finally {
        if (session != null)
            session.close();
    }
    return nbr;
}

    
    
    public List<Femme> getEpousesEntreDates(int id, Date dateDebut, Date dateFin) {
        List<Femme> epouses = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Query query =session.getNamedQuery("findBetweenDate");
            query.setParameter("dateDebut", dateDebut);
            query.setParameter("dateFin", dateFin);
            query.setParameter("id", id);

            epouses = query.list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
        } finally {
            if (session != null)
                session.close();
        }
        return epouses;
    }
    
    
  
    
}


    


