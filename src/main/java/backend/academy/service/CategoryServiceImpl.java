package backend.academy.service;

import backend.academy.model.Word;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CategoryServiceImpl implements CategoryService {
    Map<String, List<Word>> categoryMap;

    @Override
    public boolean isValidCategoryNumber(String number) {
        List<String> temp = new ArrayList<>(categoryMap.keySet());
        try {
            int numberInt = Integer.parseInt(number);
            return numberInt >= 0 && numberInt <= temp.size();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String findCategory(String number) {
        List<String> temp = new ArrayList<>(categoryMap.keySet());
        return temp.get(Integer.parseInt(number));
    }

    @Override
    public List<String> getCategories() {
        return new ArrayList<>(categoryMap.keySet());
    }

    @Override
    public int getRandomCategoryNumber() {
        Random r = new Random();
        List<String> temp = new ArrayList<>(categoryMap.keySet());
        return r.nextInt(temp.size());
    }

    @Override
    public List<Word> getWordsListByCategory(String category) {
        return categoryMap.get(category);
    }

    public CategoryServiceImpl() {
        categoryMap = new HashMap<>();
        setInitialData();
    }

    private void setInitialData() {
        List<Word> animalsList = new ArrayList<>();
        animalsList.add(new Word(new char[] {'c', 'o', 'w'}, "Makes milk", 1));
        animalsList.add(new Word(new char[] {'c', 'a', 't'}, "Drinks milk", 1));
        animalsList.add(new Word(new char[] {'d', 'o', 'g'}, "Best friend of human", 1));
        animalsList.add(new Word(new char[] {'e', 'l', 'e', 'p', 'h', 'a', 'n', 't'}, "Have a big nose", 2));
        animalsList.add(new Word(new char[] {'d', 'u', 'c', 'k', 'b', 'i', 'l', 'l'}, "Half a duck", 3));
        categoryMap.put("Animal", animalsList);
        List<Word> professions = new ArrayList<>();
        professions.add(new Word(new char[] {'t', 'e', 'a', 'c', 'h', 'e', 'r'}, "That make dumb people smart", 2));
        professions.add(new Word(new char[] {'p', 'o', 'l', 'i', 'c', 'e', 'm', 'a', 'n'}, "Catches bad guys", 2));
        professions.add(new Word(new char[] {'c', 'l', 'o', 'w', 'n'}, "Scary one", 1));
        professions.add(new Word(new char[] {'p', 'o', 's', 't', 'm', 'a', 'n'}, "Backenders use this", 3));
        categoryMap.put("Profession", professions);
        List<Word> backendWords = new ArrayList<>();
        backendWords.add(new Word(new char[] {'a', 'p', 'i'}, "Interface", 1));
        backendWords.add(new Word(new char[] {'d', 'a', 't', 'a', 'b', 'a', 's', 'e'}, "Helps keep data in it", 2));
        backendWords.add(new Word(new char[] {'s', 'p', 'r', 'i', 'n', 'g'}, "Java framework", 2));
        backendWords.add(
            new Word(new char[] {'s', 'e', 'c', 'u', 'r', 'i', 't', 'y'}, "It will help you not to be deceived", 2));
        backendWords.add(
            new Word(new char[] {'m', 'i', 'c', 'r', 'o', 's', 'e', 'r', 'v', 'i', 'c', 'e', 's'}, "Divided into parts",
                3));
        categoryMap.put("Backend", backendWords);

    }
}
