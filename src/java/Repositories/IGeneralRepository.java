/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import NewEntity.Incomes;
import java.util.List;
import org.hibernate.criterion.Criterion;
import NewEntity.BaseEntity;

/**
 *
 * @author Nik
 */
public interface IGeneralRepository  <T extends BaseEntity>{
    boolean Save(T t);
    boolean Delete(T t);
    boolean Update(T t);
    List<T> getQuery (Criterion criterion);
    List <T> getAll();  
    
}
