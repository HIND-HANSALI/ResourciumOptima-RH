package com.resourciumoptimarh.services;



import com.resourciumoptimarh.model.Reservation;
import com.resourciumoptimarh.repositories.EquipementRepository;
import com.resourciumoptimarh.repositories.ReservationRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationService{
    @Inject
    private ReservationRepository reservationRepository=new ReservationRepository();

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAll().stream().filter(r->r.getEquipement().getType()=="Jetable").collect(Collectors.toList());
    }
    public List<Reservation> getSpecific(){
        return reservationRepository.getSpecific();
    }

    public void createReservation(Reservation reservation){ reservationRepository.save(reservation);}

}
