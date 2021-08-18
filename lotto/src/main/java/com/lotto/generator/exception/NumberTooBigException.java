package com.lotto.generator.exception;

public class NumberTooBigException extends IllegalArgumentException {
    int duplicateItem;
    public NumberTooBigException(String message, int value) {
        super(String.format("%s %d", message, value));
    }
}
