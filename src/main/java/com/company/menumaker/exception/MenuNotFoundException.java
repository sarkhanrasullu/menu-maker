package com.company.menumaker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MenuNotFoundException extends RuntimeException{
    public MenuNotFoundException(String message){
        super(message);
    }

}
