package patterns.facade;

public class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, DVDPlayer dvdPlayer) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGetting ready to watch a movie...");
        projector.turnOn();
        soundSystem.turnOn();
        soundSystem.setVolume(20);
        dvdPlayer.insertDisc(movie);
        dvdPlayer.play();
    }

    public void endMovie() {
        System.out.println("\nShutting down the home theater system...");
        dvdPlayer.stop();
        dvdPlayer.eject();
        soundSystem.turnOff();
        projector.turnOff();
    }
}
