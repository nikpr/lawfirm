/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityCriterias;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Nik
 */
public class ConsumptionCriterias implements IGeneralSpecification{

   
    @Override
    public Criterion getCriteria(String... args) {
         Criterion cr = null;
        switch (args.length){
            case 1 :
                int ident = Integer.parseInt(args[0]);
                cr = Restrictions.eq("id", ident);
               break;
               default:
                   cr = null;
        }
         return cr;
    }
    
}
