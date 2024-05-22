package org.example;

public class Order {
    private final String name;
    private final int time;
    private final int number;

    public Order(String name, int time, int number) {
        this.name = name;
        this.time = time;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getNumber() {
        return number;
    }
}
