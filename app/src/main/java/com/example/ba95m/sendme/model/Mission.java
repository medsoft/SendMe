package com.example.ba95m.sendme.model;

public class Mission {

    private  String username  ;
    private  String email   ;
    private  String location  ;
    private  String title  ;
    private  String remuneration  ;
    private  String debut  ;
    private int statut  ;
    private  String  name_entreprise  ;
    private String logo  ;


    public Mission(String username, String email, String location, String title, String remuneration , String debut  , int statut , String name_entreprise , String logo) {
        this.username = username;
        this.email = email;
        this.location = location;
        this.title = title;
        this.remuneration = remuneration;
        this.debut = debut;
        this.statut =  statut  ;
        this.name_entreprise =  name_entreprise ;
        this.logo  =  logo  ;

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

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getName_entreprise() {
        return name_entreprise;
    }

    public void setName_entreprise(String name_entreprise) {
        this.name_entreprise = name_entreprise;
    }
}
