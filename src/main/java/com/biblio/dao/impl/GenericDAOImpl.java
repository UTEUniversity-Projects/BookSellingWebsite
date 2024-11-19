package com.biblio.dao.impl;

import com.biblio.dao.IGenericDAO;
import com.biblio.jpaconfig.JpaConfig;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public class GenericDAOImpl<T> implements IGenericDAO<T> {

    private final Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(Object id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            return em.find(entityClass, id);
        } catch (Exception e) {
            throw new RuntimeException("Error while finding entity by ID", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public List<T> findAll() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(entityClass);
            criteriaQuery.select(criteriaQuery.from(entityClass));
            return em.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while finding all entities", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public List<T> findAll(String jpql) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while finding all entities by JPQL", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public T findSingleByJPQL(String jpql) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            return query.getResultStream().findFirst().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error while finding single entity by JPQL", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public T findSingleByJPQL(String jpql, Map<String, Object> params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            setQueryParameters(query, params);
            return query.getResultStream().findFirst().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error while finding single entity by JPQL", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public List<T> findByJPQL(String jpql, Map<String, Object> params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            setQueryParameters(query, params);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while finding entities by JPQL", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public T save(T entity) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error while saving entity", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public T update(T entity) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error while updating entity", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public T delete(Object id) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
                em.getTransaction().commit();
                return entity;
            } else {
                em.getTransaction().rollback();
                throw new IllegalArgumentException("Entity not found with ID: " + id);
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException("Error while deleting entity", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public List<T> findAllPaginated(int pageNumber, int pageSize) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(entityClass);
            criteriaQuery.select(criteriaQuery.from(entityClass));
            TypedQuery<T> query = em.createQuery(criteriaQuery);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while finding paginated entities", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public List<T> findByJPQLPaginated(String jpql, int pageNumber, int pageSize, Map<String, Object> params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<T> query = em.createQuery(jpql, entityClass);
            setQueryParameters(query, params);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while finding paginated entities by JPQL", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public long count() {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            Root<T> root = cq.from(entityClass);
            cq.select(cb.count(root));
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error while counting entities", e);
        } finally {
            closeEntityManager(em);
        }
    }

    @Override
    public long countByJPQL(String jpql, Map<String, Object> params) {
        EntityManager em = JpaConfig.getEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(jpql, Long.class);
            setQueryParameters(query, params);
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error while counting entities by JPQL", e);
        } finally {
            closeEntityManager(em);
        }
    }

    private void setQueryParameters(TypedQuery<?> query, Map<String, Object> params) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }

    void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
