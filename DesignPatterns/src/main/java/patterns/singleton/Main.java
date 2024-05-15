package patterns.singleton;

public class Main {
    public static void main(String[] args) {
        ConfigManager config1 = ConfigManager.getInstance();

        System.out.println("App Name: " + config1.getSetting("appName"));
        System.out.println("Version: " + config1.getSetting("version"));
        System.out.println("Debug Mode: " + config1.getSetting("debugMode"));

        config1.setSetting("debugMode", "false");

        ConfigManager config2 = ConfigManager.getInstance();
        System.out.println("\nUpdated Debug Mode: " + config2.getSetting("debugMode"));

        System.out.println("Are both instances the same? " + (config1 == config2));
    }
}
