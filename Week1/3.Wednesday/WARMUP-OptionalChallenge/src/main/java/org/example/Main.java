package org.example;

//This is more advanced and an exploration of why we use .equals and .equalsIgnoreCase for strings
//and not == to compare strings. If you want to give it a shot, go for it!
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "Hello World";
        String s3 = new String("Hello World");

        // Direct comparison using ==
        System.out.println("Comparing s1 and s2 with == : " + (s1 == s2));
        System.out.println("Comparing s1 and s3 with == : " + (s1 == s3));

        // Using .equals() and .equalsIgnoreCase()
        System.out.println("Comparing s1 and s3 with .equals() : " + s1.equals(s3));
        System.out.println("Comparing s1 and s3 with .equalsIgnoreCase() : " + s1.equalsIgnoreCase(s3));

        //Look up what System.identityHashCode() does.
        //Using that information, hypothesize WHY == doesn't work but .equals does.
        System.out.println("HashCode of s1: " + System.identityHashCode(s1));
        System.out.println("HashCode of s2: " + System.identityHashCode(s2));
        System.out.println("HashCode of s3: " + System.identityHashCode(s3));
    }
}