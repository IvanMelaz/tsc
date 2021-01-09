package com.lotto.generator.exception;

public class UnmatchedSizeException extends IllegalArgumentException {
    int coverSize;
    int numberSize;

    public UnmatchedSizeException(String message, int coverSize, int numberSize) {
        super(String.format("%s coverSize: %d coverSize: %d", message, coverSize, numberSize));
        this.coverSize = coverSize;
        this.numberSize = numberSize;
    }
}
