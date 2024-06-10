package org.example;

public class FuelCleaner {
    private OilFilter oilFilter;
    private FuelSensor fuelSensor;

    FuelCleaner(OilFilter oilFilter, FuelSensor fuelSensor) {
        this.oilFilter = oilFilter; // Dependency passed in constructor
        this.fuelSensor = fuelSensor;
    }

    void cleanFuelSystem() {
        oilFilter.filterOil();
        System.out.println("Cleaning fuel system.");
    }
}
