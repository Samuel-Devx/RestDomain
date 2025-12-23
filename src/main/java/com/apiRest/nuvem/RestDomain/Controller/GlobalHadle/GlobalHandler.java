package com.apiRest.nuvem.RestDomain.Controller.GlobalHadle;

import com.apiRest.nuvem.RestDomain.Model.User;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URI;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalHandler.class);

    @ExceptionHandler(ExistingUser.class)
    public ResponseEntity<String> existingUser(ExistingUser existingUser){
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_CONTENT)
                .body(existingUser.getMessage());
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrity(DataIntegrityViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Card number already exists");
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuch(NoSuchElementException ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Resource Id not found.");
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedExeption(Throwable unexpectedExeption){
        String message = "Unexpected server error, see the logs";
        logger.error("Unexpected error", unexpectedExeption);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message);
    }




}
