package com.resourciumoptimarh.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "mot_de_passe",  length = 100)
    private String motDePasse;

    @ManyToOne

    @JoinColumn(name = "role_id",columnDefinition = "integer default 1")
    private Role role  ;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_embauche")
    private Date dateEmbauche;
    public User(){
//        this.role = new Role(); // Set the default role when creating a new User
//        this.role.setId(1);
    }
    public User(String nom, String prenom, String email, String motDePasse,Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role =role;
//        this.dateEmbauche = dateEmbauche;
    }
    public User( String email, String motDePasse){
        this.email = email;
        this.motDePasse = motDePasse;
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }


    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
}
