package patterns.command;

public class LightOffCommand implements Command {
    private Light light;

    // Constructor receives a `Light` instance (the receiver)
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
