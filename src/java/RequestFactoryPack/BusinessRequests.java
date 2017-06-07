/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryPack;

import EntityCriterias.BusinessesCriterias;
import EntityCriterias.IGeneralSpecification;
import Repositories.BusinessRepository;
import Repositories.IGeneralRepository;

/**
 *
 * @author Nik
 */
public class BusinessRequests implements IRequestFactory{

    @Override
    public IGeneralRepository getRepository() {
       return new BusinessRepository();
    }

    @Override
    public IGeneralSpecification getSpecification() {
      return new BusinessesCriterias();
    }
    
}
