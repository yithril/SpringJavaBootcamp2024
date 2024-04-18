package org.example;

public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    //overload the constructor
    public Book(String title, String author){
        this.title = title;
        this.author = author;
        this.pages = 0;
    }

    public Book(String title){
        this.title = title;
        this.author = "";
        this.pages = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    //method signature public/private what it returns, the name, and parameters
    public void displayInfo(){
        System.out.println("Book: " + this.getTitle() + " Author: " + this.getAuthor());
    }

    public void displayInfo(String prefix){
        System.out.println(prefix + " Book: " + this.getTitle() + " Author: " + this.getAuthor());
    }
}
