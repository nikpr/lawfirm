/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryPack;

import EntityCriterias.IGeneralSpecification;
import EntityCriterias.ServicesCriterias;
import Repositories.IGeneralRepository;
import Repositories.ServiceRepository;

/**
 *
 * @author Nik
 */
public class ServiceRequests implements IRequestFactory{

    @Override
    public IGeneralRepository getRepository() {
        return new ServiceRepository();
    }

    @Override
    public IGeneralSpecification getSpecification() {
       return new ServicesCriterias();
    }
    
}
