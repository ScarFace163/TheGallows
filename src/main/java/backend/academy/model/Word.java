package backend.academy.model;

import backend.academy.enums.Difficult;
import lombok.Getter;

@Getter public class Word {
    private final char[] value;
    private final String hint;
    private final Difficult difficult;

    public Word(char[] value, String hint, Difficult difficult) {
        this.value = value;
        this.hint = hint;
        this.difficult = difficult;
    }

}
