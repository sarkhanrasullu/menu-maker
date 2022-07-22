package com.company.menumaker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class FileExtensionNotMatchException extends RuntimeException{
    public FileExtensionNotMatchException(String message) {
        super(message);
    }
}
