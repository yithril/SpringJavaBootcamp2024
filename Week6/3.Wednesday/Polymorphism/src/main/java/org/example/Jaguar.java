package org.example;

public class Jaguar extends Car {
    @Override
    public void accelerate(){
        var speed = this.getSpeed();
        this.setSpeed(speed += 20);
    }

    public void flamingExhaust(){
        System.out.println("Fire comes out the exhaust.");
    }
}
