package backend.academy;

import static org.junit.jupiter.api.Assertions.*;

import backend.academy.model.Word;
import backend.academy.service.WordService;
import backend.academy.service.WordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class WordServiceTest {

    private WordService wordService;

    @BeforeEach
    public void setUp() {
        wordService = new WordServiceImpl();
    }


    @Test
    public void testChooseWordByDifficultFromList() {
        List<Word> wordList = Arrays.asList(
            new Word(new char[]{'e', 'a', 's', 'y'}, "easy", 1),
            new Word(new char[]{'m', 'e', 'd', 'i', 'u', 'm'}, "medium", 2),
            new Word(new char[]{'h', 'a', 'r', 'd'}, "hard", 3)
        );

        Word result = wordService.chooseWordByDifficultFromList(wordList, 2);
        assertEquals(2, result.difficult());
    }
}
