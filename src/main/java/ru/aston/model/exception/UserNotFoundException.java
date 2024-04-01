package main.java.ru.aston.model.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }

}