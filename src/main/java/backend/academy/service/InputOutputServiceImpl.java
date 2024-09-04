package backend.academy.service;

import backend.academy.model.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputOutputServiceImpl implements InputOutputService{
    CategoryService categoryService;
    SessionService sessionService;
    Scanner sc;
    List <String> gallowsArr;
    @Override
    public String printCategoryChoose() {
        System.out.println("Choose one of the suggested categories. If you want to randomize, press enter without typing.");
        List<String> categories = categoryService.getCategories();
        for (int i = 0; i <categories.size(); i++){
            System.out.println(i + " - " + categories.get(i));
        }
        return inputCategoryNumber();
    }
    private String inputCategoryNumber() {
        String categoryChoose;
        do{
            categoryChoose = sc.nextLine();
            if (categoryChoose.isEmpty()) return null;
        }while ( !categoryService.isValidCategoryNumber(categoryChoose));
        return categoryChoose;
    }

    @Override
    public int printDifficultChoose() {
        System.out.println("Choose one of the suggested difficult. If you want to randomize, press enter without typing.\n1 - Easy\n2 - Medium\n3 - Hard");
        return inputDifficultNumber();

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
            int errorLeft = session.maxAttemptsNumber()-session.currentAttemptsNumber();
            printCurrentLetterInput(session);
            System.out.println("Errors left: " + errorLeft);
            if (errorLeft >= 3) System.out.println("Enter letter or -1 if you want a hint");
            else System.out.println("Enter letter");
            String letter = sc.nextLine();
            if (errorLeft>=3 && letter.equals("-1")) {
                printHint(session);
                continue;
            }
            if (!checkLetter(session,letter)) continue;
            if (sessionService.checkLetter(session, letter)) sessionService.putLetter(session,letter) ;
        }
        printCurrentGameState(session);
        return session.currentAttemptsNumber() != session.maxAttemptsNumber();
    }
    private boolean checkLetter(Session session,String letter){
        if (letter.length()!=1) return false;
        if (session.usedLettersSet().contains(letter.charAt(0))) return false;
        return Character.isLetter(letter.charAt(0));
    }
    private void printGallows(Session session) {
        System.out.println(gallowsArr.get(session.currentAttemptsNumber()));
    }
    private void printHint(Session session){
        System.out.println("HINT: " + session.answer().HINT());
        session.currentAttemptsNumber(session.currentAttemptsNumber()+2);
    }
    private void printCurrentLetterInput(Session session){
        if (!session.usedLettersSet().isEmpty()) System.out.println(session.usedLettersSet());
    }
    private void printCurrentGuess(Session session){
        char[] currentGuess = session.currentGuess();
        for (char ch : currentGuess) {
            System.out.print(ch + " ");
        }
        System.out.println("\n");
    }

    private int inputDifficultNumber() {
        Random random = new Random();
        String difficultChoose;
        do{
            difficultChoose = sc.nextLine();
            if (difficultChoose.isEmpty()) return random.nextInt(3)+1;
        }while (!difficultChoose.equals("1") && !difficultChoose.equals("2") && !difficultChoose.equals("3"));
        return Integer.parseInt(difficultChoose);
    }

    public InputOutputServiceImpl() {
        categoryService = new CategoryServiceImpl();
        sessionService = new SessionServiceImpl();
        sc =  new Scanner(System.in);
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
