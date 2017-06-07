/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DBConnection.CreateSessionFactory;
import NewEntity.Documents;
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
public class DocumentsRepository implements IGeneralRepository<Documents>{
        private Session session;
  private  Transaction transaction;
    public DocumentsRepository () {
   session = CreateSessionFactory.getSessionFactory().openSession();
    }
    @Override
    public boolean Save(Documents newDoc) {
        boolean result=false;
   try{
            
       transaction = session.beginTransaction();
        session.persist(newDoc);
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
    public boolean Delete(Documents delDoc) {
         try{
            
        transaction= session.beginTransaction();
        session.delete(delDoc);
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
    public boolean Update(Documents updateDoc) {
       try {
         transaction= session.beginTransaction();
        session.update(updateDoc);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
            
             return false ;
        }
        finally{
            transaction.commit();}
    }
        
    @Override
    public List<Documents> getQuery(Criterion criterion) {
        
        List <Documents> gotDocs = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotDocs = session.createCriteria(Documents.class).add(criterion).list();
        return gotDocs;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }
    
    @Override
    public List<Documents> getAll() {
        List <Documents> gotDocuments = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotDocuments = session.createCriteria(Documents.class).list();
            return gotDocuments;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
}
}

