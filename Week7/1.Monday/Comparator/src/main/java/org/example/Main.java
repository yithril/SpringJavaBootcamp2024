package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(25);
        integerList.add(4500);
        integerList.add(2);

        Collections.sort(integerList);
        System.out.println(integerList);

        List<String> fruits = new ArrayList<>();
        fruits.add("Strawberry");
        fruits.add("Melon");
        fruits.add("Blueberry");

        Collections.sort(fruits);
        System.out.println(fruits);

        List<Person> personList = new ArrayList<Person>() {{
            add(new Person("Bob", 20));
            add(new Person("Joe", 25));
            add(new Person("Joe", 35));
            add(new Person("Mergatroid", 75));
            add(new Person("Icarus", 35));
            add(new Person("Maybelle", 65));
            add(new Person("Esther", 42));
        }};

        NameComparator nm = new NameComparator();
        AgeComparator ac = new AgeComparator();

        Collections.sort(personList, nm);

        personList.stream().forEach(x -> System.out.println(x.getName() + " " + x.getAge()));
    }
}