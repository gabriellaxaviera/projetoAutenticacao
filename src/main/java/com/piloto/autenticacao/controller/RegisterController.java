package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RegisterController {

    @Autowired
    private RegisterService service;

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST, produces = {"application/json"})
    public String cadastro(@Valid @RequestBody User usuario){

        service.insert(usuario);

        return "Usuário cadastrado";
    }
    
}
