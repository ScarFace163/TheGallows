package backend.academy.model;

import lombok.Getter;

@Getter public class Word {
    private final char[] value;
    private final String hint;
    private final int difficult;

    public Word(char[] value, String hint, int difficult) {
        this.value = value;
        this.hint = hint;
        this.difficult = difficult;
    }

}
