package com.resourciumoptimarh.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;


    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    public Reservation(){}


    public Reservation(Date dateDebut, Date dateFin, User user, Equipement equipement) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.user = user;
        this.equipement = equipement;
    }
    public Reservation(Date dateDebut, Date dateFin,Equipement equipement) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.equipement = equipement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", user=" + user +
                ", equipement=" + equipement +
                '}';
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

}
