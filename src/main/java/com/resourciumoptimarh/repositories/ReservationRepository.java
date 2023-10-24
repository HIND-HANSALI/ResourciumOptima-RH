package com.resourciumoptimarh.repositories;

import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.model.Reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.util.List;

public class ReservationRepository {
    private final EntityManagerFactory entityManagerFactory;

    public ReservationRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");

    }

    public List<Reservation> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Reservation> getSpecific() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT r FROM Reservation r JOIN r.equipement e WHERE r.dateFin = CURRENT_DATE AND e.type LIKE 'Jetable' ",
                    Reservation.class).getResultList();
        } finally {
            entityManager.close();
        }

    }
    public void save(Reservation reservation){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reservation);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

    }











}


