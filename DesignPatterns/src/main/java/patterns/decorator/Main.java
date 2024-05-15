package patterns.decorator;

public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();

        coffee = new MilkDecorator(coffee);

        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription() + " costs $" + coffee.cost());
    }
}
