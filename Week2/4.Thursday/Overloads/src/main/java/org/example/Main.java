package org.example;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Fahrenheit 451", "Ray Bradbury", 300);

        //use the overloaded constructor
        Book book2 = new Book("Foundation and Earth", "Isaac Asimov");

        Book book3 = new Book("Martian Chronicles");
    }
}