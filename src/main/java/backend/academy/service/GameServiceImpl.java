package backend.academy.service;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
            int errorLeft = session.maxAttemptsNumber() - session.currentAttemptsNumber();
            outputService.printCurrentLetterInput(session);
            outputService.println("Errors left: " + errorLeft);
            if (errorLeft >= session.minErrorsForHint() && !session.isHintUsed()) {
                outputService.println("Enter letter or -1 if you want a hint");
            } else {
                outputService.println("Enter letter");
            }
            String letter = inputService.input();
            if (errorLeft >= session.minErrorsForHint() && "-1".equals(letter) && !session.isHintUsed()) {
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
        return session.currentAttemptsNumber() != session.maxAttemptsNumber();
    }

    public GameServiceImpl() {
        sessionService = new SessionServiceImpl();
        new Scanner(System.in, StandardCharsets.UTF_8);
        outputService = new OutputServiceImpl();
        inputService = new InputServiceImpl();
    }

}
