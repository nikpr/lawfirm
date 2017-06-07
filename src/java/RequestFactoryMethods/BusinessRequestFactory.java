/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryMethods;

import RequestFactoryPack.BusinessRequests;
import RequestFactoryPack.IRequestFactory;

/**
 *
 * @author Nik
 */
public class BusinessRequestFactory implements IRequestFactoryMethod{

    @Override
    public IRequestFactory getRequests() {
        return new BusinessRequests();
    }
    
}
