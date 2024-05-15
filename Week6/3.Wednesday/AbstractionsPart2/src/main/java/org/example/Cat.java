package org.example;

public class Cat extends Animal {
    private boolean inSunBeam;

    public Cat(String color, Diet diet, double size, boolean inSunBeam) {
        super(color, diet, size);
        this.inSunBeam = inSunBeam;
    }

    public boolean isInSunBeam() {
        return inSunBeam;
    }

    public void setInSunBeam(boolean inSunBeam) {
        this.inSunBeam = inSunBeam;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
