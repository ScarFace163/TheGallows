package backend.academy.service;

import backend.academy.model.Word;
import java.util.List;

public interface CategoryService {
    boolean isValidCategoryNumber(String number);
    String findCategory(String  number);
    List<Word> getWordsListByCategory(String category);
    List<String> getCategories();
    int getRandomCategoryNumber();
}
