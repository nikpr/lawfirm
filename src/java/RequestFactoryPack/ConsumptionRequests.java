/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryPack;

import EntityCriterias.ConsumptionsCriterias;
import EntityCriterias.IGeneralSpecification;
import Repositories.ConsumptionRepository;
import Repositories.IGeneralRepository;

/**
 *
 * @author Nik
 */
public class ConsumptionRequests implements IRequestFactory{

    @Override
    public IGeneralRepository getRepository() {
     return new ConsumptionRepository();
    }

    @Override
    public IGeneralSpecification getSpecification() {
       return new ConsumptionsCriterias();
    }
    
}
