package com.example.ba95m.sendme.model;

import com.google.gson.annotations.SerializedName;

public class Candidat {
    @SerializedName("id")
    private int id  ;
    @SerializedName("statut")
    private int statut  ;
    @SerializedName("user_id")
    private int user_id  ;
    @SerializedName("id_mission")
    private int id_mission  ;

    public Candidat(int id, int statut, int user_id, int id_mission) {
        this.id = id;
        this.statut = statut;
        this.user_id = user_id;
        this.id_mission = id_mission;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId_mission() {
        return id_mission;
    }

    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }
}
