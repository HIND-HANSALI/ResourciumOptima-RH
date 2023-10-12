package com.resourciumoptimarh.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "equipement")
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "type", length = 50)
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_achat")
    private Date dateAchat;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_maintenance")
    private Date dateMaintenance;

    @Column(name = "etat")
    private String etat;

    @ManyToOne
    private Departement departement;

    // Constructors
    public Equipement() {}

    public Equipement(String nom, String type, Date dateAchat, Date dateMaintenance, String etat, Departement departement) {
        this.nom = nom;
        this.type = type;
        this.dateAchat = dateAchat;
        this.dateMaintenance = dateMaintenance;
        this.etat = etat;
        this.departement = departement;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Date getDateMaintenance() {
        return dateMaintenance;
    }

    public void setDateMaintenance(Date dateMaintenance) {
        this.dateMaintenance = dateMaintenance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
