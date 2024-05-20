package org.example;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //-1 if less than, 0 if equal, 1 if greater
    @Override
    public int compareTo(Person o) {
        //you have to write your own comparison logic
        int nameComparison = this.name.compareTo(o.name);
        //let's say they're not the same
        if(nameComparison != 0){
            return nameComparison;
        }

        //if their names are the same, how do we order them?
        return Integer.compare(this.age, o.age);
    }
}
