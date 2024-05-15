package patterns.state;

public class SoldOutState implements State {
    private VendingMachine vendingMachine;

    public SoldOutState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Cannot insert coin. The machine is sold out.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to eject.");
    }

    @Override
    public void pressButton() {
        System.out.println("Machine is sold out.");
    }

    @Override
    public void dispense() {
        System.out.println("No items to dispense.");
    }
}