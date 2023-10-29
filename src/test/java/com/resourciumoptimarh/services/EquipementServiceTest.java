package com.resourciumoptimarh.services;

import com.resourciumoptimarh.model.Equipement;
import com.resourciumoptimarh.model.Etat;
import com.resourciumoptimarh.repositories.EquipementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class EquipementServiceTest {

    EquipementService equipementService;

    EquipementRepository equipementRepository;

    @BeforeEach
    void setUp() {
        equipementRepository = mock(EquipementRepository.class);
        equipementService = new EquipementService();
    }

    @Test
    public void test_save_new_equipement_with_null_etat() {

        Equipement equipement = new Equipement("Test Equipement", "Test Type", new Date(), new Date());


        Exception msg = assertThrows(IllegalArgumentException.class, () -> equipementService.createEquipement(equipement));
        System.out.println(msg.getMessage());
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

        // Use assertThrows to check if an IllegalArgumentException is thrown
        Exception msg = assertThrows(IllegalArgumentException.class, () -> equipementService.createEquipement(equipement));
        System.out.println(msg.getMessage());
    }
}