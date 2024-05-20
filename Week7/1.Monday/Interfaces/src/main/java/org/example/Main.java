package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //polymorphism
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();
        Bat bat = new Bat();
        Helicopter helicopter = new Helicopter();

        List<Flyable> thingsThatFly = new ArrayList<>();
        List<Swimable> thingsThatSwim = new ArrayList<>();

        thingsThatSwim.add(dolphin);
        thingsThatSwim.add(penguin);

        thingsThatFly.add(bat);
        thingsThatFly.add(helicopter);

        LinkedList<Flyable> linkedListFlyable = new LinkedList<>();

        thingsThatFly = linkedListFlyable;

    }
}