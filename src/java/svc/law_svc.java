/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svc;


import Repositories.BusinessRepository;
import NewEntity.Clients;
import Repositories.ClientRepository;
import NewEntity.BaseEntity;
import NewEntity.Businesses;
import NewEntity.Consumptions;
import NewEntity.Incomes;
import NewEntity.Lawyers;
import NewEntity.Services;
import Repositories.IGeneralRepository;
import RequestFactoryMethods.BusinessRequestFactory;
import RequestFactoryMethods.ClientRequestFactory;
import RequestFactoryMethods.ConsumprionRequestFactory;
import RequestFactoryMethods.IRequestFactoryMethod;
import RequestFactoryMethods.IncomesRequestFactory;
import RequestFactoryMethods.LawyerRequestFactory;
import RequestFactoryMethods.ServiceRequestFactory;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.hibernate.criterion.Criterion;
import RequestFactoryPack.IRequestFactory;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author Nik
 */
@WebService(serviceName = "law_svc")
public class law_svc {
 static IRequestFactoryMethod manager;
   static Criterion cr;
  
  private  void getFactoryByEntityBelonging(BaseEntity entity){
  if(entity instanceof Clients)
      manager = new ClientRequestFactory();
  else if( entity instanceof Businesses)
      manager  = new BusinessRequestFactory();
  else if (entity instanceof Lawyers)
      manager= new LawyerRequestFactory();
  else if (entity instanceof Services)
     manager = new ServiceRequestFactory();
  else if (entity instanceof Consumptions)
      manager = new ClientRequestFactory();
  else if (entity instanceof Incomes)
      manager = new  IncomesRequestFactory();
  else 
      manager =null;
  }

    
    /**
     * Операция веб-службы
     * General getAll() method for all entities of law_firm_db
     */
    @WebMethod(operationName = "getAll")
    public List<BaseEntity> getAll(@WebParam(name = "entity") BaseEntity entity ) {
        getFactoryByEntityBelonging(entity);
      return manager.getRequests().getRepository().getAll(); 
    }
    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetClientsQuery")
    public List<Clients> GetClientsQuery(@WebParam(name = "Surname") String Surname) {
      manager = new ClientRequestFactory();
      cr = manager.getRequests().getSpecification().getCriteria(Surname);
        return manager.getRequests().getRepository().getQuery(cr);
    }
    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetBusinessQuery")
    public List<Businesses> GetBusinessQuery(@WebParam(name = "id") String id) {
        manager = new BusinessRequestFactory();
         cr =  manager.getRequests().getSpecification().getCriteria(id);
        return manager.getRequests().getRepository().getQuery(cr);
    }
    
    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetLawyersQuery")
    public List<Lawyers> GetLawyersQuery(@WebParam(name = "surname") String surname) {
        manager = new LawyerRequestFactory();
        cr = manager.getRequests().getSpecification().getCriteria(surname);
        return manager.getRequests().getRepository().getQuery(cr);
    }
    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetServiceQuery")
    public List<Services> GetServiceQuery(@WebParam(name = "id") String id) {
        manager = new ServiceRequestFactory();
        cr = manager.getRequests().getSpecification().getCriteria(id);
        return manager.getRequests().getRepository().getQuery(cr);
    }
     /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetIncomesQuery")
    public List<Incomes> GetIncomesQuery(@WebParam(name = "id") String id) {
    manager = new IncomesRequestFactory();
    cr = manager.getRequests().getSpecification().getCriteria(id);
        return manager.getRequests().getRepository().getQuery(cr);
    }
     /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetConsumptionQuery")
    public List<Consumptions> GetConsumptionQuery(@WebParam(name = "id") String id) {
       manager = new ConsumprionRequestFactory();
       cr = manager.getRequests().getSpecification().getCriteria(id);
        return manager.getRequests().getRepository().getQuery(cr);
    }
    
    /**
     * Операция веб-службы
     * General Save() method for all entities of law_firm_db
     */
    @WebMethod(operationName = "Save")
    public boolean Save(@WebParam(name = "entity") BaseEntity entity) {
        getFactoryByEntityBelonging(entity);
        return manager.getRequests().getRepository().Save(entity);
    }

    /**
     * Операция веб-службы
     * General Delete() method for all entities of law_firm_db
     */
    @WebMethod(operationName = "Delete")
    public boolean Delete(@WebParam(name = "entity") BaseEntity entity) {
        getFactoryByEntityBelonging(entity);
        return manager.getRequests().getRepository().Delete(entity);
    }

    /**
     * Операция веб-службы
     * General Upadate() method for all entities of law_firm_db
     */  
    @WebMethod(operationName = "Update")
    public String Update(@WebParam(name = "entity") BaseEntity entity) {
        getFactoryByEntityBelonging(entity);
        throw  new UnsupportedOperationException("Not implemented yet");
     //   return "Not implemented yet";
    }

    /**
     * Операция веб-службы
     */
    @WebMethod(operationName = "GetClientQuerySurnameName")
    public List<Clients> GetClientQuerySurnameName(@WebParam(name = "surname") String surname, @WebParam(name = "name") String name) {
            manager = new ClientRequestFactory();
      cr = manager.getRequests().getSpecification().getCriteria(surname,name);
        return manager.getRequests().getRepository().getQuery(cr);
    }

    /**
     * Операция веб-службы
     */


  


}
