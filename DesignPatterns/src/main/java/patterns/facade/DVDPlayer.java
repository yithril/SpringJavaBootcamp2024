package patterns.facade;


public class DVDPlayer {
    public void insertDisc(String movie) {
        System.out.println("Inserting the DVD: " + movie);
    }

    public void play() {
        System.out.println("DVD Player is now PLAYING.");
    }

    public void stop() {
        System.out.println("DVD Player is now STOPPED.");
    }

    public void eject() {
        System.out.println("DVD is now EJECTED.");
    }
}