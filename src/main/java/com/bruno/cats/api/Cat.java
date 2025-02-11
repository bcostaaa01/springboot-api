package com.bruno.cats.api;

public class Cat {

    private String id;
    private String name;
    private String breed;
    private int weight;

    public Cat(String id, String name, String breed, int weight) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
}
