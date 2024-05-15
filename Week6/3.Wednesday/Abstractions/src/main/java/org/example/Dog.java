package org.example;

public class Dog extends Animal{
    private String furColor;
    private String name;

    public Dog(String color, Diet diet, double size, String furColor, String name) {
        super(color, diet, size);
        this.furColor = furColor;
        this.name = name;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void whatever(){

    }
}
