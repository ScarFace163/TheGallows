package backend.academy.model;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter public class Session {
    @Setter private char[] currentGuess;
    @Setter private int currentAttemptsNumber;
    private final Set<Character> usedLettersSet;
    private final int maxAttemptsNumber;
    private final Word answer;

    public Session(Word answer) {
        this.answer = answer;
        this.currentGuess = new char[answer.VALUE().length];
        this.currentAttemptsNumber = 0;
        usedLettersSet = new HashSet<>();
        maxAttemptsNumber = 7;
        Arrays.fill(currentGuess, '_');
    }

}
