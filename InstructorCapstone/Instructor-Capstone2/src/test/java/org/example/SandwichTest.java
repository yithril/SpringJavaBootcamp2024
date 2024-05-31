package org.example;

import org.example.enums.IngredientType;
import org.example.enums.SandwichSize;
import org.example.strategy.BreadPricingStrategy;
import org.example.strategy.PremiumToppingPricingStrategy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {
    @Test
    public void testSandwichBuilder() {
        Sandwich sandwich = new Sandwich.SandwichBuilder()
                .setSandwichSize(SandwichSize.MEDIUM)
                .setBread(new Ingredient(1, IngredientType.BREAD, BigDecimal.valueOf(5.5), "White", new BreadPricingStrategy()))
                .addIngredient(new Ingredient(2, IngredientType.MEAT, BigDecimal.valueOf(1), "Beef", new PremiumToppingPricingStrategy()))
                .build();

        assertNotNull(sandwich);
        assertEquals(SandwichSize.MEDIUM, sandwich.getSandwichSize());
        assertTrue(sandwich.getIngredientList().size() > 0);
        assertEquals(0, BigDecimal.valueOf(9).compareTo(sandwich.getTotalPrice()));
    }

    @Test
    public void testAddExtraMeatWithoutMeat() {
        Sandwich.SandwichBuilder builder = new Sandwich.SandwichBuilder();
        builder.setSandwichSize(SandwichSize.MEDIUM)
                .setBread(new Ingredient(1, IngredientType.BREAD, BigDecimal.valueOf(5.5), "White", new BreadPricingStrategy()));

        Ingredient extraMeat = new Ingredient(2, IngredientType.EXTRA_MEAT, BigDecimal.valueOf(1), "Extra Beef", new PremiumToppingPricingStrategy());
        builder.addExtraMeat(extraMeat);

        Sandwich sandwich = builder.build();

        assertFalse(sandwich.getIngredientList().stream().anyMatch(x -> x.getIngredientType().equals(IngredientType.EXTRA_MEAT)));
    }

    @Test
    public void testAddExtraCheeseWithoutCheese() {
        Sandwich.SandwichBuilder builder = new Sandwich.SandwichBuilder();
        builder.setSandwichSize(SandwichSize.MEDIUM)
                .setBread(new Ingredient(1, IngredientType.BREAD, BigDecimal.valueOf(5.5), "White", new BreadPricingStrategy()));

        Ingredient extraCheese = new Ingredient(3, IngredientType.EXTRA_CHEESE, BigDecimal.valueOf(0.75), "Extra Swiss", new PremiumToppingPricingStrategy());
        builder.addExtraCheese(extraCheese);

        Sandwich sandwich = builder.build();

        assertFalse(sandwich.getIngredientList().stream().anyMatch(x -> x.getIngredientType().equals(IngredientType.EXTRA_CHEESE)));
    }

    @Test
    public void testBuildWithoutSizeThrowsException() {
        Sandwich.SandwichBuilder builder = new Sandwich.SandwichBuilder();
        builder.setBread(new Ingredient(1, IngredientType.BREAD, BigDecimal.valueOf(5.5), "White", new BreadPricingStrategy()));

        Exception exception = assertThrows(IllegalStateException.class, builder::build);
        String expectedMessage = "Sandwiches must have a size and bread type selected.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void testBuildWithoutBreadThrowsException() {
        Sandwich.SandwichBuilder builder = new Sandwich.SandwichBuilder();
        builder.setSandwichSize(SandwichSize.MEDIUM);

        Exception exception = assertThrows(IllegalStateException.class, builder::build);
        String expectedMessage = "Sandwiches must have a size and bread type selected.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}