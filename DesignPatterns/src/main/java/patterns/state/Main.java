package patterns.state;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(3);

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.ejectCoin();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
        vendingMachine.pressButton();

        vendingMachine.insertCoin();
    }
}
