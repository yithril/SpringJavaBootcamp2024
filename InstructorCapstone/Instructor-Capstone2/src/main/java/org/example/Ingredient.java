package org.example;

import org.example.enums.IngredientType;
import org.example.enums.SandwichSize;
import org.example.strategy.PricingStrategy;

import java.math.BigDecimal;

public class Ingredient {
    //This is to uniquely identify ingredients.
    private int ingredientId;
    private IngredientType ingredientType;
    private BigDecimal basePrice;
    private PricingStrategy pricingStrategy;
    private String name;

    public Ingredient(int ingredientId, IngredientType ingredientType, BigDecimal basePrice, String name, PricingStrategy pricingStrategy) {
        this.ingredientId = ingredientId;
        this.ingredientType = ingredientType;
        this.basePrice = basePrice;
        this.name = name;
        this.pricingStrategy = pricingStrategy;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice(SandwichSize sandwichSize){
        if(this.pricingStrategy == null){
            throw new IllegalStateException("Ingredients must have a pricing strategy");
        }
        return this.pricingStrategy.getPrice(sandwichSize, this.basePrice);
    }
}
