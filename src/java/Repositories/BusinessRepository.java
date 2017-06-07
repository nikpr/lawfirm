/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Businesses;
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
public class BusinessRepository implements IGeneralRepository<Businesses>{

    
  private Session session;
  private  Transaction transaction;

    public BusinessRepository() {
        this.session = DBConnection.CreateSessionFactory.getSessionFactory().openSession();
    }
    @Override
    public boolean Save(Businesses newBusiness){
        boolean result = false;
         try{
            transaction = session.beginTransaction();
        session.persist(newBusiness);
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
    public boolean Delete(Businesses delBusiness) {
    try{
        transaction= session.beginTransaction();
        session.delete(delBusiness);
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
    public boolean Update(Businesses updateBusiness) {
        try {
         transaction= session.beginTransaction();
        session.update(updateBusiness);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
            return false ;
        }
        finally{transaction.commit();}
    }
    

    @Override
    public List<Businesses> getQuery(Criterion criterion) {
        List <Businesses> gotBusiness = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotBusiness = session.createCriteria(Businesses.class).add(criterion).list();
        return gotBusiness;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }

    @Override
    public List<Businesses> getAll() {
       List <Businesses> gotBusinesses = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotBusinesses = session.createCriteria(Businesses.class).list();
                return gotBusinesses;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
    }

}
