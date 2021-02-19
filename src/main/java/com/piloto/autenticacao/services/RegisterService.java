package com.piloto.autenticacao.services;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.error.CpfExistsException;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRepository repository;

    public void insert(User usuario) {

        User userCadastrado = repository.findByCpf(usuario.getCpf());

        if (userCadastrado == null){
            repository.save(usuario);
        }
        else {
            throw new CpfExistsException("User is already registered");
        }
    }
}
