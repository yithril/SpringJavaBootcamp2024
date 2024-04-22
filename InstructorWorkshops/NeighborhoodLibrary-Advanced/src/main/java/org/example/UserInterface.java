package org.example;

import java.util.Scanner;

public class UserInterface {
    private BookInventory bookInventory = new BookInventory();
    private Scanner scanner = new Scanner(System.in);

    public void homeScreen() {
        while (true) {
            System.out.println("Welcome to the library!");
            System.out.println("Here are your options:");
            System.out.println("1) Show available books");
            System.out.println("2) Show checked out books");
            System.out.println("3) Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    bookInventory.displayBooks(false);
                    checkOutScreen();
                    break;
                case "2":
                    bookInventory.displayBooks(true);
                    checkInScreen();
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not a valid choice. Try again.");
                    break;
            }
        }
    }

    private void checkInScreen() {
        while (true) {
            System.out.println("Menu options:");
            System.out.println("1) Check in a book");
            System.out.println("2) Back");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    try {
                        checkInBook();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid book ID.");
                    }
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Not an option. Try again.");
                    break;
            }
        }
    }

    private void checkOutScreen() {
        while (true) {
            System.out.println("1) Check out a book");
            System.out.println("2) Back");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    try {
                        checkOutBook();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid book ID.");
                    }
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Not an option try again.");
                    break;
            }
        }
    }

    private void checkInBook() {
        System.out.println("Please enter the ID of the book you wish to check in.");
        int bookId = promptForInteger("Please enter a valid book ID.");
        if (bookId == -1) return;

        bookInventory.getBookByIdAndStatus(bookId, true)
                .ifPresentOrElse(b -> {
                    b.checkIn();
                    System.out.println("Book checked in. Thank you.");
                }, () -> System.out.println("That book is not available to check in. Try again."));
    }

    private void checkOutBook() {
        System.out.println("Please input the ID of the book you wish to check out.");
        int bookChoice = promptForInteger("Please enter a valid book ID.");
        if (bookChoice == -1) return; // Exit if the input was invalid.

        bookInventory.getBookByIdAndStatus(bookChoice, false)
                .ifPresentOrElse(b -> {
                    String name = promptForString("What is your name?");
                    b.checkOut(name);
                    System.out.println("Book successfully checked out. Thank you.");
                }, () -> System.out.println("Sorry, that book is not available. Try again."));
    }

    private int promptForInteger(String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private String promptForString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
