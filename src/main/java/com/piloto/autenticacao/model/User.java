package com.piloto.autenticacao.model;


import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CPF
    @NotNull(message = "These fields are required")
    private String cpf;

    @NotNull(message = "These fields are required")
    @Size(min = 8, message = "Try one with at least 8 characters")
    private String senha;

    public User() {
    }

    public User(String cpf, String senha, Integer id) {
        this.cpf = cpf;
        this.senha = senha;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
