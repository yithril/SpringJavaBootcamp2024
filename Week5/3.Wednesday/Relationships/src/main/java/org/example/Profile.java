package org.example;

import java.util.List;

public class Profile {
    private int yearsOfEducation;
    private String degree;
    private String address;
    private int age;
    private List<String> specialties;
    private boolean isOccupied;

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Profile(int yearsOfEducation, String degree, String address, int age) {
        this.yearsOfEducation = yearsOfEducation;
        this.degree = degree;
        this.address = address;
        this.age = age;
    }

    public int getYearsOfEducation() {
        return yearsOfEducation;
    }

    public void setYearsOfEducation(int yearsOfEducation) {
        this.yearsOfEducation = yearsOfEducation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void addSpecialty(String specialty){
        this.specialties.add(specialty);
    }

    //derived getter
    public boolean isQualified(String className){
        if(className.equalsIgnoreCase("Calculus")){
            if(this.degree.equals("Math") && this.yearsOfEducation > 2){
                return true;
            }
        }

        if(className.equalsIgnoreCase("World History")){
            if(this.degree.equals("History") && this.yearsOfEducation > 0){
                return true;
            }
        }

        return false;
    }
}
