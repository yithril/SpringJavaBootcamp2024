package org.example;

import org.example.enums.IngredientType;
import org.example.strategy.BreadPricingStrategy;
import org.example.strategy.PremiumToppingPricingStrategy;
import org.example.strategy.PricingStrategy;
import org.example.strategy.RegularToppingPricingStrategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class IngredientLoader {
    private static ArrayList<Ingredient> ingredients;
    private static ArrayList<SideItem> sideItems;

    static {
        ingredients = new ArrayList<>();
        sideItems = new ArrayList<>();
        loadIngredients();
    }

    private IngredientLoader(){

    }

    public static List<Ingredient> getIngredientByType(IngredientType ingredientType){
        return ingredients.stream().filter(x -> x.getIngredientType().equals(ingredientType)).sorted(Comparator.comparing(Ingredient::getName)).toList();
    }

    private static void loadIngredients(){
        try{
            FileInputStream fs = new FileInputStream("src/main/resources/ingredients.csv");

            Scanner scanner = new Scanner(fs);

            String input;
            int counter = 1;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                try{
                    String[] ingredientRow = input.split("\\|");

                    var strategy = getStrategyByIngredientType(IngredientType.valueOf(ingredientRow[1].toUpperCase()));

                    Ingredient ingredient = new Ingredient(Integer.parseInt(ingredientRow[0]), IngredientType.valueOf(ingredientRow[1].toUpperCase()), new BigDecimal(ingredientRow[2]), ingredientRow[3], strategy);

                    ingredients.add(ingredient);
                }
                catch(Exception ex){
                    System.out.println("Bad data found in file on line " + counter + ".");
                    ex.printStackTrace();
                }
                counter++;
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Couldn't find ingredient file to load.");
        }
    }

    private static PricingStrategy getStrategyByIngredientType(IngredientType ingredientType){
        return switch(ingredientType){
            case REGULAR_TOPPING, SAUCES, SIDES -> new RegularToppingPricingStrategy();
            case MEAT, CHEESE, EXTRA_CHEESE, EXTRA_MEAT -> new PremiumToppingPricingStrategy();
            case BREAD -> new BreadPricingStrategy();
        };
    }
}
