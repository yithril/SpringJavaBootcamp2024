package patterns.strategy;

public class FlatRateDiscountStrategy implements IDiscountStrategy {
    private double discountAmount;

    public FlatRateDiscountStrategy(double discountAmount) {
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount cannot be negative");
        }
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        // Ensure the discounted price does not drop below zero
        return Math.max(0, price - discountAmount);
    }
}
