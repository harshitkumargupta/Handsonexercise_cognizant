import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAAPatternTest {

    private int testValue;

    @BeforeEach
    public void setUp() {
        // Setup code executed before each test
        System.out.println("Setting up test fixture...");
        testValue = 10;
    }

    @AfterEach
    public void tearDown() {
        // Teardown code executed after each test
        System.out.println("Tearing down test fixture...");
        testValue = 0;
    }

    @Test
    public void testAdditionWithAAA() {
        // Arrange
        int a = 5;
        int b = testValue;
        
        // Act
        int result = a + b;
        
        // Assert
        assertEquals(15, result, "5 + 10 should equal 15");
    }
}