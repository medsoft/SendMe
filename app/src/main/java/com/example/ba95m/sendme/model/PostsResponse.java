package com.example.ba95m.sendme.model;

import java.util.List;

public class PostsResponse {

    private boolean error ;

    private List<Flight> posts ;

    public PostsResponse(boolean error, List<Flight> posts) {
        this.error = error;
        this.posts = posts;
    }

    public boolean isError() {
        return error;
    }

    public List<Flight> getPosts() {
        return posts;
    }
}
