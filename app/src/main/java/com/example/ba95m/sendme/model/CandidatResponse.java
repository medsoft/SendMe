package com.example.ba95m.sendme.model;

import java.util.List;

public class CandidatResponse {
    private boolean error  ;
    private String candidat  ;

    public CandidatResponse(boolean error, String candidat) {
        this.error = error;
        this.candidat = candidat;
    }

    public boolean isError() {
        return error;
    }

    public String getCandidat() {
        return candidat;
    }
}
