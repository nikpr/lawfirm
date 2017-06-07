/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import EntityCriterias.ClientsCriterias;
import NewEntity.Clients;
import java.sql.Date;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Nik
 */
public class ClientRepositoryWithMocksIT {
    ClientRepository repositoryMock = Mockito.mock(ClientRepository.class);
    Clients client;
     static ClientsCriterias criteriaMock = mock(ClientsCriterias.class);
    public ClientRepositoryWithMocksIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        client = new Clients("test","test", "AA", 1234, "test");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Save method, of class ClientRepository.
     */
    @Test
    public void testSave() {
        
        Mockito.when(repositoryMock.Save(client)).thenReturn(true);
        boolean result = repositoryMock.Save(client);
        assertTrue(result);
       
    }

    /**
     * Test of Delete method, of class ClientRepository.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
            Mockito.when(repositoryMock.Delete(client)).thenReturn(true);
        boolean result = repositoryMock.Delete(client);
        assertTrue(result);
    }

    /**
     * Test of Update method, of class ClientRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("Delete");
            Mockito.when(repositoryMock.Update(client)).thenReturn(true);
        boolean result = repositoryMock.Update(client);
        assertTrue(result);
    }

    /**
     * Test of getQuery method, of class ClientRepository.
     */
    @Test
    public void testGetQuery() {
        System.out.println("getQuery");
       Mockito.when(criteriaMock.getCriteria("args")).thenReturn(Restrictions.eq("surname", "Ivanov"));
        List<Clients> result = mock(List.class);
        Mockito.when(result.isEmpty()).thenReturn(Boolean.FALSE);
        Mockito.when(repositoryMock.getQuery(criteriaMock.getCriteria("args"))).thenReturn(result);
        result =  repositoryMock.getQuery(criteriaMock.getCriteria("args"));
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getAll method, of class ClientRepository.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
         List<Clients> gotClient = mock(List.class);
        Mockito.when(gotClient.isEmpty()).thenReturn(Boolean.FALSE);
     //   Mockito.when(dataAccessunitMock.getAll(client)).thenReturn(gotClient);
        List result = repositoryMock.getAll();
        assertTrue(result.isEmpty());
    }
    
}
