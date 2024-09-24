package backend.academy;

import backend.academy.starter.MainStarter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    MainStarter mainController;

    public static void main(String[] args) {
        mainController = new MainStarter();
        mainController.start();
    }
}

