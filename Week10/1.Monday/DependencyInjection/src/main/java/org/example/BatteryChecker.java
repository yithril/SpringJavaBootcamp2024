package org.example;

public class BatteryChecker {
    private BatteryHealthMonitor monitor;

    BatteryChecker(BatteryHealthMonitor monitor) {
        this.monitor = monitor; // Dependency passed in constructor
    }

    void checkBattery() {
        monitor.monitorBatteryHealth();
        System.out.println("Checking battery.");
    }
}
