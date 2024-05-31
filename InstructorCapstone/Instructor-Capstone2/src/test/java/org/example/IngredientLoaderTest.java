package org.example;

import org.example.enums.IngredientType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientLoaderTest {

    @Test
    public void ingredientLoader_loadsIngredients(){
        var breads = IngredientLoader.getIngredientByType(IngredientType.BREAD);
        var meats = IngredientLoader.getIngredientByType(IngredientType.MEAT);
        var cheeses = IngredientLoader.getIngredientByType(IngredientType.CHEESE);
        var sauces = IngredientLoader.getIngredientByType(IngredientType.SAUCES);
        var toppings = IngredientLoader.getIngredientByType(IngredientType.REGULAR_TOPPING);
        var sides = IngredientLoader.getIngredientByType(IngredientType.SIDES);

        assertEquals(4, breads.size());
        assertEquals(4, cheeses.size());
        assertEquals(6, meats.size());
        assertEquals(9, toppings.size());
        assertEquals(6, sauces.size());
        assertEquals(2, sides.size());
    }
}