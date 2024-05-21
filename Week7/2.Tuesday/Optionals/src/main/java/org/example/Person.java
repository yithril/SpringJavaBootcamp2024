package org.example;

import java.util.Optional;

public class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


     public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
   }

    public void setAddress(Address address) {
        this.address = address;
    }
}