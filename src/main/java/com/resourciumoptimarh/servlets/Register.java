package com.resourciumoptimarh.servlets;

import com.resourciumoptimarh.model.Role;
import com.resourciumoptimarh.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.management.relation.RoleNotFoundException;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String motDePasse = request.getParameter("motDePasse");
        String prenom = request.getParameter("prenom");

        String email = request.getParameter("email");

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();

        Role role = entityManager.createQuery("SELECT r FROM Role r WHERE r.role = 'Employee'", Role.class)
                .getSingleResult();
        if (role == null) {
            //throw new RoleNotFoundException("Role not found");
            String errorMessage = "Role not found: Defaulting to a different role.";
            System.err.println(errorMessage);
        }
        User newUser = new User(nom, prenom, email, motDePasse,role);

        entityManager.getTransaction().begin();
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();
        entityManager.close();

//        HttpSession session = request.getSession();
//        session.setAttribute("email", email);
        response.sendRedirect("login.jsp");

    }
}
