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
public class BusinessesCriterias implements  IGeneralSpecification{
 Criterion criterion;

    @Override
    public Criterion getCriteria(String... args) {
        
        switch (args.length){
        case 1:
             criterion = Restrictions.eq("clients.id", Integer.parseInt(args[0]));
        break;
        default:
            throw new UnsupportedOperationException("Not suported yet!");
             
        }
        return criterion;
    

    }
   
       
    
}
