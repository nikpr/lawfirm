/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Clients;
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
     * Test of Save method, of class ClientRepository.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        Clients newClient = null;
        ClientRepository instance = new ClientRepository();
        boolean expResult = false;
        boolean result = instance.Save(newClient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Delete method, of class ClientRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        Clients delClient = null;
        ClientRepository instance = new ClientRepository();
        boolean expResult = false;
        boolean result = instance.Delete(delClient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Update method, of class ClientRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("Update");
        Clients updateClient = null;
        ClientRepository instance = new ClientRepository();
        boolean expResult = false;
        boolean result = instance.Update(updateClient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuery method, of class ClientRepository.
     */
    @Test
    public void testGetQuery() {
        System.out.println("getQuery");
        Criterion criterion = null;
        ClientRepository instance = new ClientRepository();
        List<Clients> expResult = null;
        List<Clients> result = instance.getQuery(criterion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
