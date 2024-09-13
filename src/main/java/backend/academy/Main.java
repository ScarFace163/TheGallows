package backend.academy;

import backend.academy.controller.MainController;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    MainController mainController;

    public static void main(String[] args) {
        mainController = new MainController();
        mainController.control();
    }
}

