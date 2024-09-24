package backend.academy.service;

import backend.academy.model.Session;

public interface OutputService {

    void println(String s);

    void print(String s);

    void printCategoryChoose();

    void printDifficultChoose();

    void printCurrentGameState(Session session);

    void printGallows(Session session);

    void printHint(Session session);

    void printCurrentLetterInput(Session session);

    void printCurrentGuess(Session session);
}
