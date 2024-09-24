package backend.academy.service;

import backend.academy.enums.Difficult;
import backend.academy.model.Word;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordServiceImpl implements WordService {
    @Override
    public Word chooseWordByDifficultFromList(List<Word> wordList, Difficult difficult) {
        Random random = new Random();
        List<Word> listByDifficult = new ArrayList<>();
        for (Word w : wordList) {
            if (w.difficult() == difficult) {
                listByDifficult.add(w);
            }
        }
        return listByDifficult.get(random.nextInt(listByDifficult.size()));
    }
}
