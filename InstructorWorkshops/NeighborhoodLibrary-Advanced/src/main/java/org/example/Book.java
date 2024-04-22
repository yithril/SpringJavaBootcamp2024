package org.example;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        //It makes sense for a book to initially be checked in
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut(){
        return this.isCheckedOut;
    }

    public String getCheckedOutTo(){
        return this.checkedOutTo;
    }

    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    public void checkOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    @Override
    public String toString() {
        if (this.isCheckedOut()) {
            return String.format("ID: %d ISBN: %s Title: %s Checked Out to: %s",
                    this.getId(), this.getIsbn(), this.getTitle(), this.getCheckedOutTo());
        } else {
            return String.format("ID: %d ISBN: %s Title: %s",
                    this.getId(), this.getIsbn(), this.getTitle());
        }
    }
}
