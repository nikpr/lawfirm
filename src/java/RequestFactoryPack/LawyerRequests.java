/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryPack;

import EntityCriterias.IGeneralSpecification;
import EntityCriterias.LawyersCriterias;
import Repositories.LawyerRepository;
import Repositories.IGeneralRepository;

/**
 *
 * @author Nik
 */
public class LawyerRequests implements IRequestFactory{

    @Override
    public IGeneralRepository getRepository() {
      return new LawyerRepository();
    }

    @Override
    public IGeneralSpecification getSpecification() {
      return new LawyersCriterias();
    }
    
}
