package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CadastroController {

    @Autowired
    private CadastroService service;

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<User> cadastro(@RequestBody User usuario){

        service.insert(usuario);
        return ResponseEntity.ok().body(usuario);
    }
    
}
