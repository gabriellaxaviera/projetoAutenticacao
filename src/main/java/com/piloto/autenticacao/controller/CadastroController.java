package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.CadastroService;
import com.piloto.autenticacao.services.ValidateCPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CadastroController {

    @Autowired
    private CadastroService service;
    private ValidateCPF validate;

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<User> cadastro(@RequestBody User usuario){

        validate.validateCpf(usuario.getCpf(), usuario);
        //service.insert(usuario);
        return ResponseEntity.ok().body(usuario);
    }
    
}
