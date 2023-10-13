package com.resourciumoptimarh;

import java.io.*;

import com.resourciumoptimarh.model.Departement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet(name = "helloServlet" , value = "/hello-servlet", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() throws ServletException{
        super.init();
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = emf.createEntityManager();
        entityManager.close();
        emf.close();
        

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        message = "Hello World!";
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");


    }

    public void destroy() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            // Create and persist the new department
            Departement department = new Departement(nom, description);


            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();


            response.sendRedirect("index.jsp");
            //request.setAttribute("successMessage", "Department saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("error.jsp");
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }


    }

}