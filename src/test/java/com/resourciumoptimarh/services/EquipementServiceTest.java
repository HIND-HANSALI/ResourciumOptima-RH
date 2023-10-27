package com.resourciumoptimarh.services;

import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.model.Etat;
import com.resourciumoptimarh.repositories.EquipementRepository;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EquipementServiceTest {

    EquipementService equipementService=new EquipementService();

    private EquipementRepository equipementRepository=new EquipementRepository();

    @Test
    public void test_save_new_equipement() {

        Equipement equipement = new Equipement("Test Equipement", "Test Type", new Date(), new Date());


        equipementService.createEquipement(equipement);


        Equipement savedEquipement = equipementRepository.getById(equipement.getId());

        // Assert that the saved Equipement object is not null
        assertNotNull(savedEquipement);
    }
    @Test
    public void test_save_equipement_all_fields_filled() {
        // Create a new Equipement object with all fields filled
        Equipement equipement = new Equipement("Test Equipement", "Test Type", new Date(), new Date(), Etat.Disponible);

        // Call the createEquipement method
        equipementService.createEquipement(equipement);

        // Retrieve the saved Equipement object from the database
        Equipement savedEquipement = equipementRepository.getById(equipement.getId());

        // Assert that the saved Equipement object is not null
        assertNotNull(savedEquipement);
    }
    @Test
    public void test_save_equipement_required_fields_filled() {
        // Create a new Equipement object with only required fields filled
        Equipement equipement = new Equipement("Test Equipement", null, new Date(), new Date());

        // Call the createEquipement method
        equipementService.createEquipement(equipement);

        // Retrieve the saved Equipement object from the database
        Equipement savedEquipement = equipementRepository.getById(equipement.getId());

        // Assert that the saved Equipement object is not null
        assertNotNull(savedEquipement);
    }
}