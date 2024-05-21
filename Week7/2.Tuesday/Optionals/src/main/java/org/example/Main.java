package org.example;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", new Address("New York City"));
        Person person2 = new Person("Bob");

        String cityPerson2 = person2.getAddress().orElse(new Address("No address was set.")).getCity();

        System.out.println(cityPerson2);

        //what if I just want to know if its there or not?
        if(person2.getAddress().isPresent()){

        }

        //What can I put in the Optional box?
        //start with an empty box
        Optional<String> emptyBox = Optional.empty();

        //start off with something in the box
        Optional<Integer> fullBox = Optional.of(100);

        Integer fromTheBox = fullBox.get();

        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Joe");

        Optional<List<String>> optionalNames = Optional.of(names);

        var listOfNames = optionalNames.get();

        listOfNames.add("Mary");
        listOfNames.add("George");

        optionalNames = Optional.of(listOfNames);
    }
}