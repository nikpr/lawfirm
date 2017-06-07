/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryPack;

import EntityCriterias.ClientsCriterias;
import EntityCriterias.IGeneralSpecification;
import Repositories.ClientRepository;
import Repositories.IGeneralRepository;

/**
 *
 * @author Nik
 */
public class ClientRequests  implements IRequestFactory{

    @Override
    public IGeneralRepository getRepository() {
       return new ClientRepository();
    }

    @Override
    public IGeneralSpecification getSpecification() {
       return new ClientsCriterias();
    }
    
}
