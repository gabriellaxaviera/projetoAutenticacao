package com.piloto.autenticacao.model;


import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User() {
    }

    public User(Integer id, String cpf, String password) {
        this.id = id;
        this.cpf = cpf;
        this.password = password;
    }

    public User(String cpf,String password) {
        this.cpf = cpf;
        this.password = password;
    }

    public User(User user)
    {
        super();
        this.cpf = cpf;
        this.password = password;
        this.roles = user.getRoles();
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
