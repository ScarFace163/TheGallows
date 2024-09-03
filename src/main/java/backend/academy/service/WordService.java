package backend.academy.service;

import backend.academy.model.Word;
import java.util.List;

public interface WordService {
    Word chooseWordByDifficultFromList(List<Word> wordList, int difficult);
}
