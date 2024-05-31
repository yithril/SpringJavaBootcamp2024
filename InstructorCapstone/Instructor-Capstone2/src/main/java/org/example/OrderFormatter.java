package org.example;

import org.example.enums.IngredientType;
import org.example.enums.SandwichSize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrderFormatter {

    private OrderFormatter(){

    }
    public static String toCommaDelimitedList(List<Ingredient> ingredientList, IngredientType ingredientType){
        return IngredientLoader.getIngredientByType(ingredientType).stream().map(Ingredient::getName).collect(Collectors.joining(", "));
    }

    public static String sandwichSizes(){
        return Arrays.stream(SandwichSize.values()).map(Enum::name).collect(Collectors.joining(", "));
    }
}
