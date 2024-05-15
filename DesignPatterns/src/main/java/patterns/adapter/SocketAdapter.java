package patterns.adapter;

public class SocketAdapter implements EuropeanAppliance {
    private USASocket usaSocket;

    public SocketAdapter(USASocket usaSocket) {
        this.usaSocket = usaSocket;
    }

    @Override
    public void powerOn() {
        int voltage = usaSocket.output120V();
        int convertedVoltage = convert120Vto240V(voltage);
        System.out.println("Adapter converted voltage to " + convertedVoltage + "V.");
        System.out.println("European appliance can now be powered using the adapter.");
    }

    private int convert120Vto240V(int voltage) {
        return voltage * 2;
    }
}
