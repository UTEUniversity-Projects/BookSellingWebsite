package com.biblio.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {

    void delete(Object id);

    void update(T entity);

    void save(T entity);

    T findSingleByJPQL(String jpql, Object... params);

    List<T> findByJPQL(String jpql, Object... params);

    List<T> findAll();

    List<T> findAll(String jpql);

    T findById(Object id);

    List<T> findAllPaginated(int pageNumber, int pageSize);

    List<T> findByJPQLPaginated(String jpql, int pageNumber, int pageSize, Object... params);
}