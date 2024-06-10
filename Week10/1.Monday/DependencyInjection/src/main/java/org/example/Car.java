package org.example;

public class Car {
    private Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }

    void start() {
        engine.performMaintenance();
        engine.start();
        System.out.println("Car started with " + engine.getClass().getSimpleName());
    }
}
