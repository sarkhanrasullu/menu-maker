package com.company.menumaker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PageNotFoundException extends RuntimeException{
    public PageNotFoundException(String message){
        super(message);
    }
}
