package patterns.facade;

public class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is now ON.");
    }

    public void turnOff() {
        System.out.println("Sound System is now OFF.");
    }

    public void setVolume(int level) {
        System.out.println("Sound System volume set to " + level);
    }
}
