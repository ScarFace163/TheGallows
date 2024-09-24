package backend.academy.model;

import backend.academy.enums.Difficult;

public record Word(char[] value, String hint, Difficult difficult) {}
