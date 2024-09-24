package backend.academy.starter;

import backend.academy.model.Session;
import backend.academy.service.GameService;
import backend.academy.service.GameServiceImpl;
import backend.academy.service.OutputService;
import backend.academy.service.OutputServiceImpl;

public class GameStarter implements Starter {
    private final GameService gameService;
    private final Session session;
    private final OutputService outputService;

    @Override
    public void start() {
        if (gameService.conductGameProcess(session)) {
            outputService.print("You win!");
        } else {
            outputService.print("You lose!");
            outputService.print("Answer was: " + String.valueOf(session.answer().value()));
        }
    }

    public GameStarter(Session session) {
        this.session = session;
        gameService = new GameServiceImpl();
        outputService = new OutputServiceImpl();
    }
}
