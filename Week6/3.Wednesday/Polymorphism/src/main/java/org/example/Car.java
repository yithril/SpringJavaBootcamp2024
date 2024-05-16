package org.example;

public class Car {
    private int speed;

    public Car(){
        this.speed = 0;
    }

    public void accelerate(){
        this.speed += 10;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
