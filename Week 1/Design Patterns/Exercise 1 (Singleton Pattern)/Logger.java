public class Logger {
    // Private static instance of the same class
    private static Logger instance;

    // Private constructor to restrict instantiation from other classes
    private Logger() {
    }

    // Public static method that returns the instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}