package com.piloto.autenticacao.controller;

import com.piloto.autenticacao.config.JwtHelper;
import com.piloto.autenticacao.config.LoginResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthController {

    private final JwtHelper jwtHelper;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtHelper jwtHelper, UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder) {
        this.jwtHelper = jwtHelper;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/auth", method=RequestMethod.POST, consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public LoginResult auth(@RequestParam String username, @RequestParam String password) {

        UserDetails userDetails;
        try {
            userDetails = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }

        if (passwordEncoder.matches(password, userDetails.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("username", username);

            String authorities = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));
            claims.put("authorities", authorities);
            claims.put("userId", String.valueOf(1));

            String jwt = jwtHelper.createJwtForClaims(username, claims);
            return new LoginResult(jwt);
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
    }
}
