package backend.academy.service;

import backend.academy.enums.Difficult;
import backend.academy.model.Session;

public interface GameService {
    String categoryChoose();

    Difficult difficultChoose();

    boolean conductGameProcess(Session session);

}
