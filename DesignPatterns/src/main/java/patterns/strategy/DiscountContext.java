package patterns.strategy;

public class DiscountContext {
    private IDiscountStrategy discountStrategy;

    public DiscountContext(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(IDiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscountedPrice(double price) {
        return discountStrategy.applyDiscount(price);
    }
}
