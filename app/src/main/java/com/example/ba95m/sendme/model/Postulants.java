package com.example.ba95m.sendme.model;

public class Postulants {

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
    private String username  ;
    private String email  ;
    private  int statut  ;
    private  int id_mission   ;

    public Postulants(int id, String location, String title, String description, String role, String dress_code, String duree, String debut, String fin, String heure_debut, String heure_fin, String remuneration, String username, String email, int statut, int id_mission) {
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
        this.username = username;
        this.email = email;
        this.statut = statut;
        this.id_mission = id_mission;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public int getId_mission() {
        return id_mission;
    }

    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }
}
