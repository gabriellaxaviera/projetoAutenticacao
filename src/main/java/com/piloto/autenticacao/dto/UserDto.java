package com.piloto.autenticacao.dto;

import com.piloto.autenticacao.model.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    private String cpf;
    private String password;

    public UserDto() {
    }

    public UserDto(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto(User user) {
        cpf = user.getCpf();
        password = user.getPassword();
    }
}
