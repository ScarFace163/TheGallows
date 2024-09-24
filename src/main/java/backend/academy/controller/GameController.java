package backend.academy.controller;

import backend.academy.model.Session;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;

public class GameController implements Controller {
    private final InputOutputService inputOutputService;
    private final Session session;

    @Override
    public void control() {
        if (inputOutputService.conductGameProcess(session)) {
            inputOutputService.print("You win!");
        } else {
            inputOutputService.print("You lose!");
            inputOutputService.print("Answer was: " + String.valueOf(session.answer().value()));
        }
    }

    public GameController(Session session) {
        this.session = session;
        inputOutputService = new InputOutputServiceImpl();
    }
}
