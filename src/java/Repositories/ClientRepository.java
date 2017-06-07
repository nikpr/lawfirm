/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DBConnection.CreateSessionFactory;
import NewEntity.Clients;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Nik
 */
public class ClientRepository implements IGeneralRepository<Clients>{

    private Session session;
  private  Transaction transaction;
    public ClientRepository() {
   session = CreateSessionFactory.getSessionFactory().openSession();
    }
    @Override
    public boolean Save(Clients newClient) {
        boolean result=false;
   try{
            
       transaction = session.beginTransaction();
        session.persist(newClient);
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
    public boolean Delete(Clients delClient) {
         try{
            
        transaction= session.beginTransaction();
        session.delete(delClient);
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
    public boolean Update(Clients updateClient) {
       try {
         transaction= session.beginTransaction();
        session.update(updateClient);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
            
             return false ;
        }
        finally{
            transaction.commit();}
    }
        
    @Override
    public List<Clients> getQuery(Criterion criterion) {
        
        List <Clients> gotClients = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotClients = session.createCriteria(Clients.class).add(criterion).list();
        return gotClients;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }
    
    @Override
    public List<Clients> getAll() {
        List <Clients> gotClients = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotClients = session.createCriteria(Clients.class).list();
            ///session.flush();
           // Hibernate.initialize(gotClients);
            return gotClients;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
}
}
