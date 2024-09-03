package backend.academy.model;

import lombok.Getter;

@Getter public class Word {
    private final char[] VALUE;
    private final String HINT;
    private final int DIFFICULT;

    public Word(char[] VALUE, String HINT, int DIFFICULT) {
        this.VALUE = VALUE;
        this.HINT = HINT;
        this.DIFFICULT = DIFFICULT;
    }

}
