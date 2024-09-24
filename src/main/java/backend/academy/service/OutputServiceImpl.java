package backend.academy.service;

import backend.academy.model.Session;
import java.util.ArrayList;
import java.util.List;

public class OutputServiceImpl implements  OutputService {
    private final CategoryService categoryService;
    private final SessionService sessionService;
    private final List<String> gallowsArr;

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    @Override
    public void println(String s) {
        System.out.println(s);
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    @Override
    public void print(String s) {
        System.out.print(s);
    }

    @Override
    public void printCategoryChoose() {
        println(
            "Choose one of the suggested categories. If you want to randomize, press enter without typing.");
        List<String> categories = categoryService.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            println(i + " - " + categories.get(i));
        }
    }

    @Override
    public void printDifficultChoose() {
        print(
            "Choose one of the suggested difficult.");
        println(" If you want to randomize, press enter without typing.\n0 - Easy\n1 - Medium\n2 - Hard");
    }

    @Override
    public void printCurrentGameState(Session session) {
        printGallows(session);
        printCurrentGuess(session);
    }

    @Override
    public void printGallows(Session session) {
        println(gallowsArr.get(session.currentAttemptsNumber()));
    }

    @Override
    public void printHint(Session session) {
        println("HINT: " + session.answer().hint());
        sessionService.useHint(session);
    }

    @Override
    public void printCurrentLetterInput(Session session) {
        if (!session.usedLettersSet().isEmpty()) {
            println(session.usedLettersSet().toString());
        }
    }

    @Override
    public void printCurrentGuess(Session session) {
        char[] currentGuess = session.currentGuess();
        for (char ch : currentGuess) {
            print(ch + " ");
        }
        println("\n");
    }

    public OutputServiceImpl() {
        this.categoryService = new CategoryServiceImpl();
        this.sessionService = new SessionServiceImpl();
        gallowsArr = new ArrayList<>();
        gallowsArr.add("""
            *----*
                 |
                 |
                 |
               =====""");
        gallowsArr.add("""
             *----*
             O    |
                  |
                  |
                =====\
            """);
        gallowsArr.add("""
            *----*
             O    |
             |    |
                  |
                =====""");
        gallowsArr.add("""
             *----*
             O    |
            /|    |
                  |
                =====""");
        gallowsArr.add("""
             *----*
             O    |
            /|\\   |
                  |
                =====""");
        gallowsArr.add("""
             *----*
             O    |
            /|\\   |
             |    |
                =====""");
        gallowsArr.add("""
            *----*
             O   |
            /|\\  |
            /    |
                =====""");
        gallowsArr.add("""
            *----*
             O   |
            /|\\  |
            / \\  |
                ====""");
    }
}
