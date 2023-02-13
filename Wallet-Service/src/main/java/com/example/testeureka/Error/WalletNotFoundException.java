package com.example.testeureka.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WalletNotFoundException extends RuntimeException {

    public WalletNotFoundException(String message) {
        super(message);
    }
}
