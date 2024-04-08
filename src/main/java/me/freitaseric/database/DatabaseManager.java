package me.freitaseric.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DatabaseManager {
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("study-bot-persistence");
    private final EntityManager entityManager = factory.createEntityManager();

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void create(Object obj) {
        EntityTransaction transaction = this.entityManager.getTransaction();

        try {
            transaction.begin();
            this.entityManager.persist(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            this.entityManager.close();
        }
    }

    public <T> T findById(Class<T> entityClass, Object id) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        T objClass;

        try {
            transaction.begin();
            objClass = this.entityManager.find(entityClass, id);
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            this.entityManager.close();
        }
        return objClass;
    }
}
