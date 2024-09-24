package backend.academy.service;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputOutputServiceImpl implements InputOutputService {
    private final CategoryService categoryService;
    private final SessionService sessionService;
    private final Scanner sc;
    private final List<String> gallowsArr;
    private final Random random = new Random();

    @Override
    public String printCategoryChoose() {
        println(
            "Choose one of the suggested categories. If you want to randomize, press enter without typing.");
        List<String> categories = categoryService.getCategories();
        for (int i = 0; i < categories.size(); i++) {
            println(i + " - " + categories.get(i));
        }
        return inputCategoryNumber();
    }

    private String inputCategoryNumber() {
        String categoryChoose;
        do {
            categoryChoose = sc.nextLine();
            if (categoryChoose.isEmpty()) {
                return null;
            }
        } while (!categoryService.isValidCategoryNumber(categoryChoose));
        return categoryChoose;
    }

    @Override
    public Difficult printDifficultChoose() {
        print(
            "Choose one of the suggested difficult.");
        println(" If you want to randomize, press enter without typing.\n0 - Easy\n1 - Medium\n2 - Hard");
        return Difficult.values()[inputDifficultNumber()];

    }

    @Override
    public void printCurrentGameState(Session session) {
        printGallows(session);
        printCurrentGuess(session);

    }

    @Override
    public boolean conductGameProcess(Session session) {
        while (!sessionService.isGameEnded(session)) {
            printCurrentGameState(session);
            int errorLeft = session.maxAttemptsNumber() - session.currentAttemptsNumber();
            printCurrentLetterInput(session);
            println("Errors left: " + errorLeft);
            if (errorLeft >= session.minErrorsForHint() && !session.isHintUsed()) {
                println("Enter letter or -1 if you want a hint");
            } else {
                println("Enter letter");
            }
            String letter = sc.nextLine();
            if (errorLeft >= session.minErrorsForHint() && "-1".equals(letter) && !session.isHintUsed()) {
                printHint(session);
                continue;
            }
            if (!checkLetter(session, letter)) {
                continue;
            }
            if (sessionService.checkLetter(session, letter)) {
                sessionService.putLetter(session, letter);
            }
        }
        printCurrentGameState(session);
        return session.currentAttemptsNumber() != session.maxAttemptsNumber();
    }

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

    private boolean checkLetter(Session session, String letter) {
        if (letter.length() != 1) {
            return false;
        }
        if (session.usedLettersSet().contains(letter.charAt(0))) {
            return false;
        }
        return Character.isLetter(letter.charAt(0));
    }

    private void printGallows(Session session) {
        println(gallowsArr.get(session.currentAttemptsNumber()));
    }

    private void printHint(Session session) {
        println("HINT: " + session.answer().hint());
        sessionService.useHint(session);
    }

    private void printCurrentLetterInput(Session session) {
        if (!session.usedLettersSet().isEmpty()) {
            println(session.usedLettersSet().toString());
        }
    }

    private void printCurrentGuess(Session session) {
        char[] currentGuess = session.currentGuess();
        for (char ch : currentGuess) {
            print(ch + " ");
        }
        println("\n");
    }

    private int inputDifficultNumber() {
        String difficultChoose;
        do {
            difficultChoose = sc.nextLine();
            if (difficultChoose.isEmpty()) {
                return random.nextInt(Difficult.values().length);
            }
        } while (!"0".equals(difficultChoose) && !"1".equals(difficultChoose) && !"2".equals(difficultChoose));
        return Integer.parseInt(difficultChoose);
    }

    public InputOutputServiceImpl() {
        categoryService = new CategoryServiceImpl();
        sessionService = new SessionServiceImpl();
        sc = new Scanner(System.in, StandardCharsets.UTF_8);
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
