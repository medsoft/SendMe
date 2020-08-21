package com.example.ba95m.sendme.model;

public class Flight {

    private int id;
    private String location;
    private String title;
    private String description;
    private String role;
    private String dress_code;
    private String duree;
    private String debut;
    private String fin;
    private String heure_debut;
    private String heure_fin;
    private String remuneration;
    private String name_entreprise ;
    private String logo ;
    private int id_entreprise;



    public Flight(int id, String location, String title, String description, String role, String dress_code, String duree, String debut, String fin, String heure_debut,
                  String heure_fin, String remuneration, String name_entreprise, String logo , int id_entreprise ) {
        this.id = id;
        this.location = location;
        this.title = title;
        this.description = description;
        this.role = role;
        this.dress_code = dress_code;
        this.duree = duree;
        this.debut = debut;
        this.fin = fin;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.remuneration = remuneration;
        this.logo =  logo ;
        this.name_entreprise =  name_entreprise ;
        this.id_entreprise =  id_entreprise ;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDress_code() {
        return dress_code;
    }

    public void setDress_code(String dress_code) {
        this.dress_code = dress_code;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }

    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(String remuneration) {
        this.remuneration = remuneration;
    }

    public String getName_entreprise() {
        return name_entreprise;
    }

    public void setName_entreprise(String name_entreprise) {
        this.name_entreprise = name_entreprise;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;

    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }
}


