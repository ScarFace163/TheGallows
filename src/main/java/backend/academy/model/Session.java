package backend.academy.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter public class Session {
    @Setter private char[] currentGuess;
    @Setter private int currentAttemptsNumber;
    private final Set<Character> usedLettersSet;
    private final int maxAttemptsNumber = 7;
    private final Word answer;

    public Session(Word answer) {
        this.answer = answer;
        this.currentGuess = new char[answer.value().length];
        this.currentAttemptsNumber = 0;
        usedLettersSet = new HashSet<>();
        Arrays.fill(currentGuess, '_');
    }

}
