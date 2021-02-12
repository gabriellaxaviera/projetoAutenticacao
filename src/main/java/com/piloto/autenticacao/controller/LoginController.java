package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.services.LoginService;
<<<<<<< HEAD
=======
import com.piloto.autenticacao.auxiliares.ValidateCPF;
>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
<<<<<<< HEAD
    // private ValidateCPF validate;
=======
    @Autowired
    private ValidateCPF validate;
>>>>>>> 8429a9ec5f79ebfcb7ce059d688f76f8fa6e0f2d

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity login(@RequestBody UserDto userDto) {

        //validate.validateCpf(userDto.getCpf(), userDto);
        return ResponseEntity.ok().body("ok");
    }

}
