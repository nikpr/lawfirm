/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svc;

import NewEntity.BaseEntity;
import NewEntity.Businesses;
import NewEntity.Clients;
import NewEntity.Consumptions;
import NewEntity.Incomes;
import NewEntity.Lawyers;
import NewEntity.Services;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nik
 */
public class law_svcIT {
    BaseEntity pointer = null;
        law_svc service ;
           String clientSurname;
           String clientName;
           String businessID;
            String lawyerSurname ;
             String serviceID;
             String incomeID;
              String consumptionID;
           
    public law_svcIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        service = new law_svc();
        clientName="test";
        clientSurname = "test";
        lawyerSurname = "test";
        businessID = "1";
        serviceID = "1";
        incomeID = "1";
        consumptionID = "1";
        pointer = new Clients ();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class law_svc.
     */
    @Test
    public void testGetAll() {
        System.out.println("Testing getAll()....");
         List<BaseEntity> result = new ArrayList<>();
       if (pointer!= null){
      result = service.getAll(pointer);
          assertTrue(!result.isEmpty());}
       else 
           fail("pointer is null");

    }

    /**
     * Test of GetClientsQuery method, of class law_svc.
     */
    @Test
    public void testGetClientsQuery() {
        System.out.println("Testing GetClientsQuery()...");
     
 if (!clientSurname.isEmpty()){
        List<Clients> result = service.GetClientsQuery(clientSurname);
        assertTrue(!result.isEmpty());}
 else 
     fail("clientSurname is empty");
        
    }

    /**
     * Test of GetBusinessQuery method, of class law_svc.
     */
    @Test
    public void testGetBusinessQuery() {
        List<Businesses> result = new ArrayList<>();
        System.out.println("GetBusinessQuery");
      if (!businessID.isEmpty()){
        result = service.GetBusinessQuery(businessID);
        assertTrue(!result.isEmpty());}
      else if (!businessID.isEmpty() && result.isEmpty())
          fail("Trying to get business which was not saved in database");
      else
        fail("businessID is Empty");
    }

    /**
     * Test of GetLawyersQuery method, of class law_svc.
     */
    @Test
    public void testGetLawyersQuery() {
          List<Lawyers> result = new ArrayList<>();
        System.out.println("Testing GetLawyersQuery()...");
       if(!lawyerSurname.isEmpty()){
      result = service.GetLawyersQuery(lawyerSurname);
        assertTrue(!result.isEmpty());}
        else if (!lawyerSurname.isEmpty() && result.isEmpty())
                fail ("Trying to get lawyer who was not saved in database");
        else 
        fail("lawyerSurname is empty");
    }
    /**
     * Test of GetServiceQuery method, of class law_svc.
     */
    @Test
    public void testGetServiceQuery() {
        List<Services> result = new ArrayList<>();
        System.out.println("GetServiceQuery");
       
       if (!serviceID.isEmpty()){
       result = service.GetServiceQuery(serviceID);
        assertTrue(!result.isEmpty());}
       else if (!serviceID.isEmpty() && result.isEmpty())
           fail("Trying to get service which was not saved in database");
       else 
        fail("serviceId is ");
    }

    /**
     * Test of GetIncomesQuery method, of class law_svc.
     */
    @Test
    public void testGetIncomesQuery() {
        System.out.println("GetIncomesQuery");
         List<Incomes> result = new ArrayList<>();
       if (!incomeID.isEmpty()){
       result = service.GetIncomesQuery(incomeID);
        assertTrue(!result.isEmpty());}
       else if (!incomeID.isEmpty() && result.isEmpty())
           fail("Trying to get incomes which were not saved in database");
       else 
        fail("incomesId is empty");
    }

    /**
     * Test of GetConsumptionQuery method, of class law_svc.
     */
    @Test
    public void testGetConsumptionQuery() {
        System.out.println("Testing GetConsumptionQuery()...");
         List<Consumptions> result = new ArrayList<>();
       if (!consumptionID.isEmpty()){
       result = service.GetConsumptionQuery(consumptionID);
        assertTrue(!result.isEmpty());}
       else if (!incomeID.isEmpty() && result.isEmpty())
           fail("Trying to get consumptions which were not saved in database");
       else 
        fail("incomesId is empty");
    }
    

    /**
     * Test of Save method, of class law_svc.
     */
    @Test
    public void testSave() {
        System.out.println("Testing Save()...");
          boolean result;
       if (pointer!= null){
      result = service.Save(pointer);
          assertTrue(result);}
       else 
           fail("pointer is null");

    }

    /**
     * Test of Delete method, of class law_svc.
     */
    @Test
    public void testDelete() {
        System.out.println("Testing Delete()...");
         boolean result;
       if (pointer!= null){
      result = service.Delete(pointer);
          assertTrue(result);}
       else 
           fail("pointer is null");
    }

    /**
     * Test of Update method, of class law_svc.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
          String result;
       if (pointer!= null){
      result = service.Update(pointer);
          assertTrue(!result.isEmpty());}
       else 
           fail("pointer is null");
    }

    /**
     * Test of GetClientQuerySurnameName method, of class law_svc.
     */
    @Test
    public void testGetClientQuerySurnameName() {
        System.out.println("GetClientQuerySurnameName");
       List<Clients> result =  new ArrayList<>();
       if(!clientName.isEmpty() && !clientSurname.isEmpty()){
        result = service.GetClientQuerySurnameName(clientSurname, clientName);
           assertTrue(!result.isEmpty());}
       else if (!clientName.isEmpty() && !clientSurname.isEmpty() && result.isEmpty())
       fail ("Unknown client");
       else 
        fail("clientName.isEmpty and clientSurname.isEmpty ");
    }
    
}
