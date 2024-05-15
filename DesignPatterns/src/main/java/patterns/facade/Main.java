package patterns.facade;

public class Main {
    public static void main(String[] args) {
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem, dvdPlayer);

        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
