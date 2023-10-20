package com.resourciumoptimarh.servlets;

import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.services.EquipementService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Equipement", value = "/Equipement")
public class EquipementServlet extends HttpServlet {

    @Inject
    EquipementService equipementService=new EquipementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
//        System.out.println("hiii");

        List<Equipement> equipements= equipementService.getAllEquipements();
        request.setAttribute("equipements",equipements);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-equipements.jsp");
        dispatcher.forward(request,response);
//        request.getRequestDispatcher("/list-equipements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
