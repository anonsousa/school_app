package com.antoniosousa.school.domain.exception.cep;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCepFormatException extends IllegalArgumentException{
    public InvalidCepFormatException(String message) {
        super(message);
    }
}
