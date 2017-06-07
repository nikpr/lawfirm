/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImplementationsOFRepository;

import Repositories.ClientRepository;
import NewEntity.Clients;
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
public class ClientRepositoryIT {
    
    public ClientRepositoryIT() {
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
     * Test of getAll method, of class ClientRepository.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        ClientRepository instance = new ClientRepository();
        List<Clients> expResult = null;
        List<Clients> result = instance.getAll();
        for (Iterator<Clients> iterator = result.iterator(); iterator.hasNext();) {
            Clients next = iterator.next();
            System.out.println(next.toString());
        }
        assertTrue(!result.isEmpty());
        
    }
    
}
