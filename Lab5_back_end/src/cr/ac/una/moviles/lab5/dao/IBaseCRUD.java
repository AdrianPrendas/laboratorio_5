package cr.ac.una.moviles.lab5.dao;

import java.util.List;

/**
 *
 * @author _Adrián_Prendas_
 */
public interface IBaseCRUD<T,K> {
    boolean create(T t);
    List<T> read(T t);
    List<T> readAll();
    boolean update(T t);
    boolean delete(K t); 
}
