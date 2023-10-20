package com.resourciumoptimarh.repositories;

import com.resourciumoptimarh.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class UserRepository {
    private final EntityManagerFactory entityManagerFactory;

    public UserRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");

    }
    public void save(User user){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

    }
    public User getUserByEmail(User user) {
        // Return the User entity if found, or null if not found
        try {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user1 = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email",user.getEmail())
                .getSingleResult();
        return user1;
        } catch (NoResultException e) {
            return null;
        }
    }


}
