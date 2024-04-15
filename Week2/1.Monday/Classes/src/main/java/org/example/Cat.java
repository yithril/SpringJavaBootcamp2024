package org.example;

public class Cat {
    private String name;
    private String breed;

    //parameterless constructor
    public Cat(){
        this.name = "";
        this.breed = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
