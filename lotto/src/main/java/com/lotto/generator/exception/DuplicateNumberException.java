package com.lotto.generator.exception;

public class DuplicateNumberException extends IllegalArgumentException {
    int duplicateItem;
    public DuplicateNumberException(String message,int duplicateItem) {
        super(String.format("%s %d", message, duplicateItem));
    }
}
