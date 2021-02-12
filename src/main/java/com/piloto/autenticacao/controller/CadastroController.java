package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.CadastroService;
<<<<<<< HEAD
=======
import com.piloto.autenticacao.auxiliares.ValidateCPF;
>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CadastroController {

    @Autowired
    private CadastroService service;
<<<<<<< HEAD
    //private ValidateCPF validate;
=======
    @Autowired
    private ValidateCPF validate;
>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<User> cadastro(@RequestBody User usuario){
        User cadastro = service.insert(usuario);

        //validate.validateCpf(usuario.getCpf(), usuario);
        //service.insert(usuario);
        return ResponseEntity.ok().body(usuario);
    }
    
}
