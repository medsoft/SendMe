package com.example.ba95m.sendme.model;

public class Entreprise {

    private int id  ;
    private String name_entreprise  ;
    private String logo  ;

    public Entreprise(int id, String name_entreprise, String logo) {
        this.id = id;
        this.name_entreprise = name_entreprise;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Entreprise{" +
                "name_entreprise='" + name_entreprise + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
