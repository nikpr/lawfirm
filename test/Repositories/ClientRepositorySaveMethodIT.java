/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Clients;
import java.sql.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Nik
 */
public class ClientRepositorySaveMethodIT {
    Clients testClient;
    ClientRepository testClientRepository;
    public ClientRepositorySaveMethodIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        testClient = new Clients("test", "test", "test", new Date(2015, 11, 10), "AA", 1234, "test", "test", "test", "test", "test");
        testClientRepository = new ClientRepository();
        
    }
    
    @After
    public void tearDown() {
       
    }

    
    @Test()
    public void testSave() {
    boolean result= false;
        System.out.println("Testing Save()...");
            try{
              result   = testClientRepository.Save(testClient);
              
            }catch(Exception ex){
                
                System.out.println(ex.getClass());
           
            }
        assertTrue(result);
        
    }

    
}
