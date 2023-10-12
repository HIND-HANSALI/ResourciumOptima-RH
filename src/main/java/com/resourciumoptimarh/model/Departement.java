package com.resourciumoptimarh.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "nom", nullable = false, length = 50)
    private String nom;
    @Column(name = "description", nullable = false, length = 255)
    private String description;

    // Constructors, getters, and setters
    public Departement() {
        // Default no-arg constructor
    }

    public Departement(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Departement [id=" + id + ", nom=" + nom + ", description=" + description + "]";
    }
}
