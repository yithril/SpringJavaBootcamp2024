package org.example;

import org.example.enums.IngredientType;
import org.example.enums.SandwichSize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private SandwichSize sandwichSize;
    private List<Ingredient> ingredientList;

    private Sandwich(){
        ingredientList = new ArrayList<>();
    }

    public BigDecimal getTotalPrice(){
        return this.ingredientList.stream().map(x -> x.getPrice(this.sandwichSize)).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Ingredient> getIngredientList(){
        return this.ingredientList;
    }

    public SandwichSize getSandwichSize(){
        return this.sandwichSize;
    }

    private boolean hasMeat(){
        return this.ingredientList.stream().anyMatch(x -> x.getIngredientType().equals(IngredientType.MEAT));
    }

    private boolean hasCheese(){
        return this.ingredientList.stream().anyMatch(x -> x.getIngredientType().equals(IngredientType.CHEESE));
    }

    private boolean hasBread() {
        return this.ingredientList.stream().anyMatch(ingredient -> ingredient.getIngredientType().equals(IngredientType.BREAD));
    }

    public static class SandwichBuilder {
        private Sandwich sandwich;

        public SandwichBuilder() {
            sandwich = new Sandwich();
        }
        public SandwichBuilder(Sandwich existingSandwich) {
            this.sandwich = existingSandwich;
        }

        public SandwichBuilder clear() {
            sandwich = new Sandwich();
            return this;
        }

        public SandwichBuilder setSandwichSize(SandwichSize sandwichSize){
            this.sandwich.sandwichSize = sandwichSize;
            return this;
        }

        public SandwichBuilder setBread(Ingredient newBread) {
            if (newBread.getIngredientType().equals(IngredientType.BREAD)) {
                sandwich.ingredientList.removeIf(ingredient -> ingredient.getIngredientType().equals(IngredientType.BREAD));
                sandwich.ingredientList.add(newBread);
            }
            return this;
        }

        public SandwichBuilder addIngredient(Ingredient ingredient){
            if(ingredient != null){
                sandwich.ingredientList.add(ingredient);
            }
            return this;
        }

        public SandwichBuilder addMultipleIngredients(List<Ingredient> ingredients){
            if(ingredients != null && ingredients.size() > 0){
                sandwich.ingredientList.addAll(ingredients);
            }
            return this;
        }

        public SandwichBuilder addExtraMeat(Ingredient ingredient){
            if(ingredient.getIngredientType().equals(IngredientType.EXTRA_MEAT) && sandwich.hasMeat()){
                sandwich.ingredientList.add(ingredient);
            }
            else{
                System.out.println("Meat must be present before being able to add extra meat.");
            }
            return this;
        }

        public SandwichBuilder addExtraCheese(Ingredient ingredient){
            if(ingredient.getIngredientType().equals(IngredientType.EXTRA_CHEESE) && sandwich.hasCheese()){
                sandwich.ingredientList.add(ingredient);
            }
            else{
                System.out.println("Cheese must be present before being able to add extra cheese.");
            }
            return this;
        }

        public Sandwich build(){
            if (sandwich.sandwichSize == null || !sandwich.hasBread()) {
                throw new IllegalStateException("Sandwiches must have a size and bread type selected.");
            }
            Sandwich builtSandwich = sandwich;
            sandwich = new Sandwich();
            return builtSandwich;
        }
    }
}
