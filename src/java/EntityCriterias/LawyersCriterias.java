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
public class LawyersCriterias  implements IGeneralSpecification{

    @Override
    public Criterion getCriteria(String... args) {
        Criterion criterion;
         switch (args.length) {
            case 1:
                criterion= Restrictions.eq("surname",args[0]);
                break;
            case 2:
                criterion = Restrictions.and(Restrictions.eq("surname", args[0]),Restrictions.eq("name", args[1]) );
                break;
            case 3:
                criterion = Restrictions.and(Restrictions.eq("surname", args[0]),Restrictions.eq("name", args[1]),Restrictions.eq("patronymic", args[2]));
                break;
            default:
                criterion = null;
                break;
        }
        return criterion;
        
    }
    
}
