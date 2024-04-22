package org.example;

import java.util.Arrays;
import java.util.Optional;

public class BookInventory {
    private Book[] books = new Book[20];

    public BookInventory() {
        initializeLibrary();
    }

    public Optional<Book> getBookByIdAndStatus(int id, boolean checkedInStatus) {
        return Arrays.stream(books)
                .filter(book -> book.getId() == id && book.isCheckedOut() == checkedInStatus)
                .findFirst();
    }

    public void displayBooks(boolean checkInStatus) {
        boolean hasBooks = Arrays.stream(books)
                .anyMatch(book -> book.isCheckedOut() == checkInStatus);
        if (!hasBooks) {
            System.out.println(checkInStatus ? "No books to check in." : "No books available to check out.");
            return;
        }

        Arrays.stream(books)
                .filter(book -> book.isCheckedOut() == checkInStatus)
                .forEach(System.out::println);  // Using method reference to print each book using the overridden toString
    }

    private void initializeLibrary() {
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
