package com.bruno.cats.api;

public class Photo {
    public String id;
    public String url;

    public Photo(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public String getId() {
        return id;
    }
}
