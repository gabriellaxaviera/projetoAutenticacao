package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.config.Roles;
import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Secured({Roles.ROLE_ADMIN})
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity login(@Valid @RequestBody UserDto userDto) {
        loginService.login(userDto);
        return ResponseEntity.ok().body("You have successfully logged in");
    }
}
