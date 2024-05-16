package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Jaguar jaguar = new Jaguar();
        Mazda mazda = new Mazda();
        Yugo yugo = new Yugo();
        Duck duck = new Duck();

        List<Car> inventory = new ArrayList<>();

        inventory.add(jaguar);
        inventory.add(mazda);
        inventory.add(yugo);

        for(Car vehicle : inventory){
            //downcasting
            if(vehicle instanceof Jaguar){
                ((Jaguar) vehicle).flamingExhaust();
            }
        }

        Car upcast = new Mazda();
    }
}