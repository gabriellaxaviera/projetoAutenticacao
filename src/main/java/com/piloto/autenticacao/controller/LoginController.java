package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity login(@RequestBody UserDto userDto) {

        loginService.login(userDto);

        return ResponseEntity.ok().body("Usuário logado");
    }

}
