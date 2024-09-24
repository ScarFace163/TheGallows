package backend.academy.service;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;


public class GameServiceImpl implements GameService {
    private final SessionService sessionService;
    private final OutputService outputService;
    private final InputService inputService;

    @Override
    public String categoryChoose() {
        outputService.printCategoryChoose();
        return inputService.inputCategoryNumber();
    }

    @Override
    public Difficult difficultChoose() {
        outputService.printDifficultChoose();
        return Difficult.values()[inputService.inputDifficultNumber()];
    }

    @Override
    public boolean conductGameProcess(Session session) {
        while (!sessionService.isGameEnded(session)) {
            outputService.printCurrentGameState(session);
            int errorLeft = Session.MAX_ATTEMPTS_NUMBER - session.currentAttemptsNumber();
            outputService.printCurrentLetterInput(session);
            outputService.println("Errors left: " + errorLeft);
            if (errorLeft >= Session.MIN_ERRORS_FOR_HINT && !session.isHintUsed()) {
                outputService.println("Enter letter or -1 if you want a hint");
            } else {
                outputService.println("Enter letter");
            }
            String letter = inputService.input();
            if (errorLeft >= Session.MIN_ERRORS_FOR_HINT && "-1".equals(letter) && !session.isHintUsed()) {
                outputService.printHint(session);
                continue;
            }
            if (!sessionService.checkLetterInSet(session, letter)) {
                continue;
            }
            if (sessionService.checkLetter(session, letter)) {
                sessionService.putLetter(session, letter);
            }
        }
        outputService.printCurrentGameState(session);
        return session.currentAttemptsNumber() != Session.MAX_ATTEMPTS_NUMBER;
    }

    public GameServiceImpl() {
        sessionService = new SessionServiceImpl();
        outputService = new OutputServiceImpl();
        inputService = new InputServiceImpl();
    }

}
