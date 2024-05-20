package org.example;

public class Bat extends Animal implements Flyable, EchoLocate  {

    @Override
    public void fly() {
        System.out.println("The bat flaps its wings.");
    }

    @Override
    public void findWithSound() {
        System.out.println("Bats use sound to locate objects.");
    }
}
