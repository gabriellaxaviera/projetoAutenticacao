package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RegisterController {

    @Autowired
    private RegisterService service;

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity registration(@Valid @RequestBody User user){

        service.insert(user);

        return ResponseEntity.ok("User successfully registered");
    }
    
}
