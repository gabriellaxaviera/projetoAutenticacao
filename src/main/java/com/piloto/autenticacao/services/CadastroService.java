package com.piloto.autenticacao.services;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    UserRepository repo;

    public void insert(User usuario){

        User userCadastrado = repo.findByCpf(usuario.getCpf());

        if (userCadastrado == null){
            repo.save(usuario);
            System.out.println("OK, CADASTRADO");
        }
        else if (userCadastrado.getCpf() == usuario.getCpf()){
            System.out.println("JA EXISTE");
        }
    }
}
