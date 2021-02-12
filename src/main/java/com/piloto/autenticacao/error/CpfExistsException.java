package com.piloto.autenticacao.error;

public class CpfExistsException extends RuntimeException{

    public CpfExistsException(String message) {
        super(message);
    }
}
