package backend.academy.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter public class Session {
    @Setter private char[] currentGuess;
    @Setter private int currentAttemptsNumber;
    @Setter private boolean isHintUsed;
    private final int minErrorsForHint;
    private final Set<Character> usedLettersSet;
    private final int maxAttemptsNumber;
    private final Word answer;

    @SuppressWarnings("checkstyle:MagicNumber")
    public Session(Word answer) {
        this.answer = answer;
        this.currentGuess = new char[answer.value().length];
        this.currentAttemptsNumber = 0;
        this.isHintUsed = false;
        this.minErrorsForHint = 3;
        this.maxAttemptsNumber = 7;
        this.usedLettersSet = new HashSet<>();
        Arrays.fill(currentGuess, '_');
    }

}
