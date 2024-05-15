package patterns.strategy;

public class PercentageDiscountStrategy implements IDiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage should be between 0 and 100");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - (percentage / 100));
    }
}
