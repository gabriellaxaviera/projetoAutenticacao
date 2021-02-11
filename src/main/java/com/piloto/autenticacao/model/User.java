package com.piloto.autenticacao.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private String cpf;
    private String senha;

    public User() {
    }

    public User(String cpf, String senha) {
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


}
