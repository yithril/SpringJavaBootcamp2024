package org.example;

import java.util.List;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){
        dealership = FileManager.loadVehicles();
    }

    public void processGetByPriceRequest(){
        System.out.println("What price range are you looking for?");
        //asks a bunch of questions and error handling yada yada

        double minPrice = 10;
        double maxPRice = 100;

        List<Vehicle> vehiclesIWannaDisplay = dealership.getVehiclesByPriceRange(minPrice, maxPRice);

        for(Vehicle vehicle : vehiclesIWannaDisplay){

        }
    }

    public void processByMakeAndModelRequest(){
        throw new UnsupportedOperationException();
    }
}
