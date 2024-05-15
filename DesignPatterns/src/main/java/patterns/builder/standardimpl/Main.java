package patterns.builder.standardimpl;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .setModel("SUV")
                .setEngine("V8")
                .setSeats(7)
                .addSunroof()
                .build();

        System.out.println(car);
    }
}
