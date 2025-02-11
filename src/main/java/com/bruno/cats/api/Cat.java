package com.bruno.cats.api;

import jakarta.validation.constraints.NotEmpty;

public class Cat {

    private String id;
    @NotEmpty
    private String name;
    private String breed;
    private int weight;

    public Cat(String id, String name, String breed, int weight) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
