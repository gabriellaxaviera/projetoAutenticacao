package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //@Autowired
    // private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity test() {
        return ResponseEntity.ok("Funfou!");
    }

}
