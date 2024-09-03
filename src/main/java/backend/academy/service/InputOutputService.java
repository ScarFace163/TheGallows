package backend.academy.service;

import backend.academy.model.Session;

public interface InputOutputService {
    String printCategoryChoose();
    int printDifficultChoose();
    void printCurrentGameState(Session session);
    boolean conductGameProcess(Session session);
}
