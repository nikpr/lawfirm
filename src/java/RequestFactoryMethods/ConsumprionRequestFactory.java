/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryMethods;

import RequestFactoryPack.ConsumptionRequests;
import RequestFactoryPack.IRequestFactory;

/**
 *
 * @author Nik
 */
public class ConsumprionRequestFactory implements IRequestFactoryMethod{

    @Override
    public IRequestFactory getRequests() {
       return new ConsumptionRequests();
    }
    
}
