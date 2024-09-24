package backend.academy.service;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;

public interface InputOutputService {
    String printCategoryChoose();

    Difficult printDifficultChoose();

    void printCurrentGameState(Session session);

    boolean conductGameProcess(Session session);

    void println(String s);

    void print(String s);
}
