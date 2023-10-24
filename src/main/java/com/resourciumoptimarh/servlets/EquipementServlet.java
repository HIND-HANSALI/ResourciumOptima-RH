package com.resourciumoptimarh.servlets;

import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.model.Etat;
import com.resourciumoptimarh.services.EquipementService;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Equipement", value = "/Equipement")
public class EquipementServlet extends HttpServlet {

    @Inject
    EquipementService equipementService=new EquipementService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        Etat[] etatValues = Etat.values();
        request.setAttribute("etatValues", etatValues);
        for (Etat etat : etatValues) {
            System.out.println(etat); // This will print each enum value
        }

        if (action == null) {
            List<Equipement> equipements = equipementService.getAllEquipements();

            request.setAttribute("equipements", equipements);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/list-equipements.jsp");
            dispatcher.forward(request, response);


        }else if (action.equals("edit")) {

            int equipementId = Integer.parseInt(request.getParameter("id"));
            Equipement equipement = equipementService.getEquipementById(equipementId);
            request.setAttribute("equipement", equipement);
            request.getRequestDispatcher("/update-equipement.jsp").forward(request, response);

        }else if (action.equals("delete")) {
        // Delete the equipement by id
            int equipementId = Integer.parseInt(request.getParameter("id"));

            equipementService.deleteEquipement(equipementId);
        response.sendRedirect(request.getContextPath() + "/Equipement");
    }



//        request.getRequestDispatcher("/list-equipements.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
//
//        Etat[] etatValues = Etat.values();
//        request.setAttribute("etatValues", etatValues);
        if ("create".equals(action)) {
            String equipementName = request.getParameter("equipementName");
            String equipementType= request.getParameter("equipementType");
            String dateAchatString = request.getParameter("dateAchat");
            String dateMaintenanceString = request.getParameter("dateMaintenance");
            String equipementEtat = request.getParameter("equipementEtat");
            Etat equipementEtatEnum = Etat.valueOf(equipementEtat);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateAchat=null;
            Date dateMaintenance=null;
            try {
                dateAchat = dateFormat.parse(dateAchatString);
                dateMaintenance = dateFormat.parse(dateMaintenanceString);

            } catch (ParseException e) {

                e.printStackTrace();
            }
        Equipement newEquipement=new Equipement(equipementName,equipementType,dateAchat,dateMaintenance,equipementEtatEnum);
            System.out.println(newEquipement);
            equipementService.createEquipement(newEquipement);
        response.sendRedirect(request.getContextPath() + "/Equipement");

        } else if ("update".equals(action)) {

            int equipementId = Integer.parseInt(request.getParameter("equipementId"));
            System.out.println(equipementId);
//            Equipement equipement1 = new Equipement();
            Equipement equipement1 =  equipementService.getEquipementById(equipementId);
            System.out.println(equipement1.getNom());

            String equipementName = request.getParameter("equipementName");
            String equipementType= request.getParameter("equipementType");
            String dateAchatString = request.getParameter("dateAchat");
            String dateMaintenanceString = request.getParameter("dateMaintenance");
            String equipementEtat = request.getParameter("equipementEtat");
            Etat equipementEtatEnum = Etat.valueOf(equipementEtat);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateAchat=null;
            Date dateMaintenance=null;
            try {
                dateAchat = dateFormat.parse(dateAchatString);
                dateMaintenance = dateFormat.parse(dateMaintenanceString);

            } catch (ParseException e) {

                e.printStackTrace();
            }
//            equipement1 = new Equipement(equipementName,equipementType,dateAchat,dateMaintenance,equipementEtatEnum);
                equipement1.setNom(equipementName);
                equipement1.setEtat(equipementEtatEnum);
                equipement1.setType(equipementType);
                equipement1.setDateAchat(dateAchat);
                equipement1.setDateMaintenance(dateMaintenance);
//            System.out.println(equipement1.toString());
            equipementService.updateEquipement(equipement1);
            response.sendRedirect(request.getContextPath() + "/Equipement");

        }

    }
}