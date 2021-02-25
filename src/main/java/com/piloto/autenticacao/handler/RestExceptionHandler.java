package com.piloto.autenticacao.handler;

import com.piloto.autenticacao.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import javax.validation.UnexpectedTypeException;

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

    @ExceptionHandler(HttpMediaTypeException.class)
    public ResponseEntity<?> handleMediaType(HttpMediaTypeException media){

        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(media.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleRequestMethod(HttpRequestMethodNotSupportedException media){

        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(media.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleArgument(MethodArgumentTypeMismatchException argument){

        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(argument.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<?> handleValid(UnexpectedTypeException valid){
        ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                .newBuilder()
                .message(valid.getMessage())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleCPFvalid(MethodArgumentNotValidException valid){

        if (valid.getMessage().contains("default message [invalid Brazilian individual taxpayer registry number (CPF)]]"))
        {
            ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                    .newBuilder()
                    .message("Invalid taxpayer identification numbers")
                    .build();

            return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
        }

        else if (valid.getMessage().contains("default message [Try one with at least 8 characters]]"))
        {
            ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                    .newBuilder()
                    .message("Try one with at least 8 characters")
                    .build();

            return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
        }

        else if (valid.getMessage().contains("default message [This field is required]]")) {
            ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder
                    .newBuilder()
                    .message("These field are required")
                    .build();
            return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
