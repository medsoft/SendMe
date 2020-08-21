package com.example.ba95m.sendme.model;

public class User {

    private int id  ;
    private String username  ;
    private String email  ;
    private String adresse  ;
    private String password   ;
    private  int statut ;

    public User(int id, String username, String email, String adresse,int statut) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.adresse = adresse;
        this.statut = statut;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }
}
