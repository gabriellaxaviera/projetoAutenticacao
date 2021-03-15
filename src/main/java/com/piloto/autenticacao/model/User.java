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
    private String password;

    public User() {
    }

    public User(String cpf, String password, Integer id) {
        this.cpf = cpf;
        this.password = password;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
