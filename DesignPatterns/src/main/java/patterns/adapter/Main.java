package patterns.adapter;

public class Main {
    public static void main(String[] args) {
        USASocket usaSocket = new USASocketImpl();

        EuropeanAppliance kettleAdapter = new SocketAdapter(usaSocket);
        kettleAdapter.powerOn();
    }
}
