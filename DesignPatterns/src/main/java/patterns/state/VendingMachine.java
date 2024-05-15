package patterns.state;

public class VendingMachine {
    private State noCoinState;
    private State hasCoinState;
    private State soldState;
    private State soldOutState;
    private State currentState;

    private int itemCount;

    public VendingMachine(int itemCount) {
        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);

        this.itemCount = itemCount;
        currentState = (itemCount > 0) ? noCoinState : soldOutState;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void pressButton() {
        currentState.pressButton();
        currentState.dispense();
    }

    public void setState(State newState) {
        currentState = newState;
    }

    public State getNoCoinState() {
        return noCoinState;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return itemCount;
    }

    public void releaseItem() {
        if (itemCount > 0) {
            itemCount--;
        }
    }
}