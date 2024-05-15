package patterns.adapter;

public class EuropeanKettle implements EuropeanAppliance {
    @Override
    public void powerOn() {
        System.out.println("European kettle is powered on using 240V!");
    }
}
