package org.example;

public abstract class Animal {
    private String color;
    private Diet diet;
    private double size;

    public Animal(String color, Diet diet, double size) {
        this.color = color;
        this.diet = diet;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    //Contract
    public abstract void makeSound();
}
