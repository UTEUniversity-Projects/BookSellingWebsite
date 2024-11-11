package com.biblio.dao;

import java.util.List;
import java.util.Map;

public interface IGenericDAO<T> {

    List<T> findByJPQLPaginated(String jpql, int pageNumber, int pageSize, Map<String, Object> params);

    List<T> findAllPaginated(int pageNumber, int pageSize);

    T delete(Object id);

    T update(T entity);

    T save(T entity);

    List<T> findByJPQL(String jpql, Map<String, Object> params);

    T findSingleByJPQL(String jpql, Map<String, Object> params);

    List<T> findAll();

    T findById(Object id);

    List<T> findAll(String jpql);

}