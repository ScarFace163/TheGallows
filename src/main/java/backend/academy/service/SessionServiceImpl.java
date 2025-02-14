package backend.academy.service;

import backend.academy.model.Session;
import java.util.ArrayList;
import java.util.List;

public class SessionServiceImpl implements SessionService {

    @Override
    public boolean isGameEnded(Session session) {

        return session.currentAttemptsNumber() >= Session.MAX_ATTEMPTS_NUMBER
            || String.valueOf(session.currentGuess()).equals(String.valueOf(session.answer().value()));
    }

    @Override
    public boolean checkLetter(Session session, String letter) {
        addLetterToLetterList(session, letter);
        if (!letter.isEmpty() && !findLetterPositionInAnswer(session, letter).isEmpty()) {
            return true;
        } else {
            session.currentAttemptsNumber(session.currentAttemptsNumber() + 1);
        }
        return false;
    }

    @Override
    public void putLetter(Session session, String letter) {
        for (int i : findLetterPositionInAnswer(session, letter)) {
            session.currentGuess()[i] = Character.toLowerCase(letter.charAt(0));
        }
    }

    @Override
    public void useHint(Session session) {
        session.isHintUsed(true);
        session.currentAttemptsNumber(session.currentAttemptsNumber() + 2);
    }

    @Override
    public boolean checkLetterInSet(Session session, String letter) {
        if (letter.length() != 1) {
            return false;
        }
        if (session.usedLettersSet().contains(letter.charAt(0))) {
            return false;
        }
        return Character.isLetter(letter.charAt(0));
    }

    private List<Integer> findLetterPositionInAnswer(Session session, String letter) {
        char[] answerValue = session.answer().value();
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < answerValue.length; i++) {
            if (answerValue[i] == Character.toLowerCase(letter.charAt(0))) {
                positions.add(i);
            }
        }
        return positions;
    }

    private void addLetterToLetterList(Session session, String letter) {
        session.usedLettersSet().add(Character.toLowerCase(letter.charAt(0)));
    }

}
