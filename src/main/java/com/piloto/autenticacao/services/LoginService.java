package com.piloto.autenticacao.services;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.error.NotAuthorizedException;
import com.piloto.autenticacao.error.ResourceNotFoundException;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    UserRepository repository;

    public void login(UserDto userDto) {

        User usuario = repository.findByCpf(userDto.getCpf());

        if (usuario == null)
        {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
        else
        {
            if (!(usuario.getSenha().equals(userDto.getSenha())))
                throw new NotAuthorizedException("Senha inválida");
        }

    }
}
