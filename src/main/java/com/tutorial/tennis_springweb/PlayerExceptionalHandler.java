package com.tutorial.tennis_springweb;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionalHandler {

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(PlayerNotFoundException exception, HttpServletRequest req){

        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse(ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), exception.getMessage());

        return new ResponseEntity<>(playerErrorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> genericExceptionHandler(Exception ex, HttpServletRequest req) {
        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), ex.getMessage());

        return new ResponseEntity<>(playerErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
