package patterns.factory.regular;

public abstract class LoggerFactory {
    public Logger createLogger() {
        Logger logger = createLoggerImplementation();
        logger.initialize();
        return logger;
    }

    protected abstract Logger createLoggerImplementation();
}

interface Logger {
    void log(String message);
    void initialize();
}

class FileLogger implements Logger {
    public void log(String message) { System.out.println("Logging to a file: " + message); }
    public void initialize() { System.out.println("File Logger Initialization"); }
}

class ConsoleLogger implements Logger {
    public void log(String message) { System.out.println("Logging to console: " + message); }
    public void initialize() { System.out.println("Console Logger Initialization"); }
}

class FileLoggerFactory extends LoggerFactory {
    protected Logger createLoggerImplementation() {
        return new FileLogger();
    }
}

class ConsoleLoggerFactory extends LoggerFactory {
    protected Logger createLoggerImplementation() {
        return new ConsoleLogger();
    }
}
