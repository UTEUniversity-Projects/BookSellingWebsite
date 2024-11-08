package com.biblio.dao;

import java.util.List;

public interface IGenericDAO<T> {

    List<T> findByJPQLPaginated(String jpql, int pageNumber, int pageSize, Object... params);

    List<T> findAllPaginated(int pageNumber, int pageSize);

    void delete(Object id);

    void update(T entity);

    void save(T entity);

    List<T> findByJPQL(String jpql, Object... params);

    T findSingleByJPQL(String jpql, Object... params);

    List<T> findAll();

    T findById(Object id);

    List<T> findAll(String jpql);

}