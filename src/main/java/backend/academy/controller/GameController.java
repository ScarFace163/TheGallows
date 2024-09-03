package backend.academy.controller;

import backend.academy.model.Session;
import backend.academy.service.SessionService;
import backend.academy.service.SessionServiceImpl;
import backend.academy.service.InputOutputService;
import backend.academy.service.InputOutputServiceImpl;
import java.util.Scanner;

public class GameController implements  Controller{
    InputOutputService inputOutputService;
    SessionService sessionService;
    Session session;
    @Override
    public void control() {
        Scanner sc = new Scanner(System.in);
        while (!sessionService.isGameEnded(session)) {
            inputOutputService.printCurrentGameState(session);
            int errorLeft = session.maxAttemptsNumber()-session.currentAttemptsNumber();
            System.out.println("Errors left: " + errorLeft);
            if (errorLeft == 2){
                System.out.println("HINT: " + session.answer().HINT());
            }
            System.out.println("Enter letter");
            String letter = sc.nextLine();
            if (sessionService.checkLetter(session, letter)) sessionService.putLetter(session,letter) ;
        }
        inputOutputService.printCurrentGameState(session);
        if (session.currentAttemptsNumber() == session.maxAttemptsNumber()) System.out.println("You lose");
        else System.out.println("You win");

    }

    public GameController(Session session) {
        this.session = session;
        inputOutputService = new InputOutputServiceImpl();
        sessionService = new SessionServiceImpl();
    }
}
