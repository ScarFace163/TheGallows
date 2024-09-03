package backend.academy.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;

@Getter public class Session {
    @Setter private char[] currentGuess;
    @Setter private int currentAttemptsNumber;
    private final int maxAttemptsNumber;
    private final Word answer;


    public Session(Word answer) {
        this.answer = answer;
        this.currentGuess = new char[answer.VALUE().length];
        this.currentAttemptsNumber = 0;
        maxAttemptsNumber = 7;
        //this.maxAttemptsNumber = answer.VALUE().length;

        Arrays.fill(currentGuess,'_');
    }

}
