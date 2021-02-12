package com.piloto.autenticacao.handler;

import com.piloto.autenticacao.error.CpfExistsException;
import com.piloto.autenticacao.error.ExceptionDetails;
import com.piloto.autenticacao.error.NotAuthorizedException;
import com.piloto.autenticacao.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {

        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CpfExistsException.class)
    public ResponseEntity<?> handleCpfExistsException(CpfExistsException exception) {

        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<?> handleNotAuthorizedException(NotAuthorizedException exception) {

        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNAUTHORIZED);
    }

}
