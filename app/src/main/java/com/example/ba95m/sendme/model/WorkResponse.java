package com.example.ba95m.sendme.model;

import java.util.List;

public class WorkResponse {

    private  boolean error  ;
    private List<Work>works ;

    public WorkResponse(boolean error, List<Work> works) {
        this.error = error;
        this.works = works;
    }

    public boolean isError() {
        return error;
    }

    public List<Work> getWorks() {
        return works;
    }
}
