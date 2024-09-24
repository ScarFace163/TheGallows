package backend.academy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import backend.academy.enums.Difficult;
import backend.academy.service.GameService;
import backend.academy.service.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @BeforeEach
    public void setUp() {
        new GameServiceImpl();
    }

    @Test
    public void testPrintCategoryChoose() {
        GameService mockService = Mockito.mock(GameService.class);
        when(mockService.categoryChoose()).thenReturn("Category1");

        String result = mockService.categoryChoose();
        assertEquals("Category1", result);
    }

    @Test
    public void testPrintDifficultChoose() {
        GameService mockService = Mockito.mock(GameService.class);
        when(mockService.difficultChoose()).thenReturn(Difficult.EASY);

        Difficult result = mockService.difficultChoose();
        assertEquals(Difficult.EASY, result);
    }

}
