package backend.academy;

import backend.academy.model.Word;
import backend.academy.service.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup() {
        categoryService = new CategoryServiceImpl();
    }

    @Test
    public void testIsValidCategoryNumber() {
        assertTrue(categoryService.isValidCategoryNumber("0"));
        assertFalse(categoryService.isValidCategoryNumber("10"));
        assertFalse(categoryService.isValidCategoryNumber("invalid"));
    }

    @Test
    public void testFindCategory() {
        assertEquals("Animal", categoryService.findCategory("2"));
        assertEquals("Profession", categoryService.findCategory("0"));
    }

    @Test
    public void testGetCategories() {
        List<String> categories = categoryService.getCategories();
        assertEquals(3, categories.size());
        assertTrue(categories.contains("Animal"));
        assertTrue(categories.contains("Profession"));
        assertTrue(categories.contains("Backend"));
    }

    @Test
    public void testGetRandomCategoryNumber() {
        int randomCategoryNumber = categoryService.getRandomCategoryNumber();
        assertTrue(randomCategoryNumber >= 0 && randomCategoryNumber < categoryService.getCategories().size());
    }

    @Test
    public void testGetWordsListByCategory() {
        List<Word> words = categoryService.getWordsListByCategory("Animal");
        assertNotNull(words);
        assertEquals(5, words.size());
    }
}
