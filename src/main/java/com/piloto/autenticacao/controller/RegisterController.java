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

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json"})
    public String registration(@Valid @RequestBody User user){

        service.insert(user);

        return "User registered successfully";
    }
    
}
