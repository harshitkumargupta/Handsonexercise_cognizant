public class SingletonTest {
    public static void main(String[] args) {
        // Attempt to get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify if both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Singleton pattern is working correctly. Both loggers are the same instance.");
        } else {
            System.out.println("Singleton pattern failed. Loggers are different instances.");
        }
        
        logger1.log("This is a test log message from logger1.");
        logger2.log("This is a test log message from logger2.");
    }
}
