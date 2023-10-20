package com.resourciumoptimarh.servlets;

import com.resourciumoptimarh.model.Role;
import com.resourciumoptimarh.model.User;

import com.resourciumoptimarh.services.UserService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Register", value = "/Register")
public class RegisterServlet extends HttpServlet {


    @Inject
    UserService userService=new UserService();
   private EntityManagerFactory emf;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request,response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("motDePasse");

//        Role role = entityManager.find(Role.class, 1);

        String message = "";
        String hashed = hashPassword(motDePasse);
        User savedUser = userService.save(new User(nom, prenom, email, hashed));
        System.out.println(savedUser.getEmail());

        if (savedUser!=null) {
            message = "User successfully registered.";
            request.setAttribute("registrationMessage", message);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            message = "Email already exists. Please use a different email.";
            request.setAttribute("registrationMessage", message);
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }

    }
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }







//    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String nom = request.getParameter("nom");
//        String prenom = request.getParameter("prenom");
//        String email = request.getParameter("email");
//        String motDePasse = request.getParameter("motDePasse");
//
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = emf.createEntityManager();
//
//        Role role = entityManager.find(Role.class, 1);
//
//        if (role == null) {
//            System.out.println("Error: Role 'Employee' not found.");
//        }
//
//        User newUser = new User(nom, prenom, email, motDePasse,role);
//
//        entityManager.getTransaction().begin();
//        entityManager.persist(newUser);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
////      HttpSession session = request.getSession();
////        session.setAttribute("email", email);
//        response.sendRedirect("login.jsp");
//
//    }










    //        Role role = entityManager.createQuery("SELECT r FROM Role r WHERE r.role = 'Employee'", Role.class)
//                .getSingleResult();
//        if (role == null) {
//            //throw new RoleNotFoundException("Role not found");
//            String errorMessage = "Role not found: Defaulting to a different role.";
//            System.err.println(errorMessage);
//        }
    @Override
    public void destroy() {
        emf.close();
    }
}
