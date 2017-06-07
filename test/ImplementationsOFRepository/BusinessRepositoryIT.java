/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementationsOFRepository;

import Repositories.BusinessRepository;
import NewEntity.Businesses;
import java.util.Iterator;
import java.util.List;
import org.hibernate.criterion.Criterion;
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
public class BusinessRepositoryIT {
    
    public BusinessRepositoryIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   

    /**
     * Test of getAll method, of class BusinessRepository.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        BusinessRepository instance = new BusinessRepository();
        List<Businesses> result = instance.getAll();
        for (Iterator<Businesses> iterator = result.iterator(); iterator.hasNext();) {
            Businesses next = iterator.next();
            System.out.println(next.getClients().getName());
        }
        assertTrue(!result.isEmpty());
        
    }
    
}
