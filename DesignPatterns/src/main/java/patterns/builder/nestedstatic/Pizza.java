package patterns.builder.nestedstatic;

public class Pizza {
    private String size;
    private String crustType;
    private boolean extraCheese;
    private boolean pepperoni;
    private boolean mushrooms;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crustType = builder.crustType;
        this.extraCheese = builder.extraCheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    public String getSize() { return size; }
    public String getCrustType() { return crustType; }
    public boolean hasExtraCheese() { return extraCheese; }
    public boolean hasPepperoni() { return pepperoni; }
    public boolean hasMushrooms() { return mushrooms; }

    public static class Builder {
        private String size;
        private String crustType;
        private boolean extraCheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;

        public Builder(String size, String crustType) {
            this.size = size;
            this.crustType = crustType;
        }

        public Builder addExtraCheese() {
            this.extraCheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Pizza [Size: %s, Crust: %s, Extra Cheese: %s, Pepperoni: %s, Mushrooms: %s]",
                size, crustType, extraCheese, pepperoni, mushrooms
        );
    }
}
