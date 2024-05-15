package patterns.state;

public class SoldState implements State {
    private VendingMachine vendingMachine;

    public SoldState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait. Dispensing in progress.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Cannot eject coin. Dispensing in progress.");
    }

    @Override
    public void pressButton() {
        System.out.println("Already dispensing.");
    }

    @Override
    public void dispense() {
        System.out.println("Item dispensed.");
        if (vendingMachine.getCount() > 0) {
            vendingMachine.setState(vendingMachine.getNoCoinState());
        } else {
            System.out.println("Machine is now sold out.");
            vendingMachine.setState(vendingMachine.getSoldOutState());
        }
    }
}
