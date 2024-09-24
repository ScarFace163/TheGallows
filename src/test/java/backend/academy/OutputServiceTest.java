package backend.academy;

import static org.mockito.Mockito.*;

import backend.academy.service.OutputService;
import backend.academy.service.OutputServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OutputServiceTest {

    @BeforeEach
    public void setUp() {
        new OutputServiceImpl();
    }

    @Test
    public void testPrintMessage() {
        OutputService mockService = Mockito.mock(OutputService.class);
        mockService.print("Test message");

        verify(mockService).print("Test message");
    }

}
