package com.resourciumoptimarh.servlets;

import com.resourciumoptimarh.model.User;
import com.resourciumoptimarh.services.UserService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Inject
    UserService userService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

        User user=new User(email,motDePasse);
        User user1 = userService.CheckExistenceUserByEmail(user);

        if (user1!=null) {
            request.getSession(true).setAttribute("user", user1);
            request.setAttribute("success", "You are logged in successfully");
            this.getServletContext().getRequestDispatcher("/list-equipements.jsp").forward(request, response);
        } else {
            request.setAttribute("validationEmail", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
//        protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//        String motDePasse = request.getParameter("motDePasse");
//
//        User user = getUserByEmail(email);
//
//        if (user != null) {
//            // Check if the entered password matches the stored password
//            if (user.getMotDePasse().equals(motDePasse)) {
//                // Authentication successful
//                response.sendRedirect("list-equipements.jsp");
//            } else {
//                // Authentication failed: Password does not match
//                //response.sendRedirect("/Login?error=invalid_password");
//                //response.sendRedirect("login.jsp");
//                System.out.println(getUserByEmail(email) );
//                response.sendRedirect("login.jsp?error=invalid_password");
//            }
//        } else {
//            // Authentication failed: User not found
//            //request.setAttribute("error", "user_not_found");
//            //request.getRequestDispatcher("login.jsp").forward(request, response);
//            //response.sendRedirect("register.jsp");
//            System.out.println(getUserByEmail(email) );
//            response.sendRedirect("login.jsp?error=user_not_found");
//
//        }
//
//    }
    private User getUserByEmail(String email) {
        // Return the User entity if found, or null if not found
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        User user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        return user;
    }

//    @Override
//    public void destroy() {
//        emf.close();
//    }
}
