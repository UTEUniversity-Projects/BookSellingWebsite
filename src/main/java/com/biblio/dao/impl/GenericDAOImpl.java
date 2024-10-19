package com.biblio.dao.impl;

import com.biblio.dao.IGenericDAO;
import com.biblio.jpaconfig.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenericDAOImpl<T, ID> implements IGenericDAO<T, ID> {

    private final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(Object id) {
        EntityManager em = JpaConfig.getEntityManager();
        T entity = em.find(entityClass, id);
        em.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        List<T> results = em.createQuery(criteriaQuery).getResultList();
        em.close();
        return results;
    }

    @Override
    public T findSingleByJPQL(String jpql, Object... params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
            return query.getResultStream().findFirst().orElse(null);
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findByJPQL(String jpql, Object... params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void save(T entity) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(T entity) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Object id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("Entity not found with ID: " + id);
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> findAllPaginated(int pageNumber, int pageSize) {
        EntityManager em = JpaConfig.getEntityManager();
        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.select(criteriaQuery.from(entityClass));
        TypedQuery<T> query = em.createQuery(criteriaQuery);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<T> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public List<T> findByJPQLPaginated(String jpql, int pageNumber, int pageSize, Object... params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
