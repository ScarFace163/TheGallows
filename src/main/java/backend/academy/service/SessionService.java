package backend.academy.service;

import backend.academy.model.Session;

public interface SessionService {
    boolean isGameEnded(Session session);

    boolean checkLetter(Session session, String letter);

    void putLetter(Session session, String letter);

    void useHint(Session session);

    boolean checkLetterInSet(Session session, String letter);
}
