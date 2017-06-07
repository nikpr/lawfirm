/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Services;
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
public class ServiceRepository implements IGeneralRepository<Services>{
       private Session session;
  private  Transaction transaction;

    public ServiceRepository() {
        this.session = DBConnection.CreateSessionFactory.getSessionFactory().openSession();
    }

    @Override
    public boolean Save(Services newService) {
         boolean result=false;
   try{
            
       transaction = session.beginTransaction();
        session.persist(newService);
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
    public boolean Delete(Services delService) {
        try{
            
        transaction= session.beginTransaction();
        session.delete(delService);
        transaction.commit();
        return true;
        }
        catch(HibernateException ex){        
            return false;
        } 
        finally{
        transaction.commit();
    }
    }

    @Override
    public boolean Update(Services updateService) {
        try{
          transaction= session.beginTransaction();
        session.update(updateService);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
             return false ;
        }
        finally{
            transaction.commit();}
    }

    @Override
    public List<Services> getQuery(Criterion criterion) {
       
        List <Services> gotClients = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotClients = session.createCriteria(Services.class).add(criterion).list();
        return gotClients;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }

    @Override
    public List<Services> getAll() {
       List <Services> gotClients = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotClients = session.createCriteria(Services.class).list();
            return gotClients;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
}
  
}
