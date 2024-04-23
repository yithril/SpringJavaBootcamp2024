package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product product = new Product(7, "LG TV", 450.0, "Electronics");

        //The method is static, no need to instantiate FileManager!
        FileManager.writeProductToFile(product);
    }
}