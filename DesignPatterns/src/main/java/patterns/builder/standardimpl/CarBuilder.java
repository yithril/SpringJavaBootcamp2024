package patterns.builder.standardimpl;

public class CarBuilder {
    private String model;
    private String engine;
    private int seats = 4;
    private boolean sunroof = false;

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public CarBuilder setSeats(int seats) {
        this.seats = seats;
        return this;
    }

    public CarBuilder addSunroof() {
        this.sunroof = true;
        return this;
    }

    public Car build() {
        return new Car(model, engine, seats, sunroof);
    }
}
