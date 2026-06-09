import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

// Dummy classes to make the code self-contained
class ExternalApi {
    public String getData() {
        return "Real Data";
    }
}

class MyService {
    private ExternalApi api;
    
    public MyService(ExternalApi api) {
        this.api = api;
    }
    
    public void fetchData() {
        api.getData();
    }
}

public class VerifyingInteractionsTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        // 2. Call the method 
        service.fetchData();
        
        // 3. Verify the interaction (that getData() was called exactly once)
        verify(mockApi).getData();
    }
}