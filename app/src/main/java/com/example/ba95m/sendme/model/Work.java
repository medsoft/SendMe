package com.example.ba95m.sendme.model;

public class Work {
    private int id  ;
    private int statut  ;
    private int id_mission ;
    private int user_id ;
    private  String username  ;
    private  String email   ;
    private  String location  ;
    private  String title  ;
    private  String remuneration  ;
    private  String debut  ;
    private  String fin  ;
    private  String duree  ;
    private  String heure_debut  ;
    private  String heure_fin  ;
    private  int  id_entreprise  ;
    private  String   name_entreprise  ;
    private  String   logo   ;
    private  String   manager   ;
    private  String   telephone    ;


    public Work(int id, int statut, int id_mission, int user_id, String username, String email, String location, String title, String remuneration, String debut, String fin,String duree  ,  String heure_debut, String heure_fin,  int  id_entreprise  , String name_entreprise, String logo, String manager, String telephone) {
        this.id = id;
        this.statut = statut;
        this.id_mission = id_mission;
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.location = location;
        this.title = title;
        this.remuneration = remuneration;
        this.debut = debut;
        this.fin = fin;
        this.duree = duree;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.id_entreprise  =  id_entreprise ;
        this.name_entreprise = name_entreprise;
        this.logo = logo;
        this.manager = manager;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(String remuneration) {
        this.remuneration = remuneration;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(int id_entreprise) {
        this.id_entreprise = id_entreprise;
    }
}
