package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.services.LoginService;
import com.piloto.autenticacao.services.ValidateCPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    private ValidateCPF validate;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity login(@RequestBody UserDto userDto) throws ParseException {

        validate.validateCpf(userDto.getCpf(), userDto);
        return ResponseEntity.ok().body("ok");
    }

}
