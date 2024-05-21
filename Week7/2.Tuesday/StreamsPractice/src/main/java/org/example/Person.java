package org.example;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String profession;
    private String state;
    private double yearlyIncome;

    public Person(int id, String firstName, String lastName, String profession, String state, double yearlyIncome) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profession = profession;
        this.state = state;
        this.yearlyIncome = yearlyIncome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
}
