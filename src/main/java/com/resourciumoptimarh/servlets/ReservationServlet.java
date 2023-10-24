package com.resourciumoptimarh.servlets;


import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.model.Reservation;

import com.resourciumoptimarh.model.User;
import com.resourciumoptimarh.services.EquipementService;
import com.resourciumoptimarh.services.ReservationService;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(name = "Reservation", value = "/Reservation")
public class ReservationServlet extends HttpServlet {


    @Inject
    ReservationService reservationService =new ReservationService();
    EquipementService equipementService =new EquipementService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equipement> equipmentList = equipementService.getAllEquipements();
        request.setAttribute("equipementValues", equipmentList);

        System.out.println("Equipement List Size: " + equipmentList.size());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/reservation.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateDebutString = request.getParameter("dateDebut");
        String dateFinString = request.getParameter("dateFin");
        int equipementId = Integer.parseInt(request.getParameter("equipementId"));
        User loggedInUser = (User) request.getSession().getAttribute("user");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut=null;
        Date dateFin=null;
        try {
            dateDebut = dateFormat.parse(dateDebutString);
            dateFin = dateFormat.parse(dateFinString);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        Equipement selectedEquipement = equipementService.getEquipementById(equipementId);
        if (selectedEquipement != null) {
            Reservation newReservation = new Reservation(dateDebut, dateFin,loggedInUser,selectedEquipement);

//            System.out.println(newReservation);
            reservationService.createReservation(newReservation);
        } else {
            request.setAttribute("equipmentNotFound", "The selected equipment is not found.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/reservation.jsp");
            dispatcher.forward(request, response);
        }


    }
}
