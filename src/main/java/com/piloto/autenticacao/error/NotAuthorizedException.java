package com.piloto.autenticacao.error;

public class NotAuthorizedException extends RuntimeException{

    public NotAuthorizedException(String message) {
        super(message);
    }
}
