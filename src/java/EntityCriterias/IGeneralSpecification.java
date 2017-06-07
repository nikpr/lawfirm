/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityCriterias;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Nik
 */
public interface IGeneralSpecification   {
Criterion getCriteria ( String  ... args);
// Criterion  getCriteria(String ... args);
    
}
