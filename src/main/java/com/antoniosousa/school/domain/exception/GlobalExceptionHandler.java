package com.antoniosousa.school.domain.exception;


import com.antoniosousa.school.domain.exception.cep.CepNotFoundException;
import com.antoniosousa.school.domain.exception.cep.InvalidCepFormatException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden /** I use this to solve problem on Swagger Start**/
public class GlobalExceptionHandler {

    @ExceptionHandler({CepNotFoundException.class})
    public ResponseEntity<String> handleCepNotFound(CepNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler({InvalidCepFormatException.class})
    public ResponseEntity<String> handleInvalidCepFormat(InvalidCepFormatException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
