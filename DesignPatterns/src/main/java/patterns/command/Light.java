package patterns.command;

public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is turned on.");
    }

    public void turnOff() {
        System.out.println(location + " light is turned off.");
    }
}
