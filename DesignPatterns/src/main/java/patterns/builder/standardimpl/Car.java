package patterns.builder.standardimpl;

public class Car {
    private String model;
    private String engine;
    private int seats;
    private boolean sunroof;

    Car(String model, String engine, int seats, boolean sunroof) {
        this.model = model;
        this.engine = engine;
        this.seats = seats;
        this.sunroof = sunroof;
    }

    @Override
    public String toString() {
        return String.format("Car [Model: %s, Engine: %s, Seats: %d, Sunroof: %s]",
                model, engine, seats, sunroof ? "Yes" : "No");
    }
}