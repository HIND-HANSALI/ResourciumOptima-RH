package com.resourciumoptimarh.repositories;

import com.resourciumoptimarh.model.Role;
import com.resourciumoptimarh.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class RoleRepository {
    private final EntityManagerFactory entityManagerFactory;

    public RoleRepository(){
        entityManagerFactory = Persistence.createEntityManagerFactory("default");

    }
    public Role getRoleByName(String role) {
        // Return the User entity if found, or null if not found
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Role role1= entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class)
                    .setParameter("role",role)
                    .getSingleResult();
            return role1;
        } catch (NoResultException e) {
            return null;
        }
    }
}
