package patterns.strategy;

public class NoDiscountStrategy implements IDiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
