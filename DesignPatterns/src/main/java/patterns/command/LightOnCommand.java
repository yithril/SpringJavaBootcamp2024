package patterns.command;

public class LightOnCommand implements Command {
    private Light light;

    // Constructor receives a `Light` instance (the receiver)
    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
