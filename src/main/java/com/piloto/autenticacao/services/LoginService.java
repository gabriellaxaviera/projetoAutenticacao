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

        User user = repository.findByCpf(userDto.getCpf());

        if (user == null)
        {
            throw new ResourceNotFoundException("User not found");
        }
        else
        {
            if (!(user.getPassword().equals(userDto.getPassword())))
                throw new NotAuthorizedException("Invalid password");
        }
    }
}
