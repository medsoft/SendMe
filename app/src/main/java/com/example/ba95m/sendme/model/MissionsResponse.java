package com.example.ba95m.sendme.model;

import java.util.List;

public class MissionsResponse {

    private boolean error  ;
    private List<Mission> missions  ;

    public MissionsResponse(boolean error, List<Mission> missions) {
        this.error = error;
        this.missions = missions;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
