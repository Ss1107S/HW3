package main.java.ru.aston.model.exception;

import java.text.MessageFormat;

public class BankCardIsAlreadyAssignedException extends RuntimeException {
    public BankCardIsAlreadyAssignedException(final Long cardId, final Long userId){
        super(MessageFormat.format("BankCard: {0} is already assigned to cart: {1}", cardId, userId));
    }
}