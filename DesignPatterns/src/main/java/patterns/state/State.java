package patterns.state;


public interface State {
    void insertCoin();
    void ejectCoin();
    void pressButton();
    void dispense();
}
