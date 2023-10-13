package com.resourciumoptimarh;

import com.resourciumoptimarh.model.Departement;
import com.resourciumoptimarh.model.Employe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.core.Request;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test", value = "/Test")
public class Test extends HttpServlet {
    private String message;

//    public void init() {message = "Hello Test!";}

    @Override
    public void init() throws ServletException {
        super.init();
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
        EntityManager em=emf.createEntityManager();
        em.close();
        emf.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Emlpoye.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String email=request.getParameter("email");
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
        EntityManager em=emf.createEntityManager();
        Employe emp=new Employe(nom,prenom,email);
        em.getTransaction().begin();
        em.persist(emp);
        em.getTransaction().commit();
//        response.sendRedirect("employe.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Emlpoye.jsp");
        dispatcher.forward(request,response);
    }
}
