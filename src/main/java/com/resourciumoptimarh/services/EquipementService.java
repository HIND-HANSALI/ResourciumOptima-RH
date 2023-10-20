package com.resourciumoptimarh.services;

import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.repositories.EquipementRepository;
import jakarta.inject.Inject;

import java.util.List;

public class EquipementService {

@Inject
    private EquipementRepository equipementRepository=new EquipementRepository();

    public void createEquipement(Equipement equipement){ equipementRepository.save(equipement);}

    public void updateEquipement(Equipement equipement){equipementRepository.update(equipement);}

    public void deleteEquipement(int id){ equipementRepository.delete(id);}

    public Equipement getEquipementById(int id){ return equipementRepository.getById(id);}

    public List<Equipement> getAllEquipements() {return equipementRepository.getAll();}


}
