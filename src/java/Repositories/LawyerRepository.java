/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Lawyers;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Nik
 */
public class LawyerRepository  implements IGeneralRepository<Lawyers>{
private Session session;
  private  Transaction transaction;

    public LawyerRepository() {
        this.session = DBConnection.CreateSessionFactory.getSessionFactory().openSession();
    }
  
    @Override
    public boolean Save(Lawyers newLawyer) {
         boolean result = false;
         try{
            transaction = session.beginTransaction();
        session.persist(newLawyer);
      //  transaction.commit();
       result = true;
        }
        catch(PersistentObjectException ex){     
            transaction.rollback();
            } 
        finally{
        transaction.commit();
    }
         return result;
    }

    @Override
    public boolean Delete(Lawyers delLawyer) {
      try{
        transaction= session.beginTransaction();
        session.delete(delLawyer);
        transaction.commit();
        return true;
        }
        catch(HibernateException ex){        
            return false;
        } 
        finally{transaction.commit();
    }
    }

    @Override
    public boolean Update(Lawyers updateLawyer) {
         try {
         transaction= session.beginTransaction();
        session.update(updateLawyer);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
            return false ;
        }
        finally{transaction.commit();}
    }

    @Override
    public List<Lawyers> getQuery(Criterion criterion) {
     List <Lawyers> gotLawyers = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotLawyers = session.createCriteria(Lawyers.class).add(criterion).list();
        return gotLawyers;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }

    @Override
    public List<Lawyers> getAll() {
         List <Lawyers> gotLawyers = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotLawyers= session.createCriteria(Lawyers.class).list();
                return gotLawyers;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
    }

    
    
}
