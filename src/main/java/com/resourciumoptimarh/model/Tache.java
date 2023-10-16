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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Enumerated(EnumType.STRING)
    private Statut statut;

    // Constructors, getters, and setters
    public Tache() {}

    public Tache(String description, Date dateDebut, Date dateLimite, int priorite, User user, Statut statut) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateLimite = dateLimite;
        this.priorite = priorite;
        this.user = user;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
