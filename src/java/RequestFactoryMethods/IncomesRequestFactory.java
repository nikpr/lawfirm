/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactoryMethods;

import RequestFactoryPack.IRequestFactory;
import RequestFactoryPack.IncomesRequests;

/**
 *
 * @author Nik
 */
public class IncomesRequestFactory implements IRequestFactoryMethod{

    @Override
    public IRequestFactory getRequests() {
       return new IncomesRequests();
    }
    
}
