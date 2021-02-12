package com.piloto.autenticacao.model;

<<<<<<< HEAD
import org.hibernate.annotations.NotFound;
=======
>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
<<<<<<< HEAD
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
=======
import javax.validation.constraints.Pattern;
>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
<<<<<<< HEAD
    @NotNull(message = "Por favor, adicione um CPF")
    @CPF
    private String cpf;
    @NotNull(message = "Por favor, adicione uma senha")
=======

    @CPF
    private String cpf;

>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d
    @Min(8)
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
