package org.example;

public class Dog extends Animal {
    private String name;

    public Dog(String color, Diet diet, double size, String name) {
        super(color, diet, size);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound(){
        System.out.println("Woof!");
    }
}
