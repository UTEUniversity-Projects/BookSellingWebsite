package com.biblio.dao.impl;

import com.biblio.dao.INotificationDAO;
import com.biblio.entity.Notification;
import com.biblio.jpaconfig.JpaConfig;

import javax.persistence.EntityManager;

public class NotificationDAOImpl implements INotificationDAO {
    @Override
    public void saveSupport_Notification(Notification notification) {
        EntityManager entityManager = JpaConfig.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(notification);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}
