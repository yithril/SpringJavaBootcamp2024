package patterns.strategy;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Gadget", 100);

        DiscountContext context = new DiscountContext(new PercentageDiscountStrategy(15.0));
        double discountedPrice = context.calculateDiscountedPrice(product.getPrice());
        System.out.println("Price with 15% Percentage Discount: $" + discountedPrice);

        context.setDiscountStrategy(new FlatRateDiscountStrategy(20.0));
        discountedPrice = context.calculateDiscountedPrice(product.getPrice());
        System.out.println("Price with $20 Flat Rate Discount: $" + discountedPrice);
    }
}
