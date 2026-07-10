import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnitSetupTest {

    @Test
    public void testSetup() {
        // Simple test to verify JUnit 5 is set up correctly
        System.out.println("JUnit 5 is working!");
        assertTrue(true, "This should always pass");
    }
}