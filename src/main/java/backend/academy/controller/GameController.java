package backend.academy.controller;

import backend.academy.model.Session;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;

public class GameController implements  Controller{
    InputOutputService inputOutputService;
    Session session;
    @Override
    public void control() {
        if (inputOutputService.conductGameProcess(session)) System.out.println("You win!");
        else {
            System.out.println("You lose!");
            System.out.println("Answer was: "+ String.valueOf(session.answer().VALUE()));
        }
    }

    public GameController(Session session) {
        this.session = session;
        inputOutputService = new InputOutputServiceImpl();
    }
}
