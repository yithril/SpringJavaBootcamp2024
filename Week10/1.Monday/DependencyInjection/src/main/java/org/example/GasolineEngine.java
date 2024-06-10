package org.example;


public class GasolineEngine implements Engine {
    private FuelCleaner cleaner;

    GasolineEngine(FuelCleaner cleaner) {
        this.cleaner = cleaner; // Dependency passed in constructor
    }

    public void start() {
        System.out.println("Gasoline engine started.");
    }

    public void performMaintenance() {
        cleaner.cleanFuelSystem();
        System.out.println("Maintaining gasoline engine.");
    }
}
