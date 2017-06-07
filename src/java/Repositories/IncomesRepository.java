/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DBConnection.CreateSessionFactory;
import NewEntity.Incomes;
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
public class IncomesRepository  implements IGeneralRepository<Incomes>{
    private Session session;
  private  Transaction transaction;
    public IncomesRepository() {
   session = CreateSessionFactory.getSessionFactory().openSession();
    }
    @Override
    public boolean Save(Incomes newIncome) {
        boolean result=false;
   try{
            
       transaction = session.beginTransaction();
        session.persist(newIncome);
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
    public boolean Delete(Incomes delIncome) {
      throw new UnsupportedOperationException("Нельзя удялять доходы!");
    }

    @Override
    public boolean Update(Incomes updateIncome) {
       try {
         transaction= session.beginTransaction();
        session.update(updateIncome);
        transaction.commit();
        return true;
        }catch(HibernateException ex){
            
             return false ;
        }
        finally{
            transaction.commit();}
    }
        
    @Override
    public List<Incomes> getQuery(Criterion criterion) {
        
        List <Incomes> gotIncomes = new ArrayList<>();
        try{
        transaction = session.beginTransaction();
        gotIncomes = session.createCriteria(Incomes.class).add(criterion).list();
        return gotIncomes;
        }catch(HibernateException ex){
        return null;
        }finally{
    transaction.commit();
    }
    }
    
    @Override
    public List<Incomes> getAll() {
        List <Incomes> gotClients = new ArrayList<>();  
        try{
            transaction = session.beginTransaction();
            gotClients = session.createCriteria(Incomes.class).list();
            return gotClients;
         }catch(HibernateException ex){
        return null;
        }finally{
   transaction.commit();
    }
}
}
