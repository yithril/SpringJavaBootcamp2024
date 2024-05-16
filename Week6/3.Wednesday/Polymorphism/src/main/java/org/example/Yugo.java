package org.example;

public class Yugo extends Car {
    @Override
    public void accelerate(){
        var speed = this.getSpeed();
        this.setSpeed(speed += 5);
    }
}
