package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> database = Arrays.asList(
                new Person(1, "Jack", "Brown", "Architect", "Texas", 48855),
                new Person(2, "Bob", "Smith", "Nurse", "Pennsylvania", 100711),
                new Person(3, "Ivy", "Smith", "Teacher", "Florida", 109366),
                new Person(4, "Emily", "Miller", "Nurse", "California", 53896),
                new Person(5, "Alice", "Garcia", "Doctor", "California", 57275),
                new Person(6, "Ivy", "Martinez", "Teacher", "California", 128061),
                new Person(7, "Alice", "Smith", "Farmer", "Texas", 41560),
                new Person(8, "Jack", "Garcia", "Nurse", "California", 97243),
                new Person(9, "Emily", "Smith", "Engineer", "Texas", 71966),
                new Person(10, "Alice", "Johnson", "Chef", "North Carolina", 96226),
                new Person(11, "Ivy", "Smith", "Chef", "Michigan", 113865),
                new Person(12, "Charlie", "Lee", "Doctor", "Illinois", 104835),
                new Person(13, "Grace", "Jones", "Farmer", "California", 114999),
                new Person(14, "Jack", "Davis", "Teacher", "Michigan", 89819),
                new Person(15, "Emily", "Miller", "Farmer", "North Carolina", 41535),
                new Person(16, "David", "Martinez", "Engineer", "Georgia", 70593),
                new Person(17, "Bob", "Johnson", "Doctor", "New York", 93464),
                new Person(18, "Emily", "Lee", "Chef", "New York", 133583),
                new Person(19, "Frank", "Garcia", "Teacher", "Illinois", 82528),
                new Person(20, "Charlie", "Brown", "Doctor", "Florida", 105548),
                new Person(21, "Alice", "Martinez", "Engineer", "California", 77609),
                new Person(22, "Jack", "Lee", "Farmer", "California", 126977),
                new Person(23, "Ivy", "Martinez", "Chef", "Texas", 81136),
                new Person(24, "Alice", "Brown", "Architect", "Ohio", 51435),
                new Person(25, "Charlie", "Smith", "Architect", "North Carolina", 66140),
                new Person(26, "Jack", "Johnson", "Engineer", "Florida", 143981),
                new Person(27, "David", "Garcia", "Teacher", "Ohio", 107622),
                new Person(28, "Emily", "Smith", "Nurse", "Georgia", 74796),
                new Person(29, "Grace", "Johnson", "Scientist", "Georgia", 148055),
                new Person(30, "Henry", "Martinez", "Scientist", "Illinois", 127989)
        );

        //You don't always have to print to the console, but it could be helpful for testing!
        // 1. Print the full names of all people.
        database.stream().map(Person::getFullName).sorted().toList().forEach(x -> System.out.println(x));

        // 2. Calculate the average yearly income of all people.
        var avgIncome = database.stream().mapToDouble(Person::getYearlyIncome).average().orElse(0);
        System.out.println(avgIncome);

        // 3. List the professions of people living in Texas.
        List<String> livingInText = database.stream().filter(person -> "Texas".equalsIgnoreCase(person.getState())).map(Person::getProfession).toList();
        System.out.println(livingInText);

        // 4. Find the person with the highest income.
        Person highestIncomePerson = database.stream().max(Comparator.comparingDouble(Person::getYearlyIncome)).orElse(null);
        System.out.println(highestIncomePerson);

        // 5. Count the number of people living in California.
        var californiaCount = database.stream().filter(person -> "California".equalsIgnoreCase(person.getState()))
                .count();
        System.out.println(californiaCount);

        // 6. Create a list of people who are not teachers.
        database.stream().filter(x -> !x.getProfession().equalsIgnoreCase("Teacher"))
                .map(Person::getFullName)
                .forEach(x -> System.out.println(x));

        // 7. Find the total income of all doctors.
        var totalIncome = database.stream().filter(person -> "Doctor".equalsIgnoreCase(person.getProfession()))
                .mapToDouble(Person::getYearlyIncome)
                .sum();

        // 8. Print the names of people with an income higher than 100000.
        database.stream().filter(person -> person.getYearlyIncome() > 100000).forEach(x -> System.out.println(x.getFullName()));

        // 9. Find the average income of engineers.
        var engineerAvg = database.stream().filter(person -> person.getProfession().equalsIgnoreCase("Engineer"))
                .mapToDouble(Person::getYearlyIncome)
                .average()
                .orElse(0.0);

        // 10. List the first names of people whose last name starts with 'S'.
        database.stream().filter(x -> x.getLastName().toUpperCase().charAt(0) == 'S')
                .toList().forEach(name -> System.out.println(name.getFirstName()));

        // 11. List the last names of all people who have a yearly income greater than $75,000 and live in Florida.
        database.stream().filter(person -> person.getYearlyIncome() > 75000 && person.getState().equalsIgnoreCase("Florida"))
                .forEach(person -> System.out.println(person.getLastName()));

        // 12. Find the average income of people whose profession is 'Teacher' or 'Doctor'.
        System.out.println(database.stream().filter(person -> person.getProfession().equalsIgnoreCase("Teacher") ||
                person.getProfession().equalsIgnoreCase("Doctor"))
                .mapToDouble(Person::getYearlyIncome)
                .average().orElse(0));

        //What if you wanted to find the first person on the list that met some criteria?
        var michiganPerson= database.stream().filter(person -> person.getState().equalsIgnoreCase("Michigan"))
                .findFirst().orElse(null);

        //WHo is a person that lives in Alaska
        var anybodyInAlaska = database.stream().filter(person -> person.getState().equalsIgnoreCase("Alaska"))
                .findAny().orElse(null);

        //Does anyobody live in Alaska
        boolean anyAreAlska = database.stream().anyMatch(person -> person.getState().equalsIgnoreCase("Alaska"));

        //anyMatch's evil opposite
        boolean noOneInDelaware = database.stream().noneMatch(person -> person.getState().equalsIgnoreCase("Delaware"));
    }
}