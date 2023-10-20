package com.resourciumoptimarh.repositories;

import com.resourciumoptimarh.model.Equipement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EquipementRepository {
    private final EntityManagerFactory entityManagerFactory;

     public EquipementRepository(){
         entityManagerFactory = Persistence.createEntityManagerFactory("default");

     }
     public void save(Equipement equipement){
         EntityManager entityManager = entityManagerFactory.createEntityManager();
         try {
             entityManager.getTransaction().begin();
             entityManager.persist(equipement);
             entityManager.getTransaction().commit();
         } finally {
             entityManager.close();
         }

     }
    public Equipement getById(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Equipement.class, id);
        } finally {
            entityManager.close();
        }
    }
    public List<Equipement> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Equipement e", Equipement.class).getResultList();
        } finally {
            entityManager.close();
        }
    }
    public void update(Equipement equipement) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(equipement);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public void delete(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Equipement equipement= entityManager.find(Equipement.class, id);
            if (equipement != null) {
                entityManager.remove(equipement);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


}
