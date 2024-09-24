package backend.academy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import backend.academy.enums.Difficult;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InputOutputServiceTest {

    @BeforeEach
    public void setUp() {
        new InputOutputServiceImpl();
    }

    @Test
    public void testPrintCategoryChoose() {
        InputOutputService mockService = Mockito.mock(InputOutputService.class);
        when(mockService.printCategoryChoose()).thenReturn("Category1");

        String result = mockService.printCategoryChoose();
        assertEquals("Category1", result);
    }

    @Test
    public void testPrintDifficultChoose() {
        InputOutputService mockService = Mockito.mock(InputOutputService.class);
        when(mockService.printDifficultChoose()).thenReturn(Difficult.EASY);

        Difficult result = mockService.printDifficultChoose();
        assertEquals(Difficult.EASY, result);
    }

    @Test
    public void testPrint() {
        InputOutputService mockService = Mockito.mock(InputOutputService.class);
        mockService.print("Test message");

        verify(mockService).print("Test message");
    }
}
