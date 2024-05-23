package org.example;

public class DoubleBox<T,TT> {
    private T left;
    private TT right;

    public DoubleBox(T left, TT right){
        this.left = left;
        this.right = right;
    }

    public void printContents(){
        System.out.println(this.left);
        System.out.println(this.right);
    }

    public static void main(String[] args){
        DoubleBox<String, Double> doubleBox = new DoubleBox<>("left", 12.0);
    }
}
