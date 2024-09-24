package backend.academy.controller;

import backend.academy.model.Session;
import backend.academy.service.GameService;
import backend.academy.service.GameServiceImpl;
import backend.academy.service.OutputService;
import backend.academy.service.OutputServiceImpl;

public class GameController implements Controller {
    private final GameService gameService;
    private final Session session;
    private final OutputService outputService;

    @Override
    public void control() {
        if (gameService.conductGameProcess(session)) {
            outputService.print("You win!");
        } else {
            outputService.print("You lose!");
            outputService.print("Answer was: " + String.valueOf(session.answer().value()));
        }
    }

    public GameController(Session session) {
        this.session = session;
        gameService = new GameServiceImpl();
        outputService = new OutputServiceImpl();
    }
}
