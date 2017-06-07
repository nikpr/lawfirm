/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Consumptions;
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
public class ConsumptionRepository implements IGeneralRepository<Consumptions>{

    private Session session;
            private Transaction transaction;

    public ConsumptionRepository() {
        this.session = DBConnection.CreateSessionFactory.getSessionFactory().openSession();
    }
            
    @Override
    public boolean Save(Consumptions newConsumption) {
     boolean result=false;
   try{
            
       transaction = session.beginTransaction();
        session.persist(newConsumption);
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
    public boolean Delete(Consumptions delConsum) {
      throw new UnsupportedOperationException("Нельзя!");
    }

    @Override
    public boolean Update(Consumptions updateConsumption) {
       try {
         transaction= session.beginTransaction();
        session.update(updateConsumption);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
            
             return false ;
        }
        finally{
            transaction.commit();}
    }

    @Override
    public List<Consumptions> getQuery(Criterion criterion) {
      
        List <Consumptions> gotConsumptions = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotConsumptions = session.createCriteria(Consumptions.class).add(criterion).list();
        return gotConsumptions;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }    
    @Override
    public List<Consumptions> getAll() {
        List <Consumptions> gotConsumptions = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotConsumptions = session.createCriteria(Consumptions.class).list();
            return gotConsumptions;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
}
}