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
public class IncomesCriterias implements IGeneralSpecification{

    @Override
    public Criterion getCriteria(String... args) {
       Criterion cr=null;
if(args.length==1){
    int id = Integer.parseInt(args[0]);
       cr = Restrictions.eq("businesses.id", id);
}
return cr;
    }
    
}
