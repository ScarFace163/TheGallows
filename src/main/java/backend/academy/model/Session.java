package backend.academy.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter public class Session {
    @Setter private char[] currentGuess;
    @Setter private int currentAttemptsNumber = 0;
    @Setter private boolean isHintUsed;
    public final static int MIN_ERRORS_FOR_HINT = 3;
    public final static int MAX_ATTEMPTS_NUMBER = 7;
    private final Set<Character> usedLettersSet;
    private final Word answer;

    public Session(Word answer) {
        this.answer = answer;
        this.currentGuess = new char[answer.value().length];
        this.isHintUsed = false;
        this.usedLettersSet = new HashSet<>();
        Arrays.fill(currentGuess, '_');
    }

}
