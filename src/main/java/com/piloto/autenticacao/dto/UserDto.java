package com.piloto.autenticacao.dto;

import com.piloto.autenticacao.model.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    private String cpf;
    private String senha;

    public UserDto(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserDto(User user) {
        cpf = user.getCpf();
        senha = user.getSenha();
    }
}
