package org.example;

import java.util.Scanner;

public class UserInterface {
    private Book[] books = new Book[20];
    Scanner scanner = new Scanner(System.in);

    public UserInterface(){
        //If I don't do this the array won't have anything in it
        initializeLibrary();
    }

    public void homeScreen(){
        while(true){
            System.out.println("Welcome to the library!");
            System.out.println("Here are your options: ");
            System.out.println("1) Show available books");
            System.out.println("2) Show checked out books");
            System.out.println("3) Exit");

            var input = scanner.nextLine();

            switch (input){
                case "1" :
                    checkOutScreen();
                    break;
                case "2":
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

    public void checkInScreen(){
        while(true){
            displayBooks(true);
            System.out.println("Menu options:");
            System.out.println("1) Check in a book");
            System.out.println("2) Back");

            var input = scanner.nextLine();

            switch(input){
                case "1":
                    System.out.println("Select the id of the book you wish to check in.");
                    int bookId = scanner.nextInt();
                    var book = getBookByIdAndStatus(bookId, true);
                    if(book == null){
                        System.out.println("That book is not available to check in. Try again.");
                        continue;
                    }
                    else{
                        book.checkIn();
                        System.out.println("Book checked in. Thank you");
                        return;
                    }
                case "2":
                    return;
                default:
                    System.out.println("Not an option. Try again.");
                    break;
            }
        }
    }

    public void checkOutScreen(){
        while(true){
            displayBooks(false);
            System.out.println("1) Check out book");
            System.out.println("2) Back");

            var input = scanner.nextLine();

            switch(input){
                case "1":
                    System.out.println("Please enter the id of the book you want to check out.");
                    var bookChoice = scanner.nextInt();
                    var book = getBookByIdAndStatus(bookChoice, false);
                    if(book == null){
                        System.out.println("Sorry that book is not available try again.");
                        continue;
                    }
                    else{
                        scanner.nextLine();
                        System.out.println("What is your name?");
                        input = scanner.nextLine();
                        book.checkOut(input);
                        System.out.println("Book successfully checked out. Thank you.");
                        return;
                    }
                case "2":
                    return;
                default:
                    System.out.println("Not an option try again.");
                    break;
            }
        }
    }

    private Book getBookByIdAndStatus(int id, boolean checkedInStatus){
        for(Book book : books){
            if(book.getId() == id && book.isCheckedOut() == checkedInStatus){
                return book;
            }
        }
        return null;
    }

    private void displayBooks(boolean checkInStatus){
        for(Book book : books){
            if(book.isCheckedOut() == checkInStatus){
                if(book.isCheckedOut()){
                    System.out.printf("ID: %d ISBN: %s Title: %s Checked Out to: %s \n", book.getId(), book.getIsbn(), book.getTitle(), book.getCheckedOutTo());
                }
                else{
                    System.out.printf("ID: %d ISBN: %s Title: %s \n", book.getId(), book.getIsbn(), book.getTitle());
                }
            }
        }
    }

    private void initializeLibrary(){
        books[0] = new Book(1, "978-3-16-148410-0", "The Night Circus");
        books[1] = new Book(2, "978-0-06-245773-8", "Circe");
        books[2] = new Book(3, "978-0-525-65629-2", "Normal People");
        books[3] = new Book(4, "978-1-5011-2637-9", "The Silent Patient");
        books[4] = new Book(5, "978-0-593-19141-3", "The Midnight Library");
        books[5] = new Book(6, "978-1-250-30747-6", "Mexican Gothic");
        books[6] = new Book(7, "978-1-250-20370-8", "The Invisible Life of Addie LaRue");
        books[7] = new Book(8, "978-0-735-21318-0", "Project Hail Mary");
        books[8] = new Book(9, "978-1-250-76813-4", "The Lincoln Highway");
        books[9] = new Book(10, "978-1-250-19920-9", "The Dutch House");
        books[10] = new Book(11, "978-0-593-28661-6", "The Plot");
        books[11] = new Book(12, "978-0-593-28660-9", "Klara and the Sun");
        books[12] = new Book(13, "978-0-06-293496-3", "The Vanishing Half");
        books[13] = new Book(14, "978-1-250-21787-8", "Cloud Cuckoo Land");
        books[14] = new Book(15, "978-1-984855-85-2", "The Ballad of Songbirds and Snakes");
        books[15] = new Book(16, "978-0-593-13426-0", "Malibu Rising");
        books[16] = new Book(17, "978-1-250-76793-9", "The Last Thing He Told Me");
        books[17] = new Book(18, "978-1-250-31712-7", "One Last Stop");
        books[18] = new Book(19, "978-0-399-56233-0", "Leave the World Behind");
        books[19] = new Book(20, "978-0-525-65543-1", "The Other Black Girl");
    }
}
