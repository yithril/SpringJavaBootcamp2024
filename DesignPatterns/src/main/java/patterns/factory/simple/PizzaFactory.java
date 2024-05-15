package patterns.factory.simple;

public class PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                break;
            case "veggie":
                pizza = new VeggiePizza();
                break;
        }
        return pizza;
    }
}

interface Pizza {
    void prepare();
    void bake();
    void cut();
}

class CheesePizza implements Pizza {
    public void prepare() { System.out.println("Preparing Cheese Pizza"); }
    public void bake() { System.out.println("Baking Cheese Pizza"); }
    public void cut() { System.out.println("Cutting Cheese Pizza"); }
}

class PepperoniPizza implements Pizza {
    public void prepare() { System.out.println("Preparing Pepperoni Pizza"); }
    public void bake() { System.out.println("Baking Pepperoni Pizza"); }
    public void cut() { System.out.println("Cutting Pepperoni Pizza"); }
}

class VeggiePizza implements Pizza {
    public void prepare() { System.out.println("Preparing Veggie Pizza"); }
    public void bake() { System.out.println("Baking Veggie Pizza"); }
    public void cut() { System.out.println("Cutting Veggie Pizza"); }
}