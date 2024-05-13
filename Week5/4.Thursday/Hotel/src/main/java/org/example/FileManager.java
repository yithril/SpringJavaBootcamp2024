package org.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FileManager {
    public static Dealership loadVehicles(){
        //do some logic to get the vehicles from the file.
        List<Vehicle> vehiclesFromFile = new ArrayList<>();

        Dealership dealership = new Dealership();

        dealership.setInventory(vehiclesFromFile);

        return dealership;
    }
}
