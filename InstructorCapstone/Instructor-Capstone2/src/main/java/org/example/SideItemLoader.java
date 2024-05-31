package org.example;

import org.example.enums.SideItemType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SideItemLoader {
    private static ArrayList<SideItem> sideItems;

    private SideItemLoader(){

    }

    static {
        sideItems = new ArrayList<>();
        loadSideItems();
    }

    public static List<SideItem> getSideItemsByType(SideItemType sideItemType){
        return sideItems.stream().filter(x -> x.getSideItemType().equals(sideItemType)).toList();
    }

    public static List<SideItem> getAllSideItems(){
        return sideItems.stream().sorted(Comparator.comparing(SideItem::getName)).toList();
    }

    private static void loadSideItems(){
        try{
            FileInputStream fs = new FileInputStream("src/main/resources/sideitems.csv");

            Scanner scanner = new Scanner(fs);

            String input;
            int counter = 1;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                try{
                    String[] sideItemRow = input.split("\\|");

                    SideItem sideItem = new SideItem(Integer.parseInt(sideItemRow[0]),
                            new BigDecimal(sideItemRow[1]), Integer.parseInt(sideItemRow[2]), sideItemRow[3], Boolean.parseBoolean(sideItemRow[4]),
                            SideItemType.valueOf(sideItemRow[5].toUpperCase()));

                    sideItems.add(sideItem);
                }
                catch(Exception ex){
                    System.out.println("Bad data found in side item file on line " + counter + ".");
                    ex.printStackTrace();
                }
                counter++;
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Couldn't find side items file to load.");
        }
    }
}
