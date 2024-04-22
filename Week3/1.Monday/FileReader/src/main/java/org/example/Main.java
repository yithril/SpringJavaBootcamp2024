package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/yeats-poem.txt");

            //We're going to stream the file to the scanner
            Scanner scanner = new Scanner(fileInputStream);
            String input;

            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                System.out.println(input);
            }

            scanner.close();
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found.");
        }
    }
}