package org.example;

public class ElectricEngine implements Engine {
    private BatteryChecker checker;

    ElectricEngine(BatteryChecker checker) {
        this.checker = checker; // Dependency passed in constructor
    }

    public void start() {
        System.out.println("Electric engine started.");
    }

    public void performMaintenance() {
        checker.checkBattery();
        System.out.println("Maintaining electric engine.");
    }
}
