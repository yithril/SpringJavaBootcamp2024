package org.example;

public class Box<T> {
    private T content;

    public T getContent(){
        return content;
    }

    public void setContent(T content){
        this.content = content;
    }

    public static <T> void printArray(T[] array){

    }

    public static void main(String[] args){
        Box<Double> doubleBox = new Box<>();
        Box<Integer> intBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
    }
}
