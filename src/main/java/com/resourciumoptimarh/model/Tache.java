package com.resourciumoptimarh.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Tache{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id ;

    private String description;


    @Temporal(TemporalType.DATE)
    private Date dateDebut;


    @Temporal(TemporalType.DATE)
    private Date dateLimite;

    private int priorite;


    @Enumerated(EnumType.STRING)
    private Statut statut;

    // Constructors, getters, and setters
    public Tache() {}

    public Tache(String description, Date dateDebut, Date dateLimite, int priorite, Statut statut) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateLimite = dateLimite;
        this.priorite = priorite;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public int getPriorite() {
        return priorite;
    }

    public Statut getStatut() {
        return statut;
    }
}
