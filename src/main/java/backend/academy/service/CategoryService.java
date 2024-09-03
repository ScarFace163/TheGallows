package backend.academy.service;

import backend.academy.model.Word;
import java.util.List;

public interface CategoryService {
    boolean isValidCategoryNumber(int number);
    String findCategory(int number);
    List<Word> getWordsListByCategory(String category);
    List<String> getCategories();
    int getRandomCategoryNumber();
}
