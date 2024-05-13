package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Vehicle> inventory;

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public List<Vehicle> getVehiclesByPriceRange(double a, double b){
        ArrayList<Vehicle> sortedVehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() >= a && vehicle.getPrice() <= b){
                sortedVehicles.add(vehicle);
            }
        }
        return sortedVehicles;
    }
}
