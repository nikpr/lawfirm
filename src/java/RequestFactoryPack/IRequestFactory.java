/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryPack;

import EntityCriterias.IGeneralSpecification;
import Repositories.IGeneralRepository;

/**
 *
 * @author Nik
 */
public interface IRequestFactory {
    IGeneralRepository getRepository();
    IGeneralSpecification getSpecification();
    
}
