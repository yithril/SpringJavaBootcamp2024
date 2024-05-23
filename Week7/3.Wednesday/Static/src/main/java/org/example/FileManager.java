package org.example;

//Singleton pattern
public class FileManager {
    //private constructor
    private FileManager(){
        //you can still do stuff
    }

    //static constructor
    //it runs when the program starts up
    static {
        System.out.println("I run in the beginning");
    }

    public static void readDealership(){

    }
}
